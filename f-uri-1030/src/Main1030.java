import java.util.Scanner;

public class Main1030 {

    public static int f(int n, int k) {
        if(n==1)
            return 1;
        return (f(n-1, k)+k-1)%n+1;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n,tests,k;

        tests = scan.nextInt();

        for(int t=1; t<=tests; ++t) {
            n = scan.nextInt();
            k = scan.nextInt();
            System.out.printf("Case %d: %d\n", t, f(n,k));
        }
    }
}
