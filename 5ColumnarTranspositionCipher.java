import java.util.*;

public class ColumnarTranspositionCipher {
    static int[] key(String s) {
        s = s.toUpperCase();
        int n = s.length(), k[] = new int[n];
        for (int i = 0; i < n; i++) {
            k[i] = 1;
            for (int j = 0; j < n; j++)
                if (s.charAt(j) < s.charAt(i) || (s.charAt(j) == s.charAt(i) && j < i)) k[i]++;
        }
        return k;
    }

    static String enc(String t, int[] k) {
        int c = k.length, r = (t.length() + c - 1) / c;
        String o = "";
        for (int x = 1; x <= c; x++)
            for (int j = 0; j < c; j++)
                if (k[j] == x)
                    for (int i = 0; i < r; i++) {
                        int p = i * c + j;
                        o += p < t.length() ? t.charAt(p) : '_';
                    }
        return o;
    }

    static String dec(String t, int[] k) {
        int c = k.length, r = t.length() / c, p = 0;
        char[] g = new char[t.length()];
        for (int x = 1; x <= c; x++)
            for (int j = 0; j < c; j++)
                if (k[j] == x)
                    for (int i = 0; i < r; i++) g[i * c + j] = t.charAt(p++);
        return new String(g);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Plaintext: ");
        String m = sc.nextLine().replace(" ", "");
        System.out.print("Key: ");
        int[] k = key(sc.next());
        System.out.println("\nNumeric Key: " + Arrays.toString(k));

        String e = enc(m, k), d = enc(e, k);
        System.out.println("\n--- Single Transposition ---");
        System.out.println("Encrypted: " + e);
        System.out.println("Decrypted: " + dec(e, k));
        System.out.println("\n--- Double Transposition ---");
        System.out.println("Encrypted: " + d);
        System.out.println("Decrypted: " + dec(dec(d, k), k).replace("_", ""));
    }
}
