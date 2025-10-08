package Tarea14;

public class Tarea14 {
    public static void main(String[] args) {
        Caja ingresos = new Caja("ingresos");
        Caja extracciones = new Caja("extracciones");
        ingresos.start();
        extracciones.start();
        try {
            ingresos.join();
            extracciones.join();
        } catch (InterruptedException e) {
            System.err.println("Hilo interrumpido");
        }
        System.out.println("Saldo final de la caja: " + Caja.capital);
    }
}
