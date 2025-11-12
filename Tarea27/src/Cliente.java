import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        InetSocketAddress dir = new InetSocketAddress("localhost",8000);
        String linea;
        Scanner scanner = new Scanner(System.in);
        try (Socket socket = new Socket()) {
            socket.connect(dir);
            PrintWriter writer = new PrintWriter(socket.getOutputStream(),true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (true) {
                System.out.print("Introduzca texto: ");
                linea = scanner.nextLine();
                writer.println(linea);
                if (linea.equalsIgnoreCase("adios")) {
                    break;
                }
                linea = reader.readLine();
                System.out.println(linea);
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("Problemas de entrada salida");
        }
    }
}
