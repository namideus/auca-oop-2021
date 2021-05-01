package p01;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputMismatchExceptionDemo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n;
        while(true) {
            try {
                System.out.print("Enter an integer: ");
                n = scan.nextInt();
                System.out.printf("The number entered is %d\n", n);
                break;
            } catch (InputMismatchException error) {
                System.out.println("Try again. (Incorrect input: an integer is required)");
                scan.next();
            }
        }
    }
}
