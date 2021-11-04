package pl.polsl.lab.vartan.babayan.modelCipher;

import java.util.ArrayList;

import pl.polsl.lab.vartan.babayan.alphabetCipher.KeyStorage;

import java.util.Random;

/**
 * Model - HomophonicCipher which implements main part of the program
 *
 * @author vartan babayan
 */
public class HomophonicCipher implements Serializable {
    /**
     * handle exception in case if message is not valid
     */
    private final String errMessage;

    /**
     * HashMap that contains the whole alphabet
     */
    private final KeyStorage keys;

    /**
     * default constructor
     */
    public HomophonicCipher() {
        keys = new KeyStorage();
        errMessage = "error";
    }

    /**
     * verify correctness of the message, is valid or not
     *
     * @param message
     * @throws MessageCorrectnessException - if message contains at least one invalid letter
     */
    private void verifyCorrectness(String message) throws MessageCorrectnessException {
        ArrayList<Character> alphabet = keys.getValues();

        for (char letter : message.toCharArray()) {
            if (!alphabet.contains(letter)) {
                throw new MessageCorrectnessException("Wrong symbol found");
            }
        }
    }

    /**
     * @param message - text that will be encrypted
     * @return - encrypted text
     */
    @Override
    public String encryptMessage(String message) {
        message = message.toUpperCase();

        try {
            verifyCorrectness(message);
        } catch (MessageCorrectnessException exception) {
            return errMessage;
        }

        var dictionary = keys.getDictionary();

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
    @Override
    public String decryptMessage(String message) {
        try {
            verifyCorrectness(message);
        } catch (MessageCorrectnessException exception) {
            return errMessage;
        }

        var dictionary = keys.getDictionary();

        String decrypted = new String();
        for (char letter : message.toCharArray()) {
            for (Character k : dictionary.keySet()) {
                var values = dictionary.get(k);

                if (values.contains(letter)) {
                    decrypted += k;
                    break;
                }
            }
        }

        return decrypted;
    }

    /**
     * allows handle this exception outside the model
     *
     * @return errMessage
     */
    public String getErrMessage() {
        return errMessage;
    }
}