import java.awt.desktop.SystemSleepEvent;
import java.util.Scanner;

public class Main1272 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int i, t = scanner.nextInt();
        scanner.nextLine();

        String str;
        char ch;

        while(t>0)
        {
            str = scanner.nextLine();
            str+="\n";

            for(i=0; i<str.length(); ++i)
            {
                ch = str.charAt(i);

                if(Character.isAlphabetic(ch) && i==0)
                    System.out.print(ch);

                if(ch==' ' && Character.isAlphabetic(str.charAt(i+1)))
                    System.out.print(str.charAt(i+1));
            }
            System.out.println();

            --t;
        }
    }
}
