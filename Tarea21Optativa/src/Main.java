//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Coche[] coches = new Coche[4];
        Parking parking = new Parking();
        coches[0] = new Coche("Model S", "Tesla", null, 0);
        coches[1] = new Coche("Civic", "Honda", null, 1);
        coches[2] = new Coche("Corolla", "Toyota", null, 2);
        coches[3] = new Coche("Mustang", "Ford", null, 3);
        //coches[4] = new Coche("A4", "Audi", null, 4);

        Aparcador[] aparcadors = {new Aparcador(parking,coches),
                new Aparcador(parking,coches),
                new Aparcador(parking,coches),
                new Aparcador(parking,coches),};

        Desaparcador[] desaparcador = {new Desaparcador(parking,coches),new Desaparcador(parking,coches),new Desaparcador(parking,coches)};

        for (Aparcador aparcador : aparcadors) {
            aparcador.start();
        }
        for (Desaparcador desaparcador1 : desaparcador) {
            desaparcador1.start();
        }


    }
}