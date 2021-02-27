import java.util.Scanner;

public class BigRationalTest {
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        while(true) {
            try {
                readAndCompute();
            } catch(RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void readAndCompute() {
        BigRational r1 = readRational("Enter 1st rational (EOF for exit): ");
        String op = readOperator();
        BigRational r2 = readRational("Enter 2nd rational (EOF for exit): ");

        switch (op) {
            case "+":
                System.out.printf("%s + %s = %s%n", r1, r2, r1.add(r2));
                break;
            case "-":
                System.out.printf("%s - %s = %s%n", r1, r2, r1.subtract(r2));
                break;
            case "*":
                System.out.printf("%s * %s = %s%n", r1, r2, r1.multiply(r2));
                break;
            case "/":
                System.out.printf("%s / %s = %s%n", r1, r2, r1.divide(r2));
                break;
            case "=":
                System.out.printf("%s = %s: %s%n", r1, r2, r1.compareTo(r2)==0);
                break;
            case "!=":
                System.out.printf("%s != %s: %s%n", r1, r2, r1.compareTo(r2)!=0);
                break;
            case "<":
                System.out.printf("%s < %s: %s%n", r1, r2, r1.compareTo(r2)<0);
                break;
            case ">":
                System.out.printf("%s > %s: %s%n", r1, r2, r1.compareTo(r2)>0);
                break;
            case "<=":
                System.out.printf("%s <= %s: %s%n", r1, r2, r1.compareTo(r2)<=0);
                break;
            case ">=":
                System.out.printf("%s >= %s: %s%n", r1, r2, r1.compareTo(r2)>=0);
                break;
        }
    }

    private static BigRational readRational(String msg) {
        while(true) {
                System.out.print(msg);
                if(!scan.hasNextLine()) {
                    System.exit(0);
                }
                try {
                    return BigRational.parse(scan.nextLine());
                } catch(RuntimeException e) {
                    System.out.println("Rational is not correct");
                    System.out.println(e.getMessage());
                }

        }
    }

    private static String readOperator() {
        while(true) {
            System.out.print("Enter operator (EOF for exit): ");
            if(!scan.hasNextLine()) {
                System.exit(0);
            }
            String r = scan.nextLine().trim();
            switch (r) {
                case "+":
                case "-":
                case "*":
                case "/":
                case "=":
                case "!=":
                case "<":
                case ">":
                case "<=":
                case ">=":
                    return r;
                default:
                    System.out.println("Incorrect operator: "+r);
            }
        }
    }
}

