import java.util.concurrent.TimeUnit;

public class Tarea8 extends Thread {
    String profesor;
    int limitePaciencia;
    public Tarea8(String profesor, int limitePaciencia) {
        this.profesor = profesor;
        this.limitePaciencia = limitePaciencia;
    }
    @Override
    public void run() {
        for (int i = 0; i <= limitePaciencia; i++) {
            if (i==limitePaciencia) {
                System.out.println(profesor + " Cabreo nviel " + i + "... ¡He llegado a mi limite!");
                break;
            }
            else {System.out.println(profesor + " Cabreo nivel " + i);}
        }
    }
    public static void main(String[] args) {
        Tarea8 t1 = new Tarea8("Damian",3);
        Tarea8 t2 = new Tarea8("Diego",4);
        Tarea8 t3 = new Tarea8("Araujo",5);
        Tarea8 t4 = new Tarea8("Manuel",5);
        t1.start();
        t2.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Hola");
        long tiempo = TimeUnit.SECONDS.toMillis(60);
        try {
           t2.join(tiempo);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        t3.start();
        try {
            synchronized (t3) {
                t3.wait(tiempo);
                System.out.println(t3.profesor + " es bastante paciente");
            }
            if (t3.isAlive()) {
                System.out.println("Lo has hecho muy bien");
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        t4.start();
        }
    }
