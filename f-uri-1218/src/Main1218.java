import java.util.Scanner;

public class Main1218 {
    public static void main(String[] args) {
        Scanner strScan, scan = new Scanner(System.in);

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
            strScan = new Scanner(str);

            while(strScan.hasNextInt()) {
                sze = strScan.nextInt();
                g = strScan.next().charAt(0);

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
