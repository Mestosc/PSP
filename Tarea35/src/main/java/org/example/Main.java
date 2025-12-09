package org.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static final List<Moneda> monedaMap = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        generarDiccionarioMonedaID();
        Gson gson = new Gson();
        System.out.print("Introduzca el simbolo o nombre de la moneda: ");
        String moneda = scanner.next();

        try (HttpClient client = HttpClient.newHttpClient()) {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(crearURL(moneda)))
                    .header("Content-Type","application/json")
                    .GET()
                    .build();
            HttpResponse<String> respuesta = client.send(request,HttpResponse.BodyHandlers.ofString());
            String json = respuesta.body();
            CriptoMoneda[] criptoMoneda = gson.fromJson(json,CriptoMoneda[].class);
            if (criptoMoneda == null || criptoMoneda.length == 0) {
                System.out.println("No hay criptos");
                return;
            }
            for (CriptoMoneda moneda1 : criptoMoneda) {
                String nombre = moneda1.getName();
                String simbolo = moneda1.getSymbol();
                String precioDolares = moneda1.getPriceUsd();
                int ranking = moneda1.getRank();
                String variacion24h = moneda1.getPercentChange24h();
                System.out.println("Nombre: " + nombre);
                System.out.println("Simbolo: " + simbolo);
                System.out.println("Precio Dolares: " + precioDolares+"$");
                System.out.println("Ranking:" + ranking);
                if (variacion24h.startsWith("-")) {
                    variacion24h = "\033[31m" + variacion24h + "\033[0m";
                } else {
                    variacion24h = "\033[32m" + variacion24h + "\033[0m";
                }
                System.out.println("Variacion 24h: " +variacion24h);
            }

        } catch (IOException e) {
            System.out.println("Problemas de entrada salida " + e);
        } catch (InterruptedException e) {
            System.out.println("Problemas diversos " + e);
        } catch (RuntimeException e) {
            System.out.println("Otros problemas " + e);
        }
    }
    public static String crearURL(String moneda) {
        String id = obtenerID(moneda);
        if (id==null) {
            throw new RuntimeException("Error no existe un ID");
        }
        return "https://api.coinlore.net/api/ticker/?id="+id;
    }
    public static String obtenerID(String moneda) {
        for (Moneda ticker : monedaMap) {
            if (ticker.simbolo().equalsIgnoreCase(moneda)) {
                return ticker.id();
            }
        }

        // 2. Buscar por NOMBRE (Bitcoin, Ethereum)
        for (Moneda ticker : monedaMap) {
            if (ticker.nombre().equalsIgnoreCase(moneda)) {
                return ticker.id();
            }
        }

        return null; // No encontrado
    }
    public static void generarDiccionarioMonedaID() {
        Gson gson = new Gson();
        try (HttpClient client = HttpClient.newHttpClient()) {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.coinlore.net/api/tickers/?start=0&limit=100"))
                .build();
        String json = client.send(request, HttpResponse.BodyHandlers.ofString()).body();
        Monedas tickers = gson.fromJson(json,Monedas.class);
        for (CriptoMoneda moneda : tickers.monedas) {
            monedaMap.add(new Moneda(moneda.getId(),moneda.getSymbol(),moneda.getName()));
        }
        } catch (Exception e) {
            System.out.println("Problemas " + e);
        }
    }
}