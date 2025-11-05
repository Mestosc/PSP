import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args) {
        InetSocketAddress dir = new InetSocketAddress("localhost",8000);
        try (Socket socket = new Socket()) {
            socket.connect(dir);
            System.out.println("Conectando al servidor");
           BufferedReader lector = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter escritor = new PrintWriter(socket.getOutputStream(),true);
            escritor.println("Mensaje 1");
            String mensaje1 = lector.readLine();
            escritor.println("Mensaje 2");
            String mensaje2 = lector.readLine();
            escritor.println("Mensaje 3");
            String mensaje3 = lector.readLine();
           System.out.println("El servidor dice " + mensaje1);
            System.out.println("El servidor dice " + mensaje2);
            System.out.println("El servidor dice " + mensaje3);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
