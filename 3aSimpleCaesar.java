import java.util.Scanner;

public class SimpleCaesar {
    static String enc(String t, int s) {
        String r = "";
        for (char c : t.toCharArray()) {
            if (Character.isUpperCase(c)) c = (char) ('A' + (c - 'A' + s) % 26);
            else if (Character.isLowerCase(c)) c = (char) ('a' + (c - 'a' + s) % 26);
            r += c;
        }
        return r;
    }

    public static void main(String[] a) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String t = sc.nextLine();
        System.out.print("Enter shift: ");
        int s = sc.nextInt();
        String e = enc(t, s);
        System.out.println("Encrypted: " + e);
        System.out.println("Decrypted: " + enc(e, 26 - s));
    }
}
