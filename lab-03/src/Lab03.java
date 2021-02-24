public class Lab03 {


    public static void main(String[] args) {
        Rational a = new Rational(1, -30);
        Rational b = new Rational(1, -10);

        System.out.printf("%s + %s = %s%n", a, b, a.add(b));
        System.out.printf("%s - %s = %s%n", a, b, a.subtract(b));
        System.out.printf("%s * %s = %s%n", a, b, a.multiply(b));
        System.out.printf("%s / %s = %s%n", a, b, a.divide(b));
        System.out.printf("%s.compareTo(%s) = %s%n", a, b, a.compareTo(b));
    }
}

