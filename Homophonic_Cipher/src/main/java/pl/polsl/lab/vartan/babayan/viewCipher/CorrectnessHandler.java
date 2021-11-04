package pl.polsl.lab.vartan.babayan.viewCipher;

/**
 * Special class to handle all errors that user may do
 *
 * @author vartan babayan
 */
public class CorrectnessHandler {
    /**
     * error message to use it when user sends wrong input
     */
    private final String errMessage;

    /**
     * default constructor
     */
    public CorrectnessHandler() {
        errMessage = "Choose appropriate option";
    }

    /**
     * check is flag sent by user correct or no
     *
     * @param flag
     * @return true if input is correct, false otherwise
     */
    public boolean isCorrectFlag(Character flag) {
        if (flag != 'E' && flag != 'D') {
            System.out.println(errMessage);
            return false;
        }
        return true;
    }

    /**
     * check is agreement sent by user correct or no
     *
     * @param agreement
     * @return true if input is correct, false otherwise
     */
    public boolean isCorrectDecision(String agreement) {
        return (agreement.equals("YES") || agreement.equals("NO"));
    }

    /**
     * check is choice sent by user correct or no
     *
     * @param choice
     * @return true if input is correct, false otherwise
     */
    public boolean isCorrectChoice(int choice) {
        if (choice != 0 && choice != 1) {
            System.out.println(errMessage);
            return false;
        }
        return true;
    }
}
