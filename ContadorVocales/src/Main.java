import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escoja una opcion entre\n1.Contar de texto por teclado\n2.Contar de archivo");
        int opcion = Integer.parseInt(sc.next());
        sc.nextLine();
        switch (opcion) {
            case 1 -> {
                System.out.println("Introduce un texto del que copiar ");
                String texto = sc.nextLine();
                contarTextoVocales(texto);
            } case 2 -> {
                System.out.println("Introduzca la ruta del archivo");
                String rutaArchivo = sc.next();
                sc.nextLine();
                try {
                    contarTextoVocales(Files.readString(Path.of(rutaArchivo)));
                } catch (IOException e) {
                    System.out.println("Error en el readstring");
                }
            }
        }
        sc.close(); // Cerrando el maldito Scanner cosa que ya da lo suyo
    }
    private static void contarTextoVocales(String texto) {
        ContarVocales[] contarVocales = {new ContarVocales(texto,'A'), new ContarVocales(texto,'E')
        , new ContarVocales(texto,'I'), new ContarVocales(texto,'O'), new ContarVocales(texto,'U')};
        for (ContarVocales hilo : contarVocales) {
            hilo.start();
        }
        for (ContarVocales hilo : contarVocales) {
            try {
                hilo.join();
            } catch (InterruptedException e) {
                System.out.println("Hilo interrumpido");
            }
        }
        System.out.println(ContarVocales.vocalesTotales);
    }
}
