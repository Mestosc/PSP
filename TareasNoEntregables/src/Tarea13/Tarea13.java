package Tarea13;

public class Tarea13 {
    public static void main(String[] args) {
        Hilo1 hilo1 = new Hilo1();
        hilo1.setPriority(Thread.MAX_PRIORITY);
        Hilo1 hilo2 = new Hilo1();
        hilo2.setPriority(Thread.NORM_PRIORITY);
        Hilo1 hilo3 = new Hilo1();
        hilo3.setPriority(Thread.MAX_PRIORITY);
        Hilo1 hilo4 = new Hilo1();
        hilo4.setPriority(Thread.MIN_PRIORITY);
        hilo3.start();
        hilo2.start();
        hilo1.start();
    }
}
