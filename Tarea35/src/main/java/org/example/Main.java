package org.example;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Moneda> monedas = generarListaMonedasDisponibles().orElseGet(ArrayList::new);
        System.out.print("Introduzca el simbolo o nombre de la moneda: ");
        String moneda = scanner.next();

        try (HttpClient client = HttpClient.newHttpClient()) {
            CriptoMoneda[] criptoMoneda = getCriptoMonedas(moneda, client,monedas);
            mostrarMonedas(criptoMoneda);
        } catch (IOException e) {
            System.out.println("Problemas de entrada salida " + e);
        } catch (InterruptedException e) {
            System.out.println("Problemas diversos " + e);
        } catch (RuntimeException e) {
            System.out.println("Otros problemas " + e);
        }
    }

    private static void mostrarMonedas(CriptoMoneda[] criptoMoneda) {
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
            System.out.println("Ranking: " + ranking);
            if (variacion24h.startsWith("-")) {
                variacion24h = "\033[31m" + variacion24h + "\033[0m";
            } else {
                variacion24h = "\033[32m" + variacion24h + "\033[0m";
            }
            System.out.println("Variacion 24h: " +variacion24h);
        }
    }

    private static CriptoMoneda[] getCriptoMonedas(String moneda, HttpClient client,ArrayList<Moneda> monedaMap) throws IOException, InterruptedException {
        Gson gson = new Gson();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(crearURL(moneda,monedaMap)))
                .header("Content-Type","application/json")
                .GET()
                .build();
        HttpResponse<String> respuesta = client.send(request,HttpResponse.BodyHandlers.ofString());
        String json = respuesta.body();
        return gson.fromJson(json,CriptoMoneda[].class);
    }

    public static String crearURL(String moneda,ArrayList<Moneda> monedaMap) {
        String id = obtenerID(moneda,monedaMap).orElseThrow(() -> new RuntimeException("No se pudo obtener el ID"));
        return "https://api.coinlore.net/api/ticker/?id="+id;
    }
    public static Optional<String> obtenerID(String moneda,ArrayList<Moneda> monedaMap) {
        for (Moneda ticker : monedaMap) {
            if (ticker.simbolo().equalsIgnoreCase(moneda)) {
                return Optional.of(ticker.id());
            }
        }

        // 2. Buscar por NOMBRE (Bitcoin, Ethereum)
        for (Moneda ticker : monedaMap) {
            if (ticker.nombre().equalsIgnoreCase(moneda)) {
                return Optional.of(ticker.id());
            }
        }

        return Optional.empty(); // No encontrado
    }
    public static Optional<ArrayList<Moneda>> generarListaMonedasDisponibles() {
        Gson gson = new Gson();
        try (HttpClient client = HttpClient.newHttpClient()) {

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.coinlore.net/api/tickers/?start=0&limit=100"))
                    .build();
            String json = client.send(request, HttpResponse.BodyHandlers.ofString()).body();
            CriptoMoneda[] tickers = gson.fromJson(json,CriptoMoneda[].class);
            ArrayList<Moneda> monedas = new ArrayList<>();
            for (CriptoMoneda moneda : tickers) {
                monedas.add(new Moneda(moneda.getId(),moneda.getSymbol(),moneda.getName()));
            }
            return Optional.of(monedas);
        } catch (Exception e) {
            System.out.println("Problemas " + e);
        }
        return Optional.empty();
    }
}