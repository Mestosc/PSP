public class EfectoDomino extends Thread {
    int numeroHilo = 0;
    int totalHilos = 5;
    public EfectoDomino(int numeroHilo,int totalHilos) {
        this.numeroHilo = numeroHilo;
        this.totalHilos = totalHilos;
    }
    public EfectoDomino(int totalHilos) {
        this.totalHilos = totalHilos;
    }
    public EfectoDomino() {} // Para usar valores por defecto
    @Override
    public void run() {
        long inicio = System.currentTimeMillis();
        iteracionEnHilo();
        if (numeroHilo < totalHilos) {
                EfectoDomino hilo = new EfectoDomino(numeroHilo+1,totalHilos);
                hilo.start();
                try {
                    if (hilo.isAlive()) {
                        try {
                            Thread.sleep(500);
                            System.out.println("Vigilando hilo " + hilo.getName() + "... sigue activo");
                        } catch (InterruptedException e) {
                            System.out.println("Hilo interrumpido");
                        }
                    }
                    hilo.join();
                } catch (InterruptedException e) {
                    System.out.println("Hilo interrumpido");
                }
                long fin = System.currentTimeMillis();
                System.out.println("Acabó hilo " + hilo.getName() + " Tiempo: " + (fin-inicio) + " ms");
            }
        }

    private void iteracionEnHilo() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Soy el hilo " + numeroHilo + " en mi iteracion " + i);
            try {
                Thread.sleep((long) Math.floor(Math.random() * (600 -100 +1) +100));
            }
            catch (InterruptedException e) {
                System.out.println("Hilo interrumpido");
            }
        }
    }

}