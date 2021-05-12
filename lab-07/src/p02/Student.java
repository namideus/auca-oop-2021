package p02;

public class Student {
    private final String name;
    private final double GPA;
    private final int birthYear;

    public Student(String name, double GPA, int birthYear) {
        this.name = name;
        this.GPA = GPA;
        this.birthYear = birthYear;
    }

    public String getName() {
        return name;
    }

    public double getGPA() {
        return GPA;
    }


    public int getBirthYear() {
        return birthYear;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", GPA=" + GPA +
                ", birthYear=" + birthYear +
                '}';
    }
}
