package hw2.Task1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
    private void input() throws InvalidNumberException {
        int enterNum;
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print("\nEnter a number: ");
                enterNum = sc.nextInt();
          
                if (enterNum > 0 && enterNum != 0) {
                    System.out.println("The number is correct");
                } else {
                    throw new InvalidNumberException("Invalid number, enter a valid number");
                }
            } catch (InputMismatchException e) {
                System.out.println(e.getClass() + ": Input mismatch, enter a number");
            } catch (InvalidNumberException e) {
                System.out.println(e);
            }
        }
    }

    public void startInput() throws InvalidNumberException {
        input();
    }
}
