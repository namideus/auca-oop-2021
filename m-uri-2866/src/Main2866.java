import java.util.Scanner;

public class Main2866 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();
        String s;
        while(t>0)
        {
            s = scanner.next();

            for(int i=s.length()-1; i>=0; --i)
                if(Character.isLowerCase(s.charAt(i)))
                    System.out.print(s.charAt(i));

            System.out.println();

            --t;
        }
    }
}
