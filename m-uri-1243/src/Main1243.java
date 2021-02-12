import java.util.Scanner;

public class Main1243 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i, j, cnt, len, sum, l, av,t;
        boolean f;
        String phrase, token;

        while (scanner.hasNextLine())
        {
            cnt=sum=0;
            phrase = scanner.nextLine();
            Scanner phraseScanner = new Scanner(phrase);

            while(phraseScanner.hasNext())
            {
                f = true;
                len=0;
                token = phraseScanner.next();
                l = token.length();

                for(i = 0; i<l; i++)
                {
                    if(Character.isDigit(token.charAt(i)) || token.charAt(i)=='.' && i!=l-1)
                    {
                        f = false;
                        break;
                    }
                    else if(token.charAt(i)=='.'){}
                    else ++len;
                }

                if(f) {
                    sum+=len;
                    ++cnt;
                }
            }
            if(cnt>0)
            {
                av = sum/cnt;
                if(av<=3)
                    System.out.println("250");
                if(av==4 || av==5)
                    System.out.println("500");
                if(av>=6)
                    System.out.println("1000");
            } else
                System.out.println("250");
        }
    }
}
