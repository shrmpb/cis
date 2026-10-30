import java.util.Scanner;

class HillRow {
    static String mul(String t, int[][] k) {
        String r = "";
        for (int i = 0; i < t.length(); i += 2) {
            int a = t.charAt(i) - 'A', b = t.charAt(i + 1) - 'A';
            r += (char) ((a * k[0][0] + b * k[1][0]) % 26 + 'A');
            r += (char) ((a * k[0][1] + b * k[1][1]) % 26 + 'A');
        }
        return r;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] k = {{3, 3}, {2, 5}}, inv = {{15, 17}, {20, 9}};
        System.out.print("Enter plaintext: ");
        String p = sc.nextLine().toUpperCase().replace(" ", "");
        if (p.length() % 2 != 0) p += "X";
        String e = mul(p, k);
        System.out.println("Encrypted: " + e);
        System.out.println("Decrypted: " + mul(e, inv));
    }
}