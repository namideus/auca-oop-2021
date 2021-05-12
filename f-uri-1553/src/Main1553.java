import java.util.Scanner;

public class Main1553 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int i, q, n, k;
        int[] cnt;

        while(scan.hasNextInt()) {
            n = scan.nextInt();
            k = scan.nextInt();

            if(n + k==0)
                break;

            cnt = new int[101];
            q = 0;

            for(i=0; i<n; i++)
                cnt[scan.nextInt()]++;

            for(i=1; i<=100; i++)
                if(cnt[i] >= k)
                    q++;

            System.out.println(q);
        }
    }
}
