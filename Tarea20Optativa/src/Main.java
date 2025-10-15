//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Iniciando prueba ===\n");
        BuzonCorreo buzon = new BuzonCorreo();  // ⭐ UNA SOLA INSTANCIA

        Escritor e1 = new Escritor(buzon, "Mensaje 1");
        Lector l1 = new Lector(buzon);
        Escritor e2 = new Escritor(buzon, "Mensaje 2");
        Lector l2 = new Lector(buzon);

        e1.start();
        l1.start();
        e2.start();
        l2.start();

        try {
            e1.join();
            l1.join();
            e2.join();
            l2.join();
        } catch (InterruptedException e) {
            System.err.println("Error de hilos");
        }

        System.out.println("\n=== Prueba completada ===");
    }
}