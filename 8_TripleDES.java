import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Scanner;

public class TripleDES {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter 24 char Key: ");
        String key = sc.nextLine();

        System.out.print("Enter Plain Text: ");
        String plain = sc.nextLine();

        SecretKeySpec secKey = new SecretKeySpec(key.getBytes(), "DESede");
        Cipher cipher = Cipher.getInstance("DESede");

        cipher.init(Cipher.ENCRYPT_MODE, secKey);
        String encrypted = Base64.getEncoder().encodeToString(cipher.doFinal(plain.getBytes()));

        cipher.init(Cipher.DECRYPT_MODE, secKey);
        String decrypted = new String(cipher.doFinal(Base64.getDecoder().decode(encrypted)));

        System.out.println("\nEncrypted : " + encrypted);
        System.out.println("Decrypted : " + decrypted);

        sc.close();
    }
}
