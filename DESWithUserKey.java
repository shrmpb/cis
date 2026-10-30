import javax.crypto.*;
import javax.crypto.spec.*;
import java.util.*;

public class DESWithUserKey {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Plaintext: ");
        String p = sc.nextLine();
        System.out.print("Enter Key (must be 8 chars e.g. 12345678): ");
        SecretKey k = new SecretKeySpec(sc.nextLine().getBytes(), "DES");

        Cipher c = Cipher.getInstance("DES/ECB/PKCS5Padding");
        c.init(Cipher.ENCRYPT_MODE, k);
        String e = Base64.getEncoder().encodeToString(c.doFinal(p.getBytes()));
        System.out.println("Encrypted: " + e);

        c.init(Cipher.DECRYPT_MODE, k);
        System.out.println("Decrypted: " + new String(c.doFinal(Base64.getDecoder().decode(e))));
    }
}