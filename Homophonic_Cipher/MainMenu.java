package Solution;

import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Select option you need: ");
        System.out.println("\" [E]ncrypt|[D]ecrypt: \"");

        Character flag = sc.nextLine().charAt(0);
        flag = Character.toUpperCase(flag);
        if (flag != 'E' && flag != 'D') {
            System.out.println("Choose appropriate option");
            System.exit(1);
        }

        System.out.println("Write the message: ");

        String message = sc.nextLine();
        sc.close();

        Controller handler;
        if (flag == 'E') {
            handler = new Controller(message, true);
        } else {
            handler = new Controller(message, false);
        }

        handler.printMessage();
    }
}
