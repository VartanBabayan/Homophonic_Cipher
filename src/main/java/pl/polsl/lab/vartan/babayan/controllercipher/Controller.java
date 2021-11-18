package pl.polsl.lab.vartan.babayan.controllercipher;

import pl.polsl.lab.vartan.babayan.modelcipher.HomophonicCipher;
import pl.polsl.lab.vartan.babayan.viewcipher.CipherViewer;

/**
 * Controller to manage main processes
 *
 * @author vartan babayan
 * @version 1.0
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
    private final HomophonicCipher model;

    /**
     * interaction with viewer
     */
    private final CipherViewer viewer;

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

        return !this.message.equals(model.getErrMessage());
    }

    /**
     * request printing data from Viewer -> prints Data
     */
    public void printData() {
        viewer.createView(message, flag);
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