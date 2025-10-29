public class Coche {
    String modelo;
    String marca;

    public Coche(String modelo, String marca, Parking dondeAparcar, int plaza) {
        this.modelo = modelo;
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                '}';
    }
}
