import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Tarea07 {
    public static void main(String[] args) {
        if (ejecutarArchivoPython()!=0) {
            System.err.println("El programa ha fallado");
        }
    }

    private static int ejecutarArchivoPython() {
        ArrayList<String> comandos = new ArrayList<>();
        comandos.add("python");
        comandos.add("src/hola.py");
        ProcessBuilder pb = new ProcessBuilder(comandos);
        try {
            Process p = pb.start();
            try (BufferedReader buf = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
                String linea;
                while ((linea=buf.readLine())!=null) { // Bueno al final devuelve una linea por lo que podria haber usado otra alternativa a más bajo poner los caracteres y así pero bueno con readLine voy más rapido
                    System.out.println(linea);
                }
            }
            return p.waitFor();
        } catch (IOException e) {
            System.err.println("Problema en la entrada salida " + e);
        } catch (InterruptedException e) {
            System.err.println("Interrupcion " + e);
        }
        return -1;
    }
}
