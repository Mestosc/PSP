public class BuzonCorreo {
    String buzon;
    public synchronized void lector() {
            while (buzon == null) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println("Bloqueado");
                }
            }
            System.out.println(buzon);
            buzon = null;
            notifyAll();
        }
    public synchronized void escritor(String mensajeEscribir) {
            while (buzon!=null) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println("Error escribeiendo");
                }
            }
        buzon = mensajeEscribir;
        notifyAll();
        }
    }
