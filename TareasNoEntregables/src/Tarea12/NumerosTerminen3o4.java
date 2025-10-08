package Tarea12;

public class NumerosTerminen3o4 extends Thread {
    @Override
    public void run() {
        System.out.println("Números que terminan en 3 o 4 del 1 al 1923:");
        for (int i = 1; i <= 1923; i++) {
            if (i % 10 == 3 || i % 10 == 4) {
                System.out.println(i);
            }
        }
    }
}
