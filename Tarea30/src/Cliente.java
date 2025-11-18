import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        byte[] buffer = new byte[2048];
        Scanner scanner = new Scanner(System.in);
        int server_port = 6666;
        try {
        InetAddress direccionServer = InetAddress.getByName("localhost");
        try (DatagramSocket datagramSocket = new DatagramSocket()) {
            buffer = scanner.nextLine().getBytes();
            DatagramPacket peticion = new DatagramPacket(buffer,buffer.length,direccionServer,server_port);
            datagramSocket.send(peticion);
            datagramSocket.receive(peticion);
            String mensaje1 = new String(peticion.getData(),0,peticion.getLength());
            System.out.println(mensaje1);
            buffer = scanner.nextLine().getBytes();
            DatagramPacket peticion1 = new DatagramPacket(buffer,buffer.length,direccionServer,server_port);
            datagramSocket.send(peticion1);
            datagramSocket.receive(peticion1);
            System.out.println(new String(peticion1.getData(),0,peticion1.getLength()));
            buffer = scanner.nextLine().getBytes();
            DatagramPacket peticion2 = new DatagramPacket(buffer,buffer.length,direccionServer,server_port);
            datagramSocket.send(peticion2);
            datagramSocket.receive(peticion2);
            System.out.println(new String(peticion2.getData(),0,peticion2.getLength()));

        } catch (SocketException e) {
            System.err.println("Error en la creacion del socket");
        } catch (IOException e) {
            System.out.println("Problemas de entrada salida");
        }
        } catch (UnknownHostException e) {
            System.out.println("Error en obtener direccion");
        }
    }
}
