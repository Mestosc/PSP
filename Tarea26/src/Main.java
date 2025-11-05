import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        InetSocketAddress dir = new InetSocketAddress("localhost",8000);
        try (ServerSocket server = new ServerSocket()) {
            server.bind(dir);
            System.out.println("Esperando conexion");
            Socket socket = server.accept();
            PrintWriter escritor = new PrintWriter(socket.getOutputStream(),true);
            escritor.println("Respuesta 1");
            escritor.println("Respuesta 2");
            escritor.println("Respuesta 3");
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            reader.lines().forEach(System.out::println);
            socket.close();
        } catch (IOException e) {
            System.out.println("Problema con la salida");
        }
    }
}