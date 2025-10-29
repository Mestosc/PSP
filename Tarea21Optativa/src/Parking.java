import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;

public class Parking {
    BlockingQueue<Coche> parking = new ArrayBlockingQueue<>(4);
    public void aparcar(Coche coche) {
        try {
            System.out.println("El coche " + coche + " ha aparcado");
            parking.put(coche);
        } catch (InterruptedException e) {
            System.out.println("Problemas");
        }
    }
    public void desaparcar() {
        try {
            Coche p = parking.take();
            System.out.println("El coche " + p + " ha salido");
        } catch (InterruptedException e) {
            System.out.println("Problemas");
        }
    }
}
