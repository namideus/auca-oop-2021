import java.util.Scanner;

public class Main1287 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int i, j, t;
        long d;
        String s;
        StringBuilder strBuilder;
        char ch;

        while (scanner.hasNextLine())
        {
            d=0;
            strBuilder = new StringBuilder();
            s = scanner.nextLine();

            for(i=0; i<s.length(); i++)
            {
                ch = s.charAt(i);
                if(ch==' ' || ch==',') {

                }
                else if(Character.isDigit(ch))
                {
                    d = d*10+(ch-'0');
                    strBuilder.append(ch);
                }
                else if(Character.isAlphabetic(ch))
                {
                    if(ch=='o' || ch=='O')
                    {
                        d*=10;
                        strBuilder.append(ch);
                    }
                    else if(ch=='l')
                    {
                        d = d*10 + 1;
                        strBuilder.append(ch);
                    }
                    else {
                        d = -1;
                        break;
                    }
                }
            }
            if(d>2147483647 || d < 0 || strBuilder.length()==0)
                System.out.println("error");
            else
                System.out.println(d);
            }
    }
}
