import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Tarea5 {
    public static void main(String[] args) {
        System.out.println(ejecutarProcesoYParametro());
    }

    private static int ejecutarProcesoYParametro() {
        Scanner sc = new Scanner(System.in);
        String comando;
        int estado = -1;
        while (true) {
            System.out.print("Introduzca comando: ");
            comando = sc.next();
            sc.nextLine();
            if (comando.equals("salir")) {
                break;
            }
            System.out.print("Introduzca parametros:");
            String parametros = sc.nextLine();
            ArrayList<String> comandoFinal = new ArrayList<>();
            comandoFinal.add(comando);
            comandoFinal.add(parametros);
            ProcessBuilder pb = new ProcessBuilder(comandoFinal);
            pb.inheritIO();
            try {
                Process p = pb.start();
                estado = p.exitValue();
            } catch (IOException e) {
                System.out.println("Error Entrada salida " + e);
            }
        }
        sc.close();
        return estado;
    }
}
