import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.*;

public class TripleDES {
    public static void main(String[] a) throws Exception {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter 24 char Key: ");
        SecretKeySpec k = new SecretKeySpec(s.nextLine().getBytes(), "DESede");
        System.out.print("Enter Plain Text: ");
        Cipher c = Cipher.getInstance("DESede");

        c.init(Cipher.ENCRYPT_MODE, k);
        String e = Base64.getEncoder().encodeToString(c.doFinal(s.nextLine().getBytes()));

        c.init(Cipher.DECRYPT_MODE, k);
        System.out.println("\nEncrypted : " + e);
        System.out.println("Decrypted : " + new String(c.doFinal(Base64.getDecoder().decode(e))));
    }
}