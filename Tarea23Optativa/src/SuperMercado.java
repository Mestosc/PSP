import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class SuperMercado {
    private Semaphore cajas;
    int numeroClientes;
    static AtomicInteger Resultados = new AtomicInteger();
    public SuperMercado(int numeroCajas,int numeroClientes) {
        cajas = new Semaphore(numeroCajas);
        this.numeroClientes = numeroClientes;
    }

    public void compraYPago() {
        try {
            cajas.acquire();
            Thread.sleep(100);
            //importeClientes += 100;
            int importe = (int) Math.floor(Math.random()*(10 -2) * 12);
            //int importe = 100;
            Resultados.addAndGet(importe);
            //System.out.println("Importe de clientes en " + Thread.currentThread().getName() + ": " + importe);
        } catch (InterruptedException e) {
            System.out.println("Fallo en la compra y pago");
        } finally {
            cajas.release();
        }
    }
}
