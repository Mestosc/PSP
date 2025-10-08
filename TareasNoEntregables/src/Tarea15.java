
public class Tarea15 extends Thread {
    public Tarea15() {}
    @Override
    public void run() {
        for (int i = 0; i < 8; i++) {
            System.out.println("Hilo " + (Integer.parseInt(getName().substring(7)) + 1) + " en ejecución, iteración " + (i + 1));
        }
    }

    public static void main(String[] args) {
        Tarea15 hilo1 = new Tarea15();
        Tarea15 hilo2 = new Tarea15();
        Tarea15 hilo3 = new Tarea15();
        Tarea15[] hilos = {hilo1, hilo2, hilo3};
        for (int i = hilos.length-1;i>=0;i--) {
            Tarea15 hilo = hilos[i];
            hilo.start();
            esperar(hilo);
        }
        System.out.println("Programa principal finalizado");

    }
    static void esperar(Thread hilo) {
        try {
            hilo.join();
        } catch (InterruptedException e) {
            System.out.println("El hilo ha sido interrumpido" + e.getMessage());
        }
    }
}
