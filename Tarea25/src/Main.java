import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] puertosPopulares = {21, 22, 80, 443};
        String ip;
        int puerto;
        while (true) {
            System.out.print("Introduzca una IP: ");
            ip = sc.next();
            if (ip.equalsIgnoreCase("salir")) {
                break;
            }
            System.out.print("Introduzca un puerto (Omitir escribiendo 0, esto revisara los puertos más populares): ");
            puerto = sc.nextInt();
            if (!esIPValida(ip)) {
                System.out.println("IP no valida");
                continue;
            }
            if (puerto==0) {
                for (int puertoPopular : puertosPopulares) {
                    comprobarPuerto(ip,puertoPopular);
                }
            } else {
                comprobarPuerto(ip, puerto);
            }
        }

    }

    /**
     * Comprueba si un puerto en un determinado servidor esta disponible para conectarse
     * @param ip la ip del servidor a comprobar
     * @param puerto el puerto a comprobar
     */
    private static void comprobarPuerto(String ip, int puerto) {
        try (Socket socket = new Socket(ip, puerto)) {
            if (socket.isConnected()) {
                System.out.println("Conexion exitosa. El puerto " + puerto + " disponible");
            }
        } catch (IOException e) {
            System.out.println("Problemas de conexion, puerto "+ puerto + " no disponible");
        }
    }

    /**
     * Verifica si la direccion IP es valida
     * @param ip la direccion IP a comprobar
     * @return si es valida o no
     */
    public static boolean esIPValida(String ip) {
        try {
            InetAddress inet = InetAddress.getByName(ip);
            return inet.getHostAddress().equals(ip); // asegura formato exacto
        } catch (UnknownHostException e) {
            return false;
        }
    }
    }