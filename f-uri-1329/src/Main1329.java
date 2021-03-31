import java.util.Scanner;

public class Main1329 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int i, d, n, m;
        int[] cnt = new int[2];

        while(scan.hasNextInt()) {

            n = scan.nextInt();

            if(n==0) break;

            cnt[0] = cnt[1] = 0;

            for(i=0; i<n; i++)
                cnt[scan.nextInt()]++;

            System.out.printf("Mary won %d times and John won %d times\n", cnt[0], cnt[1]);
        }
    }
}
