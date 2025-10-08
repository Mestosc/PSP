package Tarea13;

import java.util.concurrent.ThreadLocalRandom;

public class Hilo1 extends Thread {
    @Override
    public void run() {
        for (int i = 0;i<10;i++) {
            System.out.println(i + " " + getName());
            try {
                Thread.sleep((long) ThreadLocalRandom.current().nextInt(1000,10001));
            } catch (InterruptedException e) {
                System.err.println("Problemas");
            }
        }
    }
}
