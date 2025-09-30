public class Pruebas {
    public static void main(String[] args) {
       ThreadEjemplo thread = new ThreadEjemplo("Oscar LKE kjfla sfjlka sdfasfd");
        System.out.println("Antes");
        thread.start();
        System.out.println("lsjflsjlf");
        if (thread.isAlive()) {
            System.out.println("El hilo está vivo");
        } else {
            System.out.println("El hilo ha muerto");
        }
    }
}
