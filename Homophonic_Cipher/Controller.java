package Solution;

public class Controller {
    /**
     * message to cipher
     */
    private String message;

    /**
     * status to define, encrypt or decrypt the message
     */
    private boolean status;

    /**
     * sending data to Model which return a processed message
     */
    private void processData() {
        if (status) {
            this.message = HomophonicCipher.encrypt(message);
        } else {
            this.message = HomophonicCipher.decrypt(message);
        }
    }

    public Controller(String message, boolean status) {
        this.message = message;
        this.status = status;
        processData();
    }

    public String getMessage() {
        return this.message;
    }

    public void printMessage() {
        CipherViewer.printCipher(message, status);
    }
}
