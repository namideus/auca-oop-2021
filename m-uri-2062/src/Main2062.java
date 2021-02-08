import java.util.Scanner;

public class Main2062 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();

        String s;
        StringBuilder sb;

        for(int i=1; i<=t; i++)
        {
            s = scanner.next();
            sb = new StringBuilder(s);

            if(s.charAt(0)=='O' && s.charAt(1)=='B' && s.length()==3)
                sb.setCharAt(2, 'I');
            else if(s.charAt(0)=='U' &&  s.charAt(1)=='R' && s.length()==3)
                sb.setCharAt(2, 'I');

            System.out.print(sb.toString()+((i<t)? " " : ""));
        }
        System.out.println();
    }
}
