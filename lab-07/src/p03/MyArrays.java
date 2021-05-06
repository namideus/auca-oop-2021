package p03;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;

public class MyArrays {
    public static void main(String[] args) {
        Integer[] a1  = {6,8,4,4,2,1};
        Arrays.sort(a1, new MyIntComparator());
        System.out.println(Arrays.toString(a1));

        System.out.println("----");

        Student[] students = {
                new Student("StudentD", 4.0, 1997),
                new Student("StudentC", 3.2, 2003),
                new Student("StudentB", 2.2, 2000),
                new Student("StudentA", 1.2, 1998)
        };
        Arrays.sort(students, new StudentComparatorName());
        System.out.println(Arrays.toString(students));

        System.out.println("----");

        BigRational[] a3 = {
                BigRational.parse("2/3"),
                BigRational.parse("1/3"),
                BigRational.parse("7/2"),
                BigRational.parse("5/7"),
                BigRational.parse("1/2")
        };
        Arrays.sort(a3, new MyRationalComparator());
        System.out.println(Arrays.toString(a3));

    }
}

class MyIntComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer i1, Integer i2) {
        return Integer.compare(i1, i2);
    }
}

class MyRationalComparator implements Comparator<BigRational> {

    @Override
    public int compare(BigRational bigRational1, BigRational bigRational2) {
        BigInteger p1 = bigRational1.getNominator().multiply(bigRational2.getDenominator());
        BigInteger p2 = bigRational1.getDenominator().multiply(bigRational2.getNominator());
        return p1.compareTo(p2);
    }
}

class MyComparable implements Comparable<Integer> {

    @Override
    public int compareTo(Integer integer) {
        return 0;
    }
}

class StudentComparatorName implements Comparator<Student>{

    @Override
    public int compare(Student s1, Student s2) {
        return s1.getName().compareTo(s2.getName());
    }
}
