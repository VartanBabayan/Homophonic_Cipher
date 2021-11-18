package pl.polsl.lab.vartan.babayan.viewcipher;

import pl.polsl.lab.vartan.babayan.exceptionhandler.UnsuitableInputException;

/**
 * class to do necessary things to simplify interaction with user
 *
 * @author vartan babayan
 * @version 1.0
 */
public class UserInteraction {
    /**
     * processing user's inputs according to provided arguments
     *
     * @param args - list of arguments given by user
     * @throws UnsuitableInputException - exception that throws in case of wrong number of arguments provided by user
     */
    public void processInput(String[] args) throws UnsuitableInputException {
        int argLength = args.length;

        if (argLength != 2) {
            throw new UnsuitableInputException("You need to provide 2 arguments to run this program: " +
                    "\"the status and the message\"");
        }
    }

    /**
     * Inform user about wrong data
     */
    public void printWrongDataMessage() {
        System.out.println("-----Message contains improper symbols-----");
        System.out.println("-----You can input your message again------");
        System.out.println("-----Note that you can use only English alphabet-----");
    }

    /**
     * ask user about quitting the program
     */
    public void printDesireToQuitMessage() {
        System.out.println("-----Do you want to quit the program?-----");
    }

    /**
     * ask user about continuing working with [E]ncrypted or [D]ecrypted messages
     *
     * @param flag - state ([E] - for encryption, [D] - for decryption)
     * @return flag
     */
    public Character changeStateOfTheFlag(Character flag) {
        if (flag == 'E') {
            System.out.println("\n-----You can continue and [D]ecrypt your message "
                    + "to see how it works backward-----");

            flag = 'D';
        } else {
            System.out.println("\n-----You can continue and [E]ncrypt your message "
                    + "to see how it works backward-----");

            flag = 'E';
        }

        return flag;
    }
}