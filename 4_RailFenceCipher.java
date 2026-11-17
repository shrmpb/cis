import java.util.*;

class RailFenceCipher {

    static String encrypt(String t, int r) {
        StringBuilder[] a = new StringBuilder[r];
        for (int i = 0; i < r; i++) a[i] = new StringBuilder();

        int row = 0, d = 1;
        for (char c : t.toCharArray()) {
            a[row].append(c);
            if (row == 0) d = 1;
            else if (row == r - 1) d = -1;
            row += d;
        }

        StringBuilder s = new StringBuilder();
        for (var x : a) s.append(x);
        return s.toString();
    }

    static String decrypt(String c, int r) {
        int n = c.length();
        char[][] f = new char[r][n];

        int row = 0, d = 1;
        for (int i = 0; i < n; i++) {
            f[row][i] = '*';
            if (row == 0) d = 1;
            else if (row == r - 1) d = -1;
            row += d;
        }

        int k = 0;
        for (int i = 0; i < r; i++)
            for (int j = 0; j < n; j++)
                if (f[i][j] == '*') f[i][j] = c.charAt(k++);

        StringBuilder s = new StringBuilder();
        row = 0;
        d = 1;
        for (int i = 0; i < n; i++) {
            s.append(f[row][i]);
            if (row == 0) d = 1;
            else if (row == r - 1) d = -1;
            row += d;
        }
        return s.toString();
    }

    public static void main(String[] a) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Text: ");
        String t = sc.nextLine();

        System.out.print("Rails: ");
        int r = sc.nextInt();

        String e = encrypt(t, r);
        System.out.println("Encrypted: " + e);
        System.out.println("Decrypted: " + decrypt(e, r));
    }
}
