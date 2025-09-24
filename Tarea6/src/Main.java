import java.io.BufferedReader;
//import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Main {
    /**
     * Lanzamos un ping a un sitio web
     * @param sitio el sitio web al que lanzamos el ping
     */
    public static void lanzarPing(String sitio) {
        String error = "\033[31m[ERROR] \033[37m";
        String ok = "\033[32m[OK] \033[37m";
        ArrayList<String> proceso = new ArrayList<>(List.of("ping","4",sitio));
        if (System.getProperty("os.name").toLowerCase().startsWith("windows")) {
            proceso.add(1,"/n"); /* En windows hay que poner ping /n num, para el tema de numero de paquetes segun la documentacion de Microsoft
            https://learn.microsoft.com/es-es/windows-server/administration/windows-commands/ping*/
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
            System.out.println("Problema de entrada salida: " + e);
        } catch (InterruptedException e) {
            System.out.println("Interrupcion " + e);
        }
    }

    /**
     * Muestra la informacion segun los requerimientos
     * @param p Flujo de datos para la salida de errores y la salida del proceso que vamos a estar ocupando
     * @param ok El string que hace referencia a si es un error o esta bien
     * @throws IOException Problema con la entrada salida
     */
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