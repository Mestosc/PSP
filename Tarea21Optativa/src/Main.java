//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Parking parking1 = new Parking();
        Coche[] coches = new Coche[10];

        coches[0] = new Coche("Model S", "Tesla", null, 0);
        coches[1] = new Coche("Civic", "Honda", null, 1);
        coches[2] = new Coche("Corolla", "Toyota", null, 2);
        coches[3] = new Coche("Mustang", "Ford", null, 3);
        coches[4] = new Coche("A4", "Audi", null, 4);
        coches[5] = new Coche("Serie 3", "BMW", null, 5);
        coches[6] = new Coche("Clio", "Renault", null, 6);
        coches[7] = new Coche("Panda", "Fiat", null, 7);
        coches[8] = new Coche("CX-5", "Mazda", null, 8);
        coches[9] = new Coche("Golf", "Volkswagen", null, 9);
        Aparcador aparcador = new Aparcador(parking1,coches);
        Desaparcador desaparcador = new Desaparcador(parking1);
        aparcador.start();
        desaparcador.start();

    }
}