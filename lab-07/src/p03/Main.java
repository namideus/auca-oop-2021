package p03;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        int[] a1  = {6,8,4,4,2,1};
        MyArrays.sort(a1);
        System.out.println(Arrays.toString(a1));

        System.out.println("----");

        double[] a2  = {6,8,4,4,2,1};
        MyArrays.sort(a2);
        System.out.println(Arrays.toString(a2));

        System.out.println("----");

        BigRational[] a3 = {
                BigRational.parse("2/3"),
                BigRational.parse("1/3"),
                BigRational.parse("7/2"),
                BigRational.parse("5/7"),
                BigRational.parse("1/2")
        };
        MyArrays.sort(a3);
        System.out.println(Arrays.toString(a3));

        System.out.println("----");

        Student[] students = {
                new Student("StudentH", 4.0, 1997),
                new Student("StudentC", 3.2, 2003),
                new Student("StudentB", 2.2, 2000),
                new Student("StudentA", 1.2, 1998)
        };
        MyArrays.sort(students, new StudentComparatorName());
        System.out.println(Arrays.toString(students));

        System.out.println("----");

        MyArrays.sort(students, new StudentComparatorGpa());
        System.out.println(Arrays.toString(students));

        System.out.println("----");

        MyArrays.sort(students, (o1, o2) -> {
            Student s1 = (Student) o1;
            Student s2 = (Student) o2;

            return Integer.compare(s1.getBirthYear(), s2.getBirthYear());
        });

        System.out.println(Arrays.toString(students));

    }
}

class StudentComparatorGpa implements MyComparator {

    @Override
    public int compare(Object o1, Object o2) {
        Student s1 = (Student)o1;
        Student s2 = (Student)o2;
        return Double.compare(s1.getGPA(), s2.getGPA());
    }
}

class StudentComparatorName implements MyComparator {

    @Override
    public int compare(Object o1, Object o2) {
        Student s1 = (Student)o1;
        Student s2 = (Student)o2;
        return s1.getName().compareTo(s2.getName());
    }
}

