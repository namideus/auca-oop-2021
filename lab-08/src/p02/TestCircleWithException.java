package p02;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TestCircleWithException {
    public static void main(String[] args) {
        try {
            CircleWithException c1 = new CircleWithException(5);
            CircleWithException c2 = new CircleWithException(-5);
            CircleWithException c3 = new CircleWithException(0);

        } catch (IllegalArgumentException error) {
            System.out.println(error);
        }

        System.out.println("Number of objects created: " + CircleWithException.getNumberOfObjects());
    }
}
