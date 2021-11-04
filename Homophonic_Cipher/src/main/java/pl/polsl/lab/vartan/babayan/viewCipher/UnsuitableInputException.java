package pl.polsl.lab.vartan.babayan.viewCipher;

/**
 * Exception to handle errors when user's input flag is wrong
 */
public class UnsuitableInputException extends Exception{
    private final String ERRORMSG;

    /**
     *
     * @param exceptionMessage - message that was thrown within exception
     */
    public UnsuitableInputException(String exceptionMessage) {
        super(exceptionMessage);
        ERRORMSG = exceptionMessage;
    }

    /**
     * print error message that was shared within exception
     */
    public void printErrMsg() {
        System.out.println(ERRORMSG);
    }
}