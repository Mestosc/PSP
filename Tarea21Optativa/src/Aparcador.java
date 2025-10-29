public class Aparcador extends Thread {
    Coche[] coches;
    Parking aparcadero;
    public Aparcador(Parking aparcadero, Coche...coches) {
        this.aparcadero = aparcadero;
        this.coches = coches;
    }
    @Override
    public void run() {
        while (true) {
            aparcadero.aparcar(coches[(int) Math.floor(Math.random() * coches.length)], (int) Math.floor(Math.random() * aparcadero.parking.length));
        }
    }
}
