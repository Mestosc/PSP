public class Clientes extends Thread {
    SuperMercado superMercado;

    public Clientes(SuperMercado mercado) {
        superMercado = mercado;
    }

    @Override
    public void run() {
        superMercado.compraYPago();
    }
}
