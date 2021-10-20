package pl.polsl.lab.vartan.babayan;

import pl.polsl.lab.vartan.babayan.ControllerCipher.Controller;
import pl.polsl.lab.vartan.babayan.ViewCipher.CipherViewer;

/**
 * Main class where program starts
 *
 * @author vartan babayan
 */
public class MainMenu {
    public static void main(String[] args) {
        System.out.println("------Welcome to the Homophonic Cipher app------");

        int argLength = args.length;
        boolean isValidInput = false;
        Character flag = ' ';
        String message = new String();

        if (argLength < 2) {
            System.out.println("-----You need to provide 2 arguments to run this program: "
                    + "the status and the message-----");
            System.out.println("-----1st argument -> E - to [e]ncrypt | D - to [d]ecrypt-----");
            System.out.println("-----2nd argument -> the message-----");
        } else if (argLength == 2) {
            flag = args[0].charAt(0);
            flag = Character.toUpperCase(flag);
            message = args[1];
            isValidInput = true;
        } else {
            System.out.println("-----too many arguments...-----");
        }

        CipherViewer viewer = new CipherViewer();
        if (!isValidInput) {
            flag = viewer.inputFlag();
            message = viewer.inputMessage();
        }

        Controller controller = new Controller();
        boolean successfulSession = false;

        while (!successfulSession) {
            if (!controller.processData(message, flag)) {
                System.out.println("-----Message contains improper symbols-----");
                System.out.println("-----You can input your message again------");
                System.out.println("-----Note that you can use only English alphabet-----");

                System.out.println("-----Do you want to quit the program?-----");
                if (viewer.inputAgreement()) {
                    successfulSession = true;
                    continue;
                } else {
                    System.out.println("-----Input new message: -----");
                    message = viewer.inputMessage();
                }
            }

            controller.printData();

            if (flag == 'E') {
                System.out.println("\n-----You can continue and [D]ecrypt your message "
                        + "to see how it works backward-----");

                flag = 'D';
            } else {
                System.out.println("\n-----You can continue and [E]ncrypt your message "
                        + "to see how it works backward-----");

                flag = 'E';
            }

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