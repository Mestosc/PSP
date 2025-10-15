public class Lector extends Thread {
    private BuzonCorreo buzonCorreo;

    public Lector(BuzonCorreo buzonCorreo) {
        this.buzonCorreo = buzonCorreo;
    }

    @Override
    public void run() {
        buzonCorreo.lector();
    }
}
