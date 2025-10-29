import java.util.ArrayList;

public class Parking {
    Coche[] parking = new Coche[4];
    public synchronized void aparcar(Coche cocheAparcar,int plaza) {
        while (parking[plaza]!=null) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Errro");
            }
        }
        System.out.println("Aparacando " + cocheAparcar.modelo);
        parking[plaza] = cocheAparcar;
        notifyAll();
    }
    public synchronized void salir(int plaza) {
        while (parking[plaza]==null) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Errro");
            }
        }
        System.out.println("Saliendo " + parking[plaza].modelo);
        parking[plaza] = null;
        notifyAll();
    }
}
