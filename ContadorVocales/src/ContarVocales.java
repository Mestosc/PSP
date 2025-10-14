public class ContarVocales extends Thread {
    static int vocalesTotales;
    char vocalContar;
    String textoContar;
    private final Object lock = new Object();
    public ContarVocales(char vocalContar) {
        this.vocalContar = Character.toLowerCase(vocalContar);
    }
    public ContarVocales(String textoContar, char vocalContar) {
        this(vocalContar);
        this.textoContar = textoContar;
    }
    private static char desacentuar(char letra) {
        return switch (letra) {
            case 'á' -> 'a';
            case 'é' -> 'e';
            case 'í' -> 'i';
            case 'ó' -> 'o';
            case 'ú' -> 'u';
            default -> letra;
        };
    }
    @Override
    public void run() {
        for (int i = 0;i<textoContar.length();i++) {
            char l = desacentuar(Character.toLowerCase(textoContar.charAt(i)));
            if (l==vocalContar) {
                synchronized (lock) {
                    vocalesTotales++;
                }
            }
        }
    }

}
