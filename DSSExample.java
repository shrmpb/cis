import java.security.*;

public class DSSExample {
    public static void main(String[] args) throws Exception {
        String m = "hello";
        KeyPairGenerator g = KeyPairGenerator.getInstance("DSA");
        g.initialize(2048);
        KeyPair kp = g.generateKeyPair();

        Signature s = Signature.getInstance("SHA256withDSA");
        s.initSign(kp.getPrivate());
        s.update(m.getBytes());
        byte[] sig = s.sign();
        System.out.println("Message: " + m);
        System.out.println("DSS Signature generated");

        s.initVerify(kp.getPublic());
        s.update(m.getBytes());
        System.out.println("Verified: " + s.verify(sig));

        s.initVerify(kp.getPublic());
        s.update("tampered message".getBytes());
        System.out.println("Tampered Verified: " + s.verify(sig));
    }
}