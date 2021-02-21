public class Lab03 {
    public static void main(String[] args) {
        Rational a = new Rational(1, 10);
        Rational b = new Rational(1, 10);

        System.out.printf("%s / %s = %s%n", a, b, a.divide(b));
        System.out.printf("%s * %s = %s%n", a, b, a.multiply(b));
        System.out.printf("%s + %s = %s%n", a, b, a.add(b));
        System.out.printf("%s - %s = %s%n", a, b, a.subtract(b));
    }
}
