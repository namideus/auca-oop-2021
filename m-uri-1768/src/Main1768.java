import java.util.Scanner;

public class Main1768 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n, i, j;

        while(s.hasNext())
        {
            n = s.nextInt();

            for(i=1; i<=n; i+=2)
            {
                for(j = n/2-i/2; j>=1 ; j--)
                    System.out.print(" ");

                for(j=0; j<i; j++)
                    System.out.print("*");

                System.out.println();
            }

            for(i=n/2; i>=1; i--)
                System.out.print(" ");
            System.out.print("*\n");

            for(i=n/2-1; i>=1; i--)
                System.out.print(" ");
            System.out.print("***\n");

            System.out.print("\n");
        }
    }
}
