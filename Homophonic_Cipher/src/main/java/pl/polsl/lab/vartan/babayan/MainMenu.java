package pl.polsl.lab.vartan.babayan;

import pl.polsl.lab.vartan.babayan.controllerCipher.Controller;
import pl.polsl.lab.vartan.babayan.viewCipher.CipherViewer;
import pl.polsl.lab.vartan.babayan.viewCipher.UserInteraction;
import pl.polsl.lab.vartan.babayan.viewCipher.UnsuitableInputException;

/**
 * Main class where program starts
 *
 * @author vartan babayan
 */
public class MainMenu {
    public static void main(String[] args) {
        int argLength = args.length;
        boolean isValidInput = false;
        Character flag = ' ';
        String message = new String();

        try {
            if (argLength < 2) {
                throw new UnsuitableInputException("You need to provide 2 arguments to run this program: " +
                                                                            "\"the status and the message\"");
            } else if (argLength == 2) {
                flag = args[0].charAt(0);
                flag = Character.toUpperCase(flag);
                message = args[1];
                isValidInput = true;
            } else {
                throw new UnsuitableInputException("too many arguments...");
            }
        } catch (UnsuitableInputException exception) {
            exception.printErrMsg();
        }

        CipherViewer viewer = new CipherViewer();
        UserInteraction uiProvider = new UserInteraction();
        if (!isValidInput) {
            flag = viewer.inputFlag();
            message = viewer.inputMessage();
        }

        Controller controller = new Controller();
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

        System.exit(0);
    }
}