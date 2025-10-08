package Tarea12;

public class SumaImpares extends Thread {
    @Override
    public void run() {
        int suma = 0;
        for (int i = 0; i <= 1923; i++) {
            if (i % 2 != 0) {
                suma += i;
            }
        }
        System.out.println("La suma de los números impares del 1 al 100 es: " + suma);
    }
}
