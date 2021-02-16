import java.util.Scanner;

public class Main2157 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a,b,t=scanner.nextInt();
        scanner.nextLine();
        StringBuilder sb;
        while(t>0)
        {
            sb = new StringBuilder();
            a = Integer.parseInt(scanner.next());
            b = Integer.parseInt(scanner.next());

            for(int i=a; i<=b; ++i)
                sb.append(i);
            System.out.print(sb.toString());

            for(int i=sb.length()-1; i>=0; --i)
                System.out.print(sb.charAt(i));

            System.out.println();
            --t;
        }
    }
}
