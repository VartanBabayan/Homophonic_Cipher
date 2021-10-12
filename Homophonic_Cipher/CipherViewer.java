package Solution;

public class CipherViewer {
    /**
     * print [E]ncrypted/[D]ecrypted message
     *
     * @param message
     * @param flag    - true for [E] and false for [D]
     */
    public static void printCipher(String message, boolean flag) {
        if (flag) {
            System.out.println("ENCRYPTED MESSAGE: " + message);
        } else {
            System.out.println("DECRYPTED MESSAGE: " + message);
        }
    }
}