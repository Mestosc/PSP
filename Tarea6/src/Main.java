import java.io.BufferedReader;
//import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void lanzarPing(String sitio) {
        String error = "\033[31m[ERROR] \033[37m";
        String ok = "\033[32m[OK] \033[37m";
        ArrayList<String> proceso = new ArrayList<>(List.of("ping","4",sitio));
        if (System.getProperty("os.name").toLowerCase().startsWith("windows")) {
            proceso.add(1,"/n");
        } else if (System.getProperty("os.name").toLowerCase().startsWith("linux")) {
            proceso.add(1,"-c");
        }
        ProcessBuilder pb = new ProcessBuilder(proceso);
        //pb.redirectOutput(new File("print_output.log")); // Redireccion de output a fichero
        //pb.redirectError(new File("ping_error.log")); // Redireccion de errores a fichero
        try {
            Process p = pb.start();
            mostrarInformacionRequerimientos(p.getErrorStream(), error);
            mostrarInformacionRequerimientos(p.getInputStream(), ok);
            int estado = p.waitFor();
            System.out.println("Operacion completada. Codigo de salida " + estado);
        } catch (IOException e) {
            System.out.println("Problema de entrada salida " + e);
        } catch (InterruptedException e) {
            System.out.println("Interrupcion " + e);
        }
    }

    private static void mostrarInformacionRequerimientos(InputStream p, String ok) throws IOException {
        try (BufferedReader buf = new BufferedReader(new InputStreamReader(p, StandardCharsets.UTF_8))) {
            String linea;
            while ((linea = buf.readLine()) != null) {
                String lineaF = "";
                lineaF += ok;
                lineaF += linea;
                System.out.println(lineaF);
            }
        }
    }
}