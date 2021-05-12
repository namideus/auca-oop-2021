import java.util.Scanner;

public class Main1318 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int i, n, m, c;
        int[] cnt;

        while(scan.hasNextInt()) {
            n = scan.nextInt();
            m = scan.nextInt();

            if(n+m==0)
                break;

            c = 0;
            cnt = new int[10001];

            for(i=0; i<m; i++)
                cnt[scan.nextInt()]++;

            for(i=1; i<=10000; i++)
                if(cnt[i]>1)
                    c++;

            System.out.println(c);
        }
    }
}
