import java.util.Scanner;

public class Main1285 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n, m,c,mx,num;
        int[] cnt;

        while(scan.hasNextInt()) {
            n = scan.nextInt();
            m = scan.nextInt();
            c = 0;

            for (int d = n; d <= m; d++) {
                cnt = new int[10];
                mx = 0;
                num = d;

                while (num > 0) {
                    cnt[num % 10]++;
                    mx = Math.max(mx, cnt[num % 10]);
                    num /= 10;
                }

                if (mx == 1)
                    c++;
            }
            System.out.println(c);
        }
    }
}
