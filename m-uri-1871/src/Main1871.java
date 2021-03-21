import java.util.Scanner;

public class Main1871 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i,a,b,s;
        String q;

        while(scanner.hasNextInt())
        {
            a = scanner.nextInt();
            b = scanner.nextInt();

            if(a==0 && b==0)
                break;

            s = a+b;
            q = s+"";

            for(i=0; i<q.length(); ++i) {
                if (q.charAt(i) != '0')
                    System.out.print(q.charAt(i));
            }

            System.out.println();
        }
    }
}
