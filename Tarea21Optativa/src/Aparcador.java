public class Aparcador extends Thread {
    private Parking parking;
    private Coche[] coches;
    public Aparcador(Parking parking,Coche[] coches) {
        this.parking = parking;
        this.coches = coches;
    }

    @Override
    public void run() {
        for (Coche coche : coches) {
            parking.aparcar(coche);
        }
    }
}
