import java.util.Scanner;

public class SimpleCaesar {

    static char shiftChar(char ch, int shift) {
        if (ch >= 'A' && ch <= 'Z') {
            return (char) ('A' + (ch - 'A' + shift) % 26);
        }
        if (ch >= 'a' && ch <= 'z') {
            return (char) ('a' + (ch - 'a' + shift) % 26);
        }
        return ch;
    }

    static String encrypt(String text, int shift) {
        StringBuilder sb = new StringBuilder();
        for (char ch : text.toCharArray()) {
            sb.append(shiftChar(ch, shift));
        }
        return sb.toString();
    }

    static String decrypt(String text, int shift) {
        return encrypt(text, 26 - shift);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        System.out.print("Enter shift: ");
        int shift = sc.nextInt();

        System.out.println("Encrypted: " + encrypt(text, shift));
        System.out.println("Decrypted: " + decrypt(encrypt(text, shift), shift));

        sc.close();
    }
}
