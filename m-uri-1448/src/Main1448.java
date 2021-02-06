import java.util.Scanner;

public class Main1448 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a,b,c;
        boolean f;
        int c1,c2,tests = scanner.nextInt();
        scanner.nextLine();

        for(int t=1; t<=tests; ++t)
        {
            f = false;
            c1 = 0;
            c2 = 0;

            a = scanner.nextLine();
            b = scanner.nextLine();
            c = scanner.nextLine();

            for(int i=0; i<a.length(); ++i)
            {
                if(a.charAt(i)==b.charAt(i))
                    ++c1;

                if(a.charAt(i)==c.charAt(i))
                    ++c2;
            }

            System.out.println("Instancia "+t);

            if(c1==c2) {
                for (int i = 0; i < a.length(); ++i) {
                    if (a.charAt(i) == b.charAt(i) && a.charAt(i) != c.charAt(i)) {
                        System.out.println("time 1");
                        f = true;
                        break;
                    } else if (a.charAt(i) != b.charAt(i) && a.charAt(i) == c.charAt(i)) {
                        System.out.println("time 2");
                        f = true;
                        break;
                    }
                }
                if(!f)
                    System.out.println("empate");
            } else {
                if(c1>c2)
                    System.out.println("time 1");
                else
                    System.out.println("time 2");
            }
            System.out.println();
        }
    }
}
