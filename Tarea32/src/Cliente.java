import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.*;
import java.util.ArrayList;

public class Cliente {
    public static void main(String[] args) {
        ArrayList<String> bufferOfBuffers = new ArrayList<>();
        int server_port = 6666;
        try {
            InetAddress address = InetAddress.getByName("localhost");
            try (DatagramSocket datagramSocket = new DatagramSocket()) {
               bufferOfBuffers.add("Pensador");
               bufferOfBuffers.add("Especimen");
               bufferOfBuffers.add("Estandarizado");
               bufferOfBuffers.add("Creador");
               bufferOfBuffers.add("Espiritoso");
               ByteArrayOutputStream bos = new ByteArrayOutputStream(); // Crea un buffer para serializar un objeto a Bytes así puedo pasarle cualquier lista, ya que siendo stateless no puedo pasar las palabras una por una y que recuerde las anteriores
               ObjectOutputStream oos = new ObjectOutputStream(bos); // Uso el ByteArray este como OutputStream en ObjectOutputStream
               oos.writeObject(bufferOfBuffers); // Escribo la lista de palabras en en object Output Stream
               byte[] data = bos.toByteArray(); // Luego uso el ByteArrayOutputStream para transformar la lista serializada a bytes
               oos.close(); // Cierro el ObjectOutputStream
               DatagramPacket packet = new DatagramPacket(data,data.length,address,server_port);
               datagramSocket.send(packet); // Envio el paquete con la lista de palabras
               datagramSocket.receive(packet); // Recibimos la informacion
               String resp = new String(packet.getData(),0,packet.getLength()); // En este caso la informacion es la palabra más larga de la lista
               System.out.println(resp); // Imprimimos la respuesta
            } catch (SocketException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                System.out.println("Problema de entrada salida");
            }
        } catch (UnknownHostException e) {
            System.out.println(e.getMessage());
        }
    }
}
