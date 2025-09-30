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
        t3.start();
        t4.start();
    }
}
