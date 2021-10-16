package pl.polsl.lab.vartan.babayan.modelCipher;

import java.util.ArrayList;
import pl.polsl.lab.vartan.babayan.AlphabetCipher.KeyStorage;
import java.util.Random;

/**
 * Model - HomophonicCipher which implements main part of the program
 * @author vartan
 */
public class HomophonicCipher implements Cipher {
    /**
     * handle exception in case if message is not valid
     */
    private final String errMessage = "error";
    
    /**
     * allows handle this exception outside the model
     * @return errMessage
     */
    public String getErrMessage() {
        return this.errMessage;
    }
    
    /**
     * verify correctness of the message, is valid or not
     * @param message
     * @throws MessageCorrectnessException - 
     * if message contains symbols from other alphabet, throw the exception
     */
    private void verifyCorrectness(String message) throws MessageCorrectnessException {
        KeyStorage keys = new KeyStorage();
        ArrayList<Character> alphabet = keys.getValues();
        
        for(char letter : message.toCharArray()) {
            if(!alphabet.contains(letter)) {
                System.out.println(letter);
                System.out.println(message);
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
        }
        catch(MessageCorrectnessException exception) {
            return this.errMessage;
        }

        KeyStorage key = new KeyStorage();
        var dictionary = key.getDictionary();

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
        }
        catch(MessageCorrectnessException exception) {
            return this.errMessage;
        }
        
        KeyStorage key = new KeyStorage();
        var dictionary = key.getDictionary();

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