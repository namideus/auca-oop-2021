import java.util.Scanner;

public class Main1581 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int k, t = scanner.nextInt();
        boolean f;
        String a, b;

        while(t>0)
        {
            f = true;
            k = scanner.nextInt();
            a = scanner.next();

            for(int i=0; i<k-1; ++i)
            {
                b = scanner.next();

                if(!a.equals(b))
                    f = false;
            }

            System.out.println((f) ? a : "ingles");

            --t;
        }
    }
}
