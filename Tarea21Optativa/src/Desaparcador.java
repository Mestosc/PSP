public class Desaparcador extends Thread {
    Parking aparcadero;
    public Desaparcador(Parking aparcadero) {
        this.aparcadero = aparcadero;
    }
    @Override
    public void run() {
        while (true) {
            aparcadero.salir((int) Math.floor(Math.random() * aparcadero.parking.length));
        }
    }
}
