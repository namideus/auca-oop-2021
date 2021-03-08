import java.util.Scanner;

public class Main1263 {
    public static void main(String[] args) {
        Scanner strScan, scan = new Scanner(System.in);
        StringBuilder sb;
        String a;
        int cnt, j;
        boolean f;

        while(scan.hasNextLine()) {
            a = scan.nextLine();
            cnt = 0;
            f = false;
            sb = new StringBuilder();

            strScan = new Scanner(a);

            while(strScan.hasNext())
                sb.append(strScan.next().charAt(0));

            for(j=0; j<sb.length()-1; ++j) {
                if(Character.toLowerCase(sb.charAt(j))==Character.toLowerCase(sb.charAt(j+1)))
                    f = true;
                else {
                    if(f) {
                        ++cnt;
                        f = false;
                    }
                }
            }

            if(f)
                ++cnt;

            System.out.println(cnt);
        }
    }
}
