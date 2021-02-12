import java.util.Scanner;

public class Main1239 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i,bold=0, ital=0;
        String str;
        char ch;

        while(scanner.hasNextLine())
        {
            str = scanner.nextLine();

            for(i=0; i<str.length(); ++i)
            {
                ch = str.charAt(i);

                if(ch=='_')
                {
                    if(ital==0)
                        System.out.print("<i>");
                     else
                        System.out.print("</i>");
                    ital^=1;
                } else if(ch=='*')
                {
                    if(bold==0)
                        System.out.print("<b>");
                    else
                        System.out.print("</b>");
                    bold^=1;
                }
                else {
                    System.out.print(ch);
                }
            }
            System.out.println();
            }
        }
}
