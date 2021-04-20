import java.util.Scanner;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Main1558 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n, i, j, s;
        boolean f;

        while(scan.hasNextInt())
        {
            n = scan.nextInt();

            f = false;
            i = 0;
            j = (int)sqrt(n);

            while(j>=i) {
                s =(int)(pow(i,2) + pow(j, 2));

                if(n==s) {
                    f = true;
                    break;
                } else if(s<n)
                    ++i;
                else
                    --j;
            }
            System.out.println(((f)?"YES":"NO"));
        }
    }
}
