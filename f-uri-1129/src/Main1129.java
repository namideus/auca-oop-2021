import java.util.Scanner;

public class Main1129 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t,i,a,b,c,d,e;
        boolean A,B,C,D,E;

        while(scan.hasNextInt()) {
            t = scan.nextInt();

            if(t==0)
                break;

            A = B = C = D = E = false;

            for(i=0; i<t; i++) {
                a = scan.nextInt();
                b = scan.nextInt();
                c = scan.nextInt();
                d = scan.nextInt();
                e = scan.nextInt();

                A = a <= 127;
                B = b <= 127;
                C = c <= 127;
                D = d <= 127;
                E = e <= 127;

                if(A && !B && !C && !D && !E)
                    System.out.println("A");
                else if(!A && B && !C && !D && !E)
                    System.out.println("B");
                else if(!A && !B && C && !D && !E)
                    System.out.println("C");
                else if(!A && !B && !C && D && !E)
                    System.out.println("D");
                else if(!A && !B && !C && !D && E)
                    System.out.println("E");
                else
                    System.out.println("*");
            }
        }
    }
}
