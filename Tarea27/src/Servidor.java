import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Servidor {
    public static void main(String[] args) {
        InetSocketAddress dir = new InetSocketAddress("localhost",8000);
        try (ServerSocket server = new ServerSocket()) {
            server.bind(dir);
            System.out.println("Esperando conexion");
            Socket socket = server.accept();
            System.out.println("Conexion realizada");
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(),true);
            while (true) {
                String linea = reader.readLine();
                if (linea == null || linea.equalsIgnoreCase("adios")) {
                    break;
                }
                writer.println("ECO: " + linea);
            }
        } catch (IOException e) {
            System.out.println("Problemas");
        }
    }
}