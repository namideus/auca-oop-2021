import java.util.Scanner;

public class Main1031 {

    static int mod(int x, int n)
    {
        if(x<0)
            x = x%n + n;

        if(x>=n)
            x%=n;

        return x;
    }

    static int f(int n, int k)
    {
        int last = 0;

        for(int i=2; i<=n; i++)
        {
            last = (last+k);
            if(last>=i)
                last=mod(last,i);
        }

        last = mod(last-(k-1), n);

        return last+1;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n;
        while(scan.hasNextInt()) {
            n = scan.nextInt();
            if(n==0)
                break;

            for(int k=1; ;k++)
                if(f(n,k)==13) {
                    System.out.println(k);
                    break;
                }
        }
    }
}
