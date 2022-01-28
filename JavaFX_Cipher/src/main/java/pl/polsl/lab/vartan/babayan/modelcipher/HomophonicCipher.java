package pl.polsl.lab.vartan.babayan.modelcipher;

import pl.polsl.lab.vartan.babayan.exceptionhandler.MessageCorrectnessException;
import pl.polsl.lab.vartan.babayan.alphabetcipher.KeyStorage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Model - HomophonicCipher which implements main part of the program
 *
 * @author vartan babayan
 * @version 1.0
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
     * @param message - message that sent by user to [E]ncrypt or [D]ecrypt
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

        HashMap<Character, ArrayList<Character>> dictionary = keys.getDictionary();

        StringBuilder encryptedMsg = new StringBuilder();
        Random random = new java.util.Random();
        for (char letter : message.toCharArray()) {
            ArrayList<Character> x = dictionary.get(letter);
            if (x != null) {
                int randomValue = random.nextInt(x.size());
                encryptedMsg.append(x.get(randomValue));
            }
        }

        return encryptedMsg.toString();
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

        HashMap<Character, ArrayList<Character>> dictionary = keys.getDictionary();

        StringBuilder decrypted = new StringBuilder();
        for (char letter : message.toCharArray()) {
            for (Character k : dictionary.keySet()) {
                ArrayList<Character> values = dictionary.get(k);

                if (values.contains(letter)) {
                    decrypted.append(k);
                    break;
                }
            }
        }

        return decrypted.toString();
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
