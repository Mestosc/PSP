public class Tarea4 {
    public static void main(String[] args) {
        String x = System.getProperty("user.dir");
        System.out.println(x);
        System.setProperty("user.dir","/home/oscar");
        String y = System.getProperty("user.dir");
        System.out.println(y);
        System.setProperty("user.dir","/tmp");
        x = System.getProperty("user.dir");
        System.out.println(x);
    }
}
