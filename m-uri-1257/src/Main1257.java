import java.util.Scanner;

public class Main1257 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s;
        int n,h,sum, t = scanner.nextInt();
        scanner.nextLine();

        while(t>0)
        {
            sum = 0;

            n = scanner.nextInt();
            scanner.nextLine();

            for(int i=0; i<n; ++i)
            {
                h = 0;
                s = scanner.next();

                for(int j=0; j<s.length(); ++j)
                        h+=i+j+((int)s.charAt(j)-65);

                sum += h;
            }

            System.out.println(sum);

            --t;
        }
    }
}
