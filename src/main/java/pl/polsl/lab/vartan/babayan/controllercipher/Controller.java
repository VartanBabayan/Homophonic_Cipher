package pl.polsl.lab.vartan.babayan.controllercipher;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;

import pl.polsl.lab.vartan.babayan.exceptionhandler.UnsuitableInputException;
import pl.polsl.lab.vartan.babayan.modelcipher.HomophonicCipher;
import pl.polsl.lab.vartan.babayan.viewcipher.CipherViewer;
import pl.polsl.lab.vartan.babayan.viewcipher.UserInteraction;

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
    public Controller(CipherViewer viewer, HomophonicCipher model) {
        this.viewer = viewer;
        this.model = model;
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
     * initialization of all parameters for future processing
     *
     * @param args - command line arguments provided by user
     */
    public void initSession(String[] args) {
        boolean isValidInput = true;

        try {
            viewer.processInput(args);
        } catch (UnsuitableInputException exception) {
            exception.printErrMsg();
            isValidInput = false;
        }

        if (!isValidInput) {
            flag = viewer.inputFlag();
            message = viewer.inputMessage();
        } else {
            flag = Character.toUpperCase(args[0].charAt(0));
            message = args[1];
        }
    }

    /**
     * point where program starts processing data
     */
    public void runSession() {
        UserInteraction uiProvider = new UserInteraction();

        boolean successfulSession = false;
        while (!successfulSession) {
            if (!this.processData(message, flag)) {
                uiProvider.printWrongDataMessage();
                uiProvider.printDesireToQuitMessage();

                if (viewer.inputAgreement()) {
                    successfulSession = true;
                    continue;
                } else {
                    message = viewer.inputMessage();
                }
            }

            this.printData();
            flag = uiProvider.changeStateOfTheFlag(flag);

            boolean isAgreed = viewer.inputAgreement();
            if (!isAgreed) {
                successfulSession = true;
            } else {
                int choice = viewer.inputChoice();

                if (choice == 0) {
                    flag = viewer.inputFlag();
                    message = viewer.inputMessage();
                } else {
                    message = this.getMessage();
                }
            }
        }
    }

    /**
     * request printing data from Viewer -> prints Data
     */
    public void printData() {
        viewer.createView(message, flag);
    }

    /**
     * setter for attribute message
     *
     * @param message - message that contains text which will be processed by encoder
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * setter for attribute <flag>
     *
     * @param flag - contains flag that represents the option (Encryption or Decryption)
     */
    public void setFlag(Character flag) {
        this.flag = flag;
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