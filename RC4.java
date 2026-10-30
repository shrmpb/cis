import javax.crypto.*;
import java.util.*;

public class RC4 {
    public static void main(String[] a) throws Exception {
        String p = "Hello world";
        KeyGenerator g = KeyGenerator.getInstance("ARCFOUR");
        g.init(128);
        SecretKey k = g.generateKey();
        Cipher c = Cipher.getInstance("ARCFOUR");

        c.init(Cipher.ENCRYPT_MODE, k);
        String e = Base64.getEncoder().encodeToString(c.doFinal(p.getBytes()));

        c.init(Cipher.DECRYPT_MODE, k);
        String d = new String(c.doFinal(Base64.getDecoder().decode(e)));

        System.out.println("Key: " + Base64.getEncoder().encodeToString(k.getEncoded()));
        System.out.println("Plain: " + p);
        System.out.println("Enc: " + e);
        System.out.println("Dec: " + d);
    }
}