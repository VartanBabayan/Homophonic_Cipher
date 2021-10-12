package Solution;

import java.util.Random;

public class HomophonicCipher {
    /**
     * @param message - text that will be encrypted
     * @return - encrypted text
     */
    public static String encrypt(String message) {
        message = message.toUpperCase();

        KeyStorage key = new KeyStorage();
        var dictionary = key.dictionary;

        String encryptedMsg = new String();
        Random random = new java.util.Random();
        for (char letter : message.toCharArray()) {
            var x = dictionary.get(letter);
            if (x != null) {
                int randomValue = random.nextInt(x.size());
                encryptedMsg += x.get(randomValue);
            }
        }

        return encryptedMsg;
    }

    /**
     * @param message - text that will be decrypted
     * @return - decrypted text
     */
    public static String decrypt(String message) {
        KeyStorage key = new KeyStorage();
        var dictionary = key.dictionary;

        String decrypted = new String();
        for (char letter : message.toCharArray()) {
            for (Character k : dictionary.keySet()) {
                var values = dictionary.get(k);

                boolean find = false;
                for (Character ch : values) {
                    if (ch == letter) {
                        find = true;
                        break;
                    }
                }

                if (find) {
                    decrypted += k;
                    break;
                }
            }
        }

        return decrypted;
    }
}
