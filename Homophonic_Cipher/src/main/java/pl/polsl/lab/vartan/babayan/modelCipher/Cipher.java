package pl.polsl.lab.vartan.babayan.modelCipher;

/**
 * Provides interface for class which is supposed to provide the implementation of main algorithm
 *
 * @author vartan babayan
 */
public interface Cipher {
    /**
     * [E]ncrypt message using particular cipher
     *
     * @param message
     * @return [E]ncrypted message
     */
    String encryptMessage(String message);

    /**
     * [D]ncrypt message using particular decipher
     *
     * @param message
     * @return [D]ecrypted message
     */
    String decryptMessage(String message);
}