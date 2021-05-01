package p03;

public class CircleWithCustomException {
    private double radius;

    private static int numberOfObjects = 0;

    public CircleWithCustomException() throws InvalidRadiusException {
        this(1.0);
    }

    public CircleWithCustomException(double radius) throws InvalidRadiusException {
        setRadius(radius);
        ++numberOfObjects;
    }

    public void setRadius(double radius) throws InvalidRadiusException{
        if(radius>=0) {
            this.radius = radius;
        } else
            throw new InvalidRadiusException(radius);
    }

    public double getRadius() {
        return radius;
    }

    public static int getNumberOfObjects() {
        return numberOfObjects;
    }

    public double getArea() {
        return radius*radius*3.14159;
    }
}
