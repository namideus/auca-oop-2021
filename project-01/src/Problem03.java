import java.util.Scanner;

public class Problem03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        System.out.println(sumDigits(scan.nextInt()));
    }

    public static long sumDigits(long n) {
        if(n==0)
            return 0;
        return sumDigits(n/10) + n%10;
    }
}
