import java.util.Scanner;

public class Main1222 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n,l,c,p,cnt,i,ln;
        String line,word;

        while(scanner.hasNextInt()) {
            cnt = ln = p = 0;
            n = scanner.nextInt();
            l = scanner.nextInt();
            c = scanner.nextInt();
            scanner.nextLine();
            line = scanner.nextLine();

            Scanner strScan = new Scanner(line);

            while(strScan.hasNext()) {
                word = strScan.next();
                cnt+=word.length()+1;

                if(cnt==c || cnt-1==c)
                {
                    ++ln;
                    cnt = 0;
                } else if(cnt>c || cnt-2>c)
                {
                    ++ln;
                    cnt = word.length()+1;
                }

                if(ln==l)
                {
                    ++p;
                    ln = 0;
                }
            }

            if(cnt>0 || ln>0)
                ++p;
            System.out.println(p);
        }
    }
}
