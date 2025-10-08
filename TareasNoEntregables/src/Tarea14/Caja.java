package Tarea14;

public class Caja extends Thread {
    public static double capital = 1000.0;
    String tipo;
    public Caja(String tipo) {
        this.tipo = tipo;
    }
    @Override
    public void run() {
        if (tipo.equalsIgnoreCase("ingresos")) {
            for (int i = 0;i<5000;i++) {
                //System.out.println(capital);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                capital += 10;
            }
        } else if (tipo.equalsIgnoreCase("extracciones")) {
            for (int i = 0;i<3000;i++) {
                //System.out.println(capital);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                capital -= 10;
            }
        }
    }
}
