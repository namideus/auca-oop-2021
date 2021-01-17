import java.util.Scanner;

public class Main1234 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str;
        char ch;
        int i, up;
        while(scanner.hasNextLine())
        {
            up = 1;

            str = scanner.nextLine();

            for(i=0; i<str.length(); i++)
            {
                ch = str.charAt(i);

                if(Character.isAlphabetic(ch))
                {
                    System.out.print((up==1)? Character.toUpperCase(ch) : Character.toLowerCase(ch) );
                    up^=1;
                } else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
}
