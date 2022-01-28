package pl.polsl.lab.vartan.babayan.exceptionhandler;

/**
 * Exception to handle the errors when
 * the message for E[ncryption] or [D]ecryption is not valid
 *
 * @author vartan babayan
 * @version 1.0
 */
public class MessageCorrectnessException extends Exception {
    /**
     * default constructor
     *
     * @param exceptionMessage - message that will be thrown within exception
     */
    public MessageCorrectnessException(String exceptionMessage) {
        super(exceptionMessage);
    }
}