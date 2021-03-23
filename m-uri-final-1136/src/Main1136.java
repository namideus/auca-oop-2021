import java.util.Scanner;

import static java.lang.Math.abs;

public class Main1136 {
    public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
        int i,j,n,b,c;

        while(scan.hasNextInt()) {
            n = scan.nextInt();
            b = scan.nextInt();

            if(n+b==0)
                break;

            int[] arr = new int[b];
            int[] cnt = new int[n+1];

            c=0;

            for(i=0; i<b; i++)
                arr[i] = scan.nextInt();

            for(i=0; i<b; i++)
                for(j=0; j<b; j++)
                    ++cnt[abs(arr[i]-arr[j])];

            for(i=0; i<=n; i++)
                if(cnt[i]>0)
                    c++;

            System.out.println((c==n+1) ? "Y" : "N");
        }
    }
}
