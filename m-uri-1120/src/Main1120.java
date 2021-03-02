import java.util.Scanner;

public class Main1120 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String b;
        char ch;
        StringBuilder res;
        int ok;
        boolean flag;

        while(scan.hasNext()) {
            ch = scan.next().charAt(0);
            b = scan.next();

            if(ch=='0' && b.equals("0"))
                break;

            res = new StringBuilder();
            ok = 0;

            for(int i=0; i<b.length(); i++)
            {

                if(ch != b.charAt(i))
                {

                    res.append(b.charAt(i));
                    ok+=(b.charAt(i)-'0');
                }
            }
            flag = false;

            if(ok>0)
            {
                for(int i=0; i<res.length(); i++)
                {
                    if(flag)
                        System.out.print(res.charAt(i));

                    if(res.charAt(i)!='0')
                    {
                        if(!flag)
                        {
                            System.out.print(res.charAt(i));
                            flag=true;
                        }
                    }

                }
                System.out.println();
            }
            else
                System.out.println("0");
        }
    }
}
