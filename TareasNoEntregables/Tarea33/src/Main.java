import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        HttpClient client = HttpClient.newHttpClient();
        Scanner sc = new Scanner(System.in);
        String url = sc.next();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
        try {
            HttpResponse<Path> response = client.send(request,HttpResponse.BodyHandlers.ofFile(Paths.get("inspector.html")));
            System.out.println(response.statusCode());
            System.out.println(response.headers().firstValue("content-type").orElse("No se ha encontrado valor"));
        } catch (Exception e) {
            System.out.println("Problemas varios");
        }
        sc.close();
    }
}