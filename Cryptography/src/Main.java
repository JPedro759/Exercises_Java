import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;
import java.util.Scanner;

public class Main {

    public static String encryptPassword(String password, Key key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");

        cipher.init(Cipher.ENCRYPT_MODE, key);

        byte[] passwordBytes = password.getBytes("UTF-8");
        byte[] passwordEncryptedBytes = cipher.doFinal(passwordBytes);

        String passwordEncrypted = Base64.getEncoder().encodeToString(passwordEncryptedBytes);

        return passwordEncrypted;
    }

    public static void main(String[] args) {
        try {
            final String secret_key = "#modalGR#GPTW#top#maiorEmpresaTecnologia#baixadaSantista";

            // Função de hash para reduzir o tamanho da chave para 256 bits (32 bytes)
            MessageDigest sha = MessageDigest.getInstance("SHA-256");
            byte[] secretKeyBytes = sha.digest(secret_key.getBytes("UTF-8"));

            Key key = new SecretKeySpec(secretKeyBytes, "AES");

            Scanner scanner = new Scanner(System.in);

            System.out.print("\nDigite a 1° senha: ");
            String firstPassword = scanner.next();

            System.out.print("Digite a 2° senha: ");
            String secondPassword = scanner.next();

            System.out.print("Digite a 3° senha: ");
            String thirdPassword = scanner.next();

            String firstEncryptedPassword = encryptPassword(firstPassword, key);
            String secondEncryptedPassword = encryptPassword(secondPassword, key);
            String thirdEncryptedPassword = encryptPassword(thirdPassword, key);

            System.out.println("\n1° Senha Criptografada: " + firstEncryptedPassword);
            System.out.println("2° Senha Criptografada: " + secondEncryptedPassword);
            System.out.println("3° Senha Criptografada: " + thirdEncryptedPassword);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}