import java.util.Scanner;

import static java.lang.Math.abs;

public class Main1300 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean b;
        int d, j, angle;

        while(scan.hasNextInt()) {
            d = scan.nextInt();

            b = false;
            j = 0;

            for(int i=0; i<60; ++i) {
                if(i%5==0) ++j;

                angle = (i-j)*6;
                if(d==abs(angle)) {
                    b = true;
                    break;
                }
            }
            System.out.println( b ? "Y" : "N" );
        }
    }
}
