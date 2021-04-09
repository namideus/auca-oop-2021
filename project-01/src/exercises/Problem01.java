package exercises;

import java.math.BigInteger;
import java.util.Scanner;

public class Problem01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        System.out.println(factorial(new BigInteger(scan.next())));
    }

    public static BigInteger factorial(BigInteger n) {
        if(n.equals(BigInteger.ZERO) || n.equals(BigInteger.ONE))
            return BigInteger.ONE;
        return factorial(n.subtract(BigInteger.ONE)).multiply(n);
    }
}
