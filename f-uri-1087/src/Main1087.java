import java.util.Scanner;

public class Main1087 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int x1,y1,x2,y2;

        while(true) {

            x1 = scan.nextInt();
            y1 = scan.nextInt();
            x2 = scan.nextInt();
            y2 = scan.nextInt();

            if(x1 + y1 + x2 + y2 == 0)
                break;

            if(x1 == x2 && y1 == y2)
                System.out.println(0);
            else if(Math.abs(x2-x1) == Math.abs(y2-y1) || x1 == x2 || y1 == y2)
                System.out.println(1);
            else
                System.out.println(2);
        }
    }
}
