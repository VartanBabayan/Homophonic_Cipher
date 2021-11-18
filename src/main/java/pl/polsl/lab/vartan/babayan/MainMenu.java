package pl.polsl.lab.vartan.babayan;

import pl.polsl.lab.vartan.babayan.controllercipher.Controller;
import pl.polsl.lab.vartan.babayan.viewcipher.CipherViewer;
import pl.polsl.lab.vartan.babayan.viewcipher.UserInteraction;
import pl.polsl.lab.vartan.babayan.exceptionhandler.UnsuitableInputException;

/**
 * Main class where program starts
 *
 * @author vartan babayan
 * @version 1.0
 */
public class MainMenu {
    /**
     * starter point, processing all logic of the program
     *
     * @param args - command line arguments provided by user
     */
    public static void main(String[] args) {
        Controller controller = new Controller();
        CipherViewer viewer = new CipherViewer();
        UserInteraction uiProvider = new UserInteraction();

        boolean isValidInput = true;
        Character flag = ' ';
        String message = "";

        try {
            uiProvider.processInput(args);
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

        boolean successfulSession = false;
        while (!successfulSession) {
            if (!controller.processData(message, flag)) {
                uiProvider.printWrongDataMessage();
                uiProvider.printDesireToQuitMessage();

                if (viewer.inputAgreement()) {
                    successfulSession = true;
                    continue;
                } else {
                    message = viewer.inputMessage();
                }
            }

            controller.printData();
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
                    message = controller.getMessage();
                }
            }
        }
    }
}