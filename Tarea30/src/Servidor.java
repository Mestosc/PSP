import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Servidor {
    public static void main(String[] args) {
        int puerto = 6666;
        byte[] buffer = new byte[2048];
        try (DatagramSocket socket = new DatagramSocket(puerto)) {
            DatagramPacket peticion = new DatagramPacket(buffer,buffer.length);
            socket.receive(peticion);
            int puertoCliente = peticion.getPort();
            InetAddress direccion = peticion.getAddress();
            buffer = "Mensaje 1: Pierde".getBytes();
            DatagramPacket respuesta1 = new DatagramPacket(buffer,buffer.length,direccion,puertoCliente);
            socket.send(respuesta1);
            DatagramPacket peticion1 = new DatagramPacket(buffer,buffer.length);
            socket.receive(peticion1);
            int puertoCliente1 = peticion.getPort();
            InetAddress direccion1 = peticion.getAddress();
            buffer = "Mensaje 2: La".getBytes();
            DatagramPacket respuesta2 = new DatagramPacket(buffer,buffer.length,direccion1,puertoCliente1);
            socket.send(respuesta2);
            DatagramPacket peticion2 = new DatagramPacket(buffer,buffer.length);
            socket.receive(peticion2);
            int puertoCliente2 = peticion.getPort();
            InetAddress direccion2 = peticion.getAddress();
            buffer = "Mensaje 3: Cabeza".getBytes();
            DatagramPacket respuesta3 = new DatagramPacket(buffer,buffer.length,direccion2,puertoCliente2);
            socket.send(respuesta3);

        } catch (SocketException e) {
            System.out.println("Error de socket");
        } catch (IOException e) {
            System.out.println("Problemas de entrada salida");
        }
    }
}
