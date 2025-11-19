import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;

public class Servidor {
    public static void main(String[] args) {
        byte[] buffer = new byte[1024];
        try (DatagramSocket datagramSocket = new DatagramSocket(6666)) {
            DatagramPacket packet = new DatagramPacket(buffer,buffer.length);
            datagramSocket.receive(packet);
            int puerto = packet.getPort();
            InetAddress address = packet.getAddress();
            ByteArrayInputStream bais = new ByteArrayInputStream(packet.getData());
            ObjectInputStream ois = new ObjectInputStream(bais);
            Object ob = ois.readObject();
            ois.close();
            if (ob instanceof ArrayList<?> palabras) { // Comprobamos que estamos tratando con un ArrayList
                String palabraMasLarga = getPalabraMasLarga(palabras);
                buffer = palabraMasLarga.getBytes();
                DatagramPacket datagramPacket = new DatagramPacket(buffer,buffer.length,address,puerto);
                datagramSocket.send(datagramPacket);
            }
        } catch (SocketException e) {
            System.out.println("Problemas con el socket");
        } catch (IOException e) {
            System.out.println("Problema de entrada salida");
        } catch (ClassNotFoundException e) {
            System.out.println("Lista enviada");
        }
    }

    private static String getPalabraMasLarga(ArrayList<?> palabras) {
        String palabraMasLarga = (String) palabras.getFirst(); // Obtenemos la primera palabra y la convertimos a String
        for (Object object : palabras) { // Recorremos el Array que al no saber el tipo es de Object
            if (object instanceof String palabra) { // Si el elemento es un String
                if (palabra.length()>palabraMasLarga.length()) { // Comprobamos si la palabra es más larga que la palabra más larga en cuyo caso
                    palabraMasLarga = palabra; // Asignamos palabraMasLarga a palabra
                }
            }
        }
        return palabraMasLarga;
    }
}
