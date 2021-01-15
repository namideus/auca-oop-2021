import java.util.ArrayList;
import java.util.Scanner;

public class Main1277 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str;
        int abs,val,pr,d, n = s.nextInt();
        s.nextLine();

        String[] std;
        boolean[] bad;

        for(int t=0; t<n; t++)
        {
            d = s.nextInt();

            bad = new boolean[d];
            std = new String[d];

            for(int i=0; i<d; i++)
                std[i] = s.next();

            for(int i=0; i<d; i++)
            {
                abs = val = pr = 0;
                str = s.next();

                for(int j=0; j<str.length(); j++)
                {
                    if(str.charAt(j)=='A')
                        ++abs;
                    else if(str.charAt(j)=='P')
                        ++pr;
                    else
                        ++val;
                }

                if((100.0*pr)/(str.length()-val)<75)
                    bad[i] = true;
            }

            for(int i=0; i<d; i++)
                if(bad[i])
                    System.out.print(std[i] + " ");

            System.out.println();
        }
    }
}
