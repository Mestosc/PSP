//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        long inicio = System.currentTimeMillis();
        EfectoDomino hilo = new EfectoDomino(6);
        hilo.start();
        EfectoDomino.vigilanteDeHilo(hilo);
        long fin = System.currentTimeMillis();
        System.out.println("Acabó hilo " + hilo.getName() + " Tiempo total: " + (fin - inicio) + " ms");

    }
}