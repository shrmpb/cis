import java.util.Scanner;

public class SubstitutionCipher {
    static final String A = "ABCDEFGHIJKLMNOPQRSTUVWXYZ", K = "QWERTYUIOPASDFGHJKLZXCVBNM";

    static String conv(String t, String from, String to) {
        String r = "";
        for (char c : t.toUpperCase().toCharArray()) {
            int i = from.indexOf(c);
            r += i < 0 ? c : to.charAt(i);
        }
        return r;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("--- Substitution Cipher ---");
        System.out.println("Alphabet : " + A);
        System.out.println("Key      : " + K);
        System.out.print("\nEnter Plain Text: ");
        String e = conv(sc.nextLine(), A, K);
        System.out.println("Encrypted Text: " + e);
        System.out.println("Decrypted Text: " + conv(e, K, A));
    }
}