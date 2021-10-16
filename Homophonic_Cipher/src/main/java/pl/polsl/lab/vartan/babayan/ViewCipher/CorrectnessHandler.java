package pl.polsl.lab.vartan.babayan.ViewCipher;

/**
 *
 * @author vartan
 */
public class CorrectnessHandler {
    private final String errMsgHandler;
    
    public CorrectnessHandler() {
        this.errMsgHandler = "Choose appropriate option";
    }
    
    public boolean isCorrectFlag(Character flag) {
        if (flag != 'E' && flag != 'D') {
            System.out.println(this.errMsgHandler);
            return false;
        }
        return true;
    }
    
    public boolean isCorrectDecision(String agreement) {
        if(agreement.equals("YES") || agreement.equals("NO")) {
            return true;
        }
        return false;
    }
    
    public boolean isCorrectChoice(int flag) {
        if (flag != 0 && flag != 1) {
            System.out.println(this.errMsgHandler);
            return false;
        }
        return true;
    }
}
