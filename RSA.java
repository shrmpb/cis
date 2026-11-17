import javax.crypto.Cipher;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.util.Base64;
import java.util.Scanner;

public class RSA {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Plain Text: ");
        String plain = sc.nextLine();

        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        KeyPair pair = keyGen.generateKeyPair();

        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, pair.getPublic());
        String encrypted = Base64.getEncoder().encodeToString(cipher.doFinal(plain.getBytes()));

        cipher.init(Cipher.DECRYPT_MODE, pair.getPrivate());
        String decrypted = new String(cipher.doFinal(Base64.getDecoder().decode(encrypted)));

        System.out.println("\nEncrypted : " + encrypted);
        System.out.println("Decrypted : " + decrypted);

        sc.close();
    }
}