package pl.polsl.lab.vartan.babayan.exceptionHandler;

/**
 * Exception to handle errors when user's input flag is wrong
 *
 * @author vartan babayan
 * @version 1.0
 */
public class UnsuitableInputException extends Exception {
    /**
     * constant that will contain thrown message
     */
    private final String ERROR;

    /**
     * @param exceptionMessage - message that will be thrown within exception
     */
    public UnsuitableInputException(String exceptionMessage) {
        super(exceptionMessage);
        ERROR = exceptionMessage;
    }

    /**
     * print error message that was shared within exception
     */
    public void printErrMsg() {
        System.out.println(ERROR);
    }
}