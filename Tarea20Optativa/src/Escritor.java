public class Escritor extends Thread {
    private final Object object = new Object();
    private BuzonCorreo buzonCorreo;
    private String mensaje;
    public Escritor(BuzonCorreo buzonCorreo,String mensaje) {
        this.buzonCorreo = buzonCorreo;
        this.mensaje = mensaje;
    }

    @Override
    public void run() {
        buzonCorreo.escritor(mensaje);
    }
}
