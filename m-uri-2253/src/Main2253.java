import java.util.Scanner;

public class Main2253 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int l, i;
        boolean up, low, dig, p;
        String str;
        char ch;

        while(scanner.hasNextLine())
        {
            p=true;
            up=false;
            low=false;
            dig=false;

            str = scanner.nextLine();
            l=str.length();

            for(i=0; i<l; ++i)
            {
                ch = str.charAt(i);

                if(Character.isAlphabetic(ch))
                {
                    if(Character.isUpperCase(ch))
                        up=true;

                    if(Character.isLowerCase(ch))
                        low=true;
                } else if(Character.isDigit(ch))
                    dig = true;
                else
                    p = false;
            }

            System.out.println( (dig && up && low && p && l>=6 && l<=32) ?
                    "Senha valida." : "Senha invalida.");
        }
    }
}
