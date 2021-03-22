import java.util.ArrayList;
import java.util.Scanner;

public class Main1618 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n, ax,ay,bx,by,cx,cy,dx,dy,rx,ry;
        n = scan.nextInt();
        scan.nextLine();
        while(n>0)
        {
            ax = scan.nextInt();
            ay = scan.nextInt();
            bx = scan.nextInt();
            by = scan.nextInt();
            cx = scan.nextInt();
            cy = scan.nextInt();
            dx = scan.nextInt();
            dy = scan.nextInt();
            rx = scan.nextInt();
            ry = scan.nextInt();

            System.out.println(rx>=ax && ry>=ay && rx<=bx && ry>=by && rx>=dx && ry<=dy && rx<=cx && ry<=cy ? 1 : 0);

            --n;
        }
    }
}
