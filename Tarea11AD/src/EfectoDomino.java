public class EfectoDomino extends Thread {
    int numeroHilo = 1;
    int totalHilos = 5;
    public EfectoDomino(int numeroHilo,int totalHilos) {
        this.numeroHilo = numeroHilo;
        this.totalHilos = totalHilos;
    }
    public EfectoDomino(int totalHilos) {
        this.totalHilos = totalHilos;
    }
    public EfectoDomino() {}
    @Override
    public void run() {
        EfectoDomino hilo = new EfectoDomino(numeroHilo+1,totalHilos);
            for (int i = 0; i < 5; i++) {
                System.out.println("Soy el hilo " + numeroHilo + " en mi iteracion " + i);
                try {
                    Thread.sleep((long) Math.floor(Math.random() * (600 -100 +1) +100));
                }
                catch (InterruptedException e) {
                    System.out.println("Hilo interrumpido");
                }
            }
            if (numeroHilo < totalHilos) {
                hilo.start();
            }
            try {
                System.out.println("Acabó hilo " + hilo);
                hilo.join();
            } catch (InterruptedException e) {
                System.out.println("Hilo interrumpido");
            }
        }

    }
//for (int i = 0;i<5;i++){
//        System.out.println("Soy el hilo "+ this + "iteracion "+i);
//        }