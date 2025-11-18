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
               ByteArrayOutputStream bos = new ByteArrayOutputStream();
               ObjectOutputStream oos = new ObjectOutputStream(bos);
               oos.writeObject(bufferOfBuffers);
               byte[] data = bos.toByteArray();
               oos.close();
               DatagramPacket packet = new DatagramPacket(data,data.length,address,server_port);
               datagramSocket.send(packet);
               datagramSocket.receive(packet);
               String resp = new String(packet.getData(),0,packet.getLength());
               System.out.println(resp);
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
