package hw3.Task1;

import java.util.InputMismatchException;
import java.util.Scanner;

class PasswordVerifier {
    public void passwordVerifier(String password)
            throws PasswordException {

        boolean digitFlag = false;
        boolean upperFlag = false;

        if (password.length() < 8)
            throw new PasswordException("The password must contain at least 8 characters");

        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i)))
                digitFlag = true;

            if (Character.isUpperCase(password.charAt(i)))
                upperFlag = true;
            
        }

        if (digitFlag == false)
            throw new PasswordException("The password must contain at least one digit");
        if (upperFlag == false)
            throw new PasswordException("The password must contain at least one capital letter");

    }
}

public class Main {
    public static void main(String[] args)
            throws PasswordException {
        Menu menu = new Menu();
        try {
            menu.menu();
            System.out.println("Password saved");
        } catch (PasswordException e) {
            System.out.println(e);
            main(args);
        } // catch (PasswordHasDigitException e) {
          // System.out.println(e);
          // } catch (PasswordHasUpperCaseException e) {
          // System.out.println(e);
          // }

    }
}

class Input {
    private void input() throws PasswordException {
        Scanner input = new Scanner(System.in);
        System.out.print("\nEnter the password: ");
        String password = input.next();

        PasswordVerifier passwordVerifier = new PasswordVerifier();
        passwordVerifier.passwordVerifier(password);
    }

    public void getInput() throws PasswordException {
        input();
    }
}

class Menu {
    public void menu() throws PasswordException {
        int choice;
        while (true) {
            try {
                Scanner input = new Scanner(System.in);
                System.out.print("\n1. Start \n2. Exit \n\nSelect an action: ");
                choice = input.nextInt();

                if (choice != 1 && choice != 2)
                    throw new InputMismatchException("Input mismatch, enter 1 or 2");

                break;

            } catch (InputMismatchException e) {
                System.out.println(e.getClass() + ": " + e.getMessage());
            }
        }

        switch (choice) {
            case 1:
                Input inputPassword = new Input();
                inputPassword.getInput();
                break;
            case 2:
                System.exit(choice);
                break;
            default:
                break;
        }
    }
}

class PasswordException extends Exception {
    public PasswordException(String message) {
        super(message);
    }
}

// class PasswordHasDigitException extends Exception {
// public PasswordHasDigitException(String message) {
// super(message);
// }
// }

// class PasswordHasUpperCaseException extends Exception {
// public PasswordHasUpperCaseException(String message) {
// super(message);
// }
// }