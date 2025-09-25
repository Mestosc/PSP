import java.util.Scanner;

public class Interfaz {
    public static void main(String[] args) {
        String sitio;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("Indica el host o IP (salir para acabar):");
            System.out.print("> ");
            sitio = sc.next();
            if (!sitio.equalsIgnoreCase("salir")) {
                LanzadorProceso.lanzarPing("ping",sitio);
            }
        } while (!sitio.equalsIgnoreCase("salir"));
	sc.close()
    }
}
