public class Tarea16 extends Thread {
    public static int contador = 0;
    @Override
    public void run() {
        for (int i = 0;i<50;i++) {
            contador++;
            try {
                Thread.sleep((long) Math.floor(Math.random() * (600 - 100) + 100));
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        Tarea16[] hilos = {new Tarea16(),new Tarea16(),new Tarea16(), new Tarea16(), new Tarea16()};
        for (Tarea16 hilo : hilos) {
            hilo.start();
        }
        for (Tarea16 hilo : hilos) {
            try {
                hilo.join();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Contador: " + contador); // El resultado que arrojo es correcto si tienes un contador y lo incrementas de uno en uno durante cincuenta veces, 5 veces por los cinco hilos obtienes 250 que es lo que se obtiene al incrementarlo 50 cincuenta veces cinco veces
    }
}
