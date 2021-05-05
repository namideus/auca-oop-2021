package p02;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Student[] students = {
                new Student("Bektur", 3.2, 1997),
                new Student("Dddd", 3.2, 2003),
                new Student("Amar", 1.2, 2000)
        };
        Arrays.sort(students, new StudentComparatorName());
        System.out.println(Arrays.toString(students));

        System.out.println("----");

        Arrays.sort(students, new StudentComparatorGpa());
        System.out.println(Arrays.toString(students));

        System.out.println("----");

        Arrays.sort(students, Comparator.comparingInt(Student::getBirthYear));
        System.out.println(Arrays.toString(students));

    }
}

class StudentComparatorGpa implements Comparator<Student>{

    @Override
    public int compare(Student s1, Student s2) {
        return Double.compare(s1.getGPA(), s2.getGPA());
    }
}

class StudentComparatorName implements Comparator<Student>{

    @Override
    public int compare(Student s1, Student s2) {
        return s1.getName().compareTo(s2.getName());
    }
}

