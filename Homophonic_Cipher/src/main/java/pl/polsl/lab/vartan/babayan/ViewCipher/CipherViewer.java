package pl.polsl.lab.vartan.babayan.ViewCipher;

import java.util.Scanner;

/**
 * Viewer to print all obligatory things about cipher
 *
 * @author vartan babayan
 */
public class CipherViewer {
    /**
     * scanner to read user's input
     */
    private final Scanner scanner;

    /**
     * check correctness of user's input
     */
    private CorrectnessHandler checker;

    /**
     * contains state of each input
     */
    private boolean validInput;

    /**
     * show encryption
     */
    private final String viewEncryption;

    /**
     * show decryption
     */
    private final String viewDecryption;


    /**
     * default constructor
     */
    public CipherViewer() {
        scanner = new Scanner(System.in);
        checker = new CorrectnessHandler();
        validInput = false;
        viewEncryption = "ENCRYPTED MESSAGE: ";
        viewDecryption = "DECRYPTED MESSAGE: ";
    }

    /**
     * print [E]ncrypted/[D]ecrypted message
     *
     * @param message
     * @param flag    - true for [E] and false for [D]
     * @return appropriate string for user
     */
    public String createView(String message, Character flag) {
        if (flag == 'E') {
            return viewEncryption + message;
        }

        return viewDecryption + message;
    }

    /**
     * input flag avoiding not suitable symbols
     *
     * @return flag: [E] - to encrypt or [D] - to decrypt
     */
    public Character inputFlag() {
        validInput = false;
        Character flag = ' ';

        while (!validInput) {
            System.out.println("Select option you need: ");
            System.out.println("\" E - [e]ncrypt | D - [d]ecrypt: \"");

            String input = scanner.next();
            if (input.length() > 1) {
                continue;
            }

            flag = input.charAt(0);
            flag = Character.toUpperCase(flag);

            validInput = checker.isCorrectFlag(flag);
        }

        scanner.nextLine();
        return flag;
    }

    /**
     * input message for [E]ncryption/[D]ecryption
     *
     * @return message to encrypt/decrypt
     */
    public String inputMessage() {
        System.out.println("Write the message using only [English] letters: ");
        String message = scanner.nextLine();
        return message;
    }

    /**
     * ask user for his agreement to handle some requests
     *
     * @return true if YES, false if NO
     */
    public boolean inputAgreement() {
        validInput = false;

        String agreement = new String();
        boolean decision = false;
        while (!validInput) {
            System.out.println("YES - if you agree and NO - otherwise");
            agreement = scanner.nextLine();
            agreement = agreement.toUpperCase();

            this.validInput = checker.isCorrectDecision(agreement);
        }

        decision = agreement.equals("YES");
        return decision;
    }

    /**
     * allows user to choice - continue working with current messages or start session from zero
     *
     * @return 0 - for new session, 1 - for current session
     */
    public int inputChoice() {
        this.validInput = false;
        int flag = -1;

        while (!validInput) {
            System.out.println("If you want to start from the very beginning"
                    + " and input new message with particular option - ---press 0---");
            System.out.println("If you want to continue the previous session - ---press 1---");

            flag = scanner.nextInt();
            this.validInput = checker.isCorrectChoice(flag);
        }

        scanner.nextLine();
        return flag;
    }
}