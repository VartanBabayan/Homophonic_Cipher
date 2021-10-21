package pl.polsl.lab.vartan.babayan.ControllerCipher;

import pl.polsl.lab.vartan.babayan.modelCipher.HomophonicCipher;
import pl.polsl.lab.vartan.babayan.ViewCipher.CipherViewer;

/**
 * Controller to manage main processes
 *
 * @author vartan babayan
 */
public class Controller {
    /**
     * message to cipher
     */
    private String message;

    /**
     * status to define, encrypt or decrypt the message
     */
    private Character flag;

    /**
     * interaction with model
     */
    private HomophonicCipher model;

    /**
     * interaction with viewer
     */
    private CipherViewer viewer;

    /**
     * default constructor
     */
    public Controller() {
        viewer = new CipherViewer();
        model = new HomophonicCipher();
        message = " ";
        flag = ' ';
    }

    /**
     * sending data to Model which return a processed message
     *
     * @param message - to make cipher from the text
     * @param flag    - to know [E]ncrypt or [D]ecrypt
     * @return true if everything is okay, false if message contains errors
     */
    public boolean processData(String message, Character flag) {
        this.flag = flag;
        if (this.flag == 'E') {
            this.message = model.encryptMessage(message);
        } else {
            this.message = model.decryptMessage(message);
        }

        if (this.message.equals(model.getErrMessage())) {
            return false;
        }

        return true;
    }

    /**
     * print current Data for user
     */
    public void printData() {
        String data = viewer.createView(message, flag);
        System.out.println(data);
    }

    /**
     * @return message ([E]ncrypted or [D]ecrypted)
     */
    public String getMessage() {
        return this.message;
    }

    /**
     * true - [E]ncryption / false - [D]ecryption
     *
     * @return status
     */
    public Character getFlag() {
        return this.flag;
    }
}