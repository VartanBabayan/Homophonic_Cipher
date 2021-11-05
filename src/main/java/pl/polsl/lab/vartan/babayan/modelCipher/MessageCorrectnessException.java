package pl.polsl.lab.vartan.babayan.modelCipher;

/**
 * Exception to handle the errors when
 * the message for E[ncryption] or [D]ecryption is not valid
 *
 * @author vartan babayan
 */
public class MessageCorrectnessException extends Exception {
    public MessageCorrectnessException(String exceptionMessage) {
        super(exceptionMessage);
    }
}