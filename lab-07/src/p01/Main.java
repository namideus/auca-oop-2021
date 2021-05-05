package p01;

import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] a1 = {5, 1, 3, 0, 2, 4};
        Arrays.sort(a1);
        System.out.println(Arrays.toString(a1));

        String[] a2 = {"Java", "C++", "C", "Kotlin", "Python", "Scala"};
        Arrays.sort(a2);
        System.out.println(Arrays.toString(a2));

        BigInteger[] a3 = {
                new BigInteger("123123123"),
                new BigInteger("23123"),
                new BigInteger("231231231231231")
        };
        Arrays.sort(a3);
        System.out.println(Arrays.toString(a3));

        BigRational[] a4 = {
                BigRational.parse("7/123129"),
                BigRational.parse("7/1"),
                BigRational.parse("7/123"),
                BigRational.parse("7/123123123")
        };
        Arrays.sort(a4);
        System.out.println(Arrays.toString(a4));

        System.out.println(a4[0].compareTo(a4[1]) < 0);
    }
}
