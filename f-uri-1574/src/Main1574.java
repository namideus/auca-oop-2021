import java.util.ArrayList;
import java.util.Scanner;

public class Main1574 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String cmd,a,b;
        ArrayList<String> list;
        int t,l,r,i,n,pos;
        t = scan.nextInt();
        scan.nextLine();

        while(t>0) {
            l  = r = 0;
            n = scan.nextInt();

            list = new ArrayList<>();

            for(i=0; i<n; ++i) {
                cmd = scan.next();

                if(cmd.equals("LEFT") || cmd.equals("RIGHT")) {
                    list.add(cmd);
                } else {
                    scan.next();
                    pos = scan.nextInt();
                    list.add(list.get(pos-1));
                }
            }

            for(i=0; i<n; i++)
                if(list.get(i).equals("LEFT"))
                    ++l;
                else
                    ++r;

            System.out.println(r-l);

            --t;
        }
    }
}
