import java.util.Scanner;

public class Main1254 {
    public static void main(String[] args) {
        Scanner strScanner, scanner = new Scanner(System.in);
        String tag, line, str;
        int num,i,j,k;
        boolean match, f, print,cond=true;
        char ch;

        while(scanner.hasNext())
        {
            f = false;
            print = true;

            str = scanner.nextLine();
            scanner.nextLine();

            strScanner = new Scanner(str);
            tag = strScanner.next();
            num = strScanner.nextInt();
            line = strScanner.nextLine();

            for(i=0; i<line.length(); ++i)
            {
                if(f)
                {
                    match = true;

                    for(j=0, k=i; j<tag.length(); ++j,++k)
                    {
                        if(Character.toLowerCase(line.charAt(k))!=Character.toLowerCase(tag.charAt(j))) {
                            match = false;
                            break;
                        }
                    }

                    if(match)
                    {
                        i+=tag.length()-1;
                        print = false;
                        System.out.print(num);
                    }
                }

                if(print)
                {
                    ch = line.charAt(i);
                    if(ch=='<')
                        f = true;
                    else if(ch=='>')
                        f = false;
                    System.out.print(ch);
                } else
                    print = true;
            }
            System.out.println();
        }
    }
}
