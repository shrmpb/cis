import java.util.*;

class RailFenceCipher {
    static int[] ord(int n, int r) {
        int[] w = new int[n], o = new int[n];
        int row = 0, d = 1, k = 0;
        for (int i = 0; i < n; i++) {
            w[i] = row;
            if (row == 0) d = 1;
            else if (row == r - 1) d = -1;
            row += d;
        }
        for (int x = 0; x < r; x++)
            for (int i = 0; i < n; i++)
                if (w[i] == x) o[k++] = i;
        return o;
    }

    public static void main(String[] a) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Text: ");
        String t = sc.nextLine();
        System.out.print("Rails: ");
        int r = sc.nextInt(), n = t.length();
        int[] o = ord(n, r);
        String e = "";
        char[] p = new char[n];
        for (int i : o) e += t.charAt(i);
        System.out.println("Encrypted: " + e);
        for (int j = 0; j < n; j++) p[o[j]] = e.charAt(j);
        System.out.println("Decrypted: " + new String(p));
    }
}
