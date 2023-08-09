package hw2.Task2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
    private float inputDivisible() {
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print("Enter the divisible: ");
                float divisible = sc.nextFloat();

                return divisible;
            } catch (InputMismatchException e) {
                System.out.println(e.getClass() + ": Input mismatch, enter a number");
            }
        }
    }

    private float inputDivisor() throws DivisionByZeroException {
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print("Enter the divisor: ");
                float divisor = sc.nextFloat();

                if (divisor != 0)
                    return divisor;
                else {
                    throw new DivisionByZeroException("Division by zero is not allowed");
                }
            } catch (InputMismatchException e) {
                System.out.println(e.getClass() + ": Input mismatch, enter a number");
            } catch (DivisionByZeroException e) {
                System.out.println(e);
            }
        }
    }

    public float getinputDivisible() {
        return inputDivisible();
    }

    public float getinputDivisor() throws DivisionByZeroException {
        return inputDivisor();
    }
}
