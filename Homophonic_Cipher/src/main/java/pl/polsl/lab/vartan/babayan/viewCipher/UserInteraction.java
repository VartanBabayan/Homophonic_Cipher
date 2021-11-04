package pl.polsl.lab.vartan.babayan.viewCipher;

/**
 * class to do necessary things to simplify interaction with user
 */
public class UserInteraction {
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