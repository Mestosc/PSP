import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String url1 = sc.next();
        String url2 = sc.next();
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request1 = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(url1))
                .build();
        HttpRequest request2 = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(url2))
                .build();
        MetricasRespuesta respuesta1 = procesarPeticion(httpClient,request1);
        MetricasRespuesta respuesta2 = procesarPeticion(httpClient,request2);
        if (respuesta1.url() == null || respuesta2.url()==null) {
            System.out.println("Alguna de las peticiones fallo");
            return;
        }
        MetricasRespuesta respuestaMasRapida = (respuesta1.tiempoRespuesta()> respuesta2.tiempoRespuesta()) ? respuesta1 : respuesta2;
        MetricasRespuesta respuestaMasContenido = (respuesta1.tamanoPeticionBytes()> respuesta2.tamanoPeticionBytes()) ? respuesta1 : respuesta2;
        System.out.printf("La web más rapida ha sido %s con %,d ms%n", respuestaMasRapida.url(),respuestaMasRapida.tiempoRespuesta());
        System.out.printf("La web con más contenido ha sido %s con %d%n", respuestaMasContenido.url(),respuestaMasContenido.tamanoPeticionBytes());
        sc.close();
    }
    public static MetricasRespuesta procesarPeticion(HttpClient client, HttpRequest request) {
        long startTime = System.currentTimeMillis();
        try {
            HttpResponse<byte[]> response = client.send(request,HttpResponse.BodyHandlers.ofByteArray());
            long endTime = System.currentTimeMillis();
            int tamanoBytes = response.body().length;
            return new MetricasRespuesta(endTime-startTime,tamanoBytes,response.uri());
        } catch (Exception e) {
            System.out.println("Problemas con las solicitudes");
        }
        return new MetricasRespuesta(0L,0,null);
    }
}