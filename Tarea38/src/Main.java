import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            System.out.println("Cree una contraseña:");
            String contrasnea = sc.nextLine();
            md.update(contrasnea.getBytes());
            byte[] hash = md.digest();
            String hex = HexFormat.of().formatHex(hash);
            System.out.println("Usuario registrado inicie sesion");
            String contrasenaLogin = sc.nextLine();
            md.update(contrasenaLogin.getBytes());
            byte[] hash2 = md.digest();
            if (HexFormat.of().formatHex(hash2).equals(hex)) {
                System.out.println("ACCESO CONCEDIDO");
            } else {
                System.out.println("ERROR: Credenciales incorrectas");
            }
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Error no existe el algoritmo de cifrado a usar");
        }

    }
}