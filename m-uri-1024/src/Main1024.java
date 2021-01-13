import java.util.Scanner;

public class Main1024 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int l, t = sc.nextInt();
        sc.nextLine();

        String s;
        StringBuilder dec;
        char c;

        while(t>0)
        {
            dec = new StringBuilder();
            s = sc.nextLine();
            l = s.length();

            for(int i=l-1; i>=0; --i)
            {
                c = s.charAt(i);

                if(c>='A' && c<='Z' || (c>='a' && c<='z'))
                    dec.append((char)(c+3));
                else
                    dec.append(c);
            }

            for(int i=0; i<l/2;i++)
                System.out.print(dec.charAt(i));

            for(int i=l/2; i<l; i++) {
                c = dec.charAt(i);
                System.out.print(--c);
            }

            System.out.println();

            t--;
        }
    }
}
