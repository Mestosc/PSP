import java.io.*;
import java.util.ArrayList;

public class Tarea07 {
    public static void main(String[] args) {
        ejecutarArchivoPython();
    }

    private static void ejecutarArchivoPython() {
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
        } catch (IOException e) {
            System.out.println("Problema en la entrada salida");
        }
    }
}
