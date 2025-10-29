public class Desaparcador extends Thread {
    private Parking parking;
    private Coche[] coches;
    public Desaparcador(Parking parking,Coche[] coches) {
        this.parking = parking;
        this.coches = coches;
    }

    @Override
    public void run() {
        for (int i = 0;i<coches.length;i++) {
            parking.desaparcar();
        }
    }
}
