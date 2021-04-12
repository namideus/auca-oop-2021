import java.util.Scanner;
import java.util.StringTokenizer;

public class Main1218 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringTokenizer stStr;
        int sze, n, t, i, f, m;
        char g;
        String str;

        t = 0;
        while(scan.hasNextInt()) {
            n = scan.nextInt();
            scan.nextLine();

            if(t!=0)
                System.out.println();

            f = m = 0;

            str = scan.nextLine();
            stStr = new StringTokenizer(str);

            while(stStr.hasMoreTokens()) {
                sze = Integer.parseInt(stStr.nextToken());
                g = stStr.nextToken().charAt(0);

                if(sze==n)
                    if(g=='M')
                        ++m;
                    else
                        ++f;
            }

            ++t;

            System.out.printf("Caso %d:\nPares Iguais: %d\nF: %d\nM: %d\n", t, m+f, f, m);
        }
    }
}
