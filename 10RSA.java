import javax.crypto.Cipher;
import java.security.*;
import java.util.*;

public class RSA {
    public static void main(String[] a) throws Exception {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter Plain Text: ");
        String p = s.nextLine();

        KeyPairGenerator g = KeyPairGenerator.getInstance("RSA");
        g.initialize(2048);
        KeyPair kp = g.generateKeyPair();

        Cipher c = Cipher.getInstance("RSA");
        c.init(Cipher.ENCRYPT_MODE, kp.getPublic());
        String e = Base64.getEncoder().encodeToString(c.doFinal(p.getBytes()));

        c.init(Cipher.DECRYPT_MODE, kp.getPrivate());
        System.out.println("\nEncrypted : " + e);
        System.out.println("Decrypted : " + new String(c.doFinal(Base64.getDecoder().decode(e))));
    }
}
