import java.math.BigInteger;
import java.util.Scanner;

public class Problem02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter m: ");
        int m = scan.nextInt();
        System.out.print("Enter n: ");
        int n = scan.nextInt();
        System.out.println(gcd(m,n));
    }

    public static long gcd(long m, long n) {
        if(m%n==0)
            return n;
        return gcd(n, m%n);
    }
}
