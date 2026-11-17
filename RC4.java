import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;

public class RC4 {

    public static void main(String[] args) throws Exception {
        String plain = "Hello world";

        KeyGenerator kg = KeyGenerator.getInstance("ARCFOUR");
        kg.init(128);
        SecretKey key = kg.generateKey();
        Cipher c = Cipher.getInstance("ARCFOUR");

        c.init(Cipher.ENCRYPT_MODE, key);
        String enc = Base64.getEncoder().encodeToString(c.doFinal(plain.getBytes()));

        c.init(Cipher.DECRYPT_MODE, key);
        String dec = new String(c.doFinal(Base64.getDecoder().decode(enc)));

        System.out.println("Key: " + Base64.getEncoder().encodeToString(key.getEncoded()));
        System.out.println("Plain: " + plain);
        System.out.println("Enc: " + enc);
        System.out.println("Dec: " + dec);
    }
}