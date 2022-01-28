package pl.polsl.lab.vartan.babayan.modelcipher;

/**
 * Provides interface for class which is supposed to provide the implementation of main algorithm
 *
 * @author vartan babayan
 * @version 1.0
 */
public interface Serializable {
    /**
     * [E]ncrypt message using particular cipher
     *
     * @param message - string that will be encrypted
     * @return [E]ncrypted message
     */
    String encryptMessage(String message);

    /**
     * [D]ecrypt message using particular decipher
     *
     * @param message - string that will be decrypted
     * @return [D]ecrypted message
     */
    String decryptMessage(String message);
}