import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.*;

public class AES {
    public static void main(String[] a) throws Exception {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter 16 char Key: ");
        String k = s.nextLine();
        System.out.print("Enter Plain Text: ");
        String p = s.nextLine();

        SecretKeySpec key = new SecretKeySpec(k.getBytes(), "AES");
        Cipher c = Cipher.getInstance("AES");

        c.init(Cipher.ENCRYPT_MODE, key);
        String e = Base64.getEncoder().encodeToString(c.doFinal(p.getBytes()));

        c.init(Cipher.DECRYPT_MODE, key);
        String d = new String(c.doFinal(Base64.getDecoder().decode(e)));

        System.out.println("\nEncrypted : " + e);
        System.out.println("Decrypted : " + d);
    }
}
