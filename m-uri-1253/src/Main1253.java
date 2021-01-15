import java.util.Scanner;

public class Main1253 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int l, shift, t = s.nextInt();
        s.nextLine();

        String msg;
        char ch;

        while(t>0) {
            msg = s.next();
            shift = s.nextInt();

            l = msg.length();

            for (int i = 0; i < l; i++)
            {
                ch = msg.charAt(i);
                if(ch-shift<65)
                    System.out.print((char)((ch-shift)+26));
                else
                    System.out.print((char)(ch-shift));
            }

            System.out.println();

            t--;
        }
    }
}
