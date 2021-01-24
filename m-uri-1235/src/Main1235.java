import java.util.Scanner;

public class Main1235 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int l,i,t = scanner.nextInt();
        scanner.nextLine();

        String line;

        while(t>0)
        {
            line = scanner.nextLine();
            l = line.length();

            for (i = l / 2-1; i>=0; --i)
                System.out.print(line.charAt(i));

            for(i=l-1; i>=l/2; --i)
                System.out.print(line.charAt(i));

            System.out.println();

            --t;
        }
    }
}
