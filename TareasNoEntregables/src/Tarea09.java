public class Tarea09 extends Thread {
    int limite;
    public Tarea09(int n) {
        this.limite = n;
    }
    private void mostrarCalculoFibonacci(int num1, int num2) {
        int result = num1 + num2;
        System.out.println(num1);
        if (result <= limite) {
            mostrarCalculoFibonacci(num2, result);
        }
    }
    @Override
    public void run() {
        mostrarCalculoFibonacci(1,1);
    }
    public static void main(String[] args) {
        Tarea09 t1 = new Tarea09(100);
        Tarea09 t2 = new Tarea09(200);
        t1.start();
        try {
            Thread.sleep(2000);
            t2.start();
            if (t2.isAlive()) {
                t2.join();
                System.out.println("El hilo ha terminado");
            }
        } catch (InterruptedException e) {
                throw new RuntimeException(e);
        }
        if (System.getProperty("os.name").startsWith("Windows")) {
            System.out.println("El sistema operativo es Windows");
        } else {
            System.out.println("El sistema operativo no es Windows");
        }
    }
}
