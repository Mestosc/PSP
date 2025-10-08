package Tarea12;

public class Tarea12 {
    public static void main(String[] args) {
        SumarPares pares = new SumarPares();
        SumaImpares impares = new SumaImpares();
        NumerosTerminen3o4 terminan3o4 = new NumerosTerminen3o4();
        pares.start();
        impares.start();
        terminan3o4.start();
    }
}
