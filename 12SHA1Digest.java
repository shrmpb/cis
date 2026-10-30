import java.security.MessageDigest;
import java.util.Scanner;

public class SHA1Digest {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter message: ");
        String h = "";
        for (byte b : MessageDigest.getInstance("SHA-1").digest(s.nextLine().getBytes("UTF-8")))
            h += String.format("%02x", b);
        System.out.println("SHA-1 Digest: " + h);
    }
}
