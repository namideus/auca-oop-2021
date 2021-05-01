package p03;

public class TestCircleWithCustomException {
    public static void main(String[] args) {
        try {
            CircleWithCustomException c1 = new CircleWithCustomException(5);
            CircleWithCustomException c2 = new CircleWithCustomException(-5);
            CircleWithCustomException c3 = new CircleWithCustomException(0);

        } catch (InvalidRadiusException error) {
            System.out.println(error);
        }

        System.out.println("Number of objects created: " +
                CircleWithCustomException.getNumberOfObjects());
    }
}
