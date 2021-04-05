import java.util.Scanner;

public class Main1437 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int i,j,n;
        String s,d;
        d = "NLSO";
        while(scan.hasNextInt()) {
            n = scan.nextInt();
            scan.nextLine();
            if(n==0)
                break;
            s = scan.next();
            j = 0;

            for(i=0; i<s.length(); i++) {
                if(s.charAt(i)=='D')
                    if(j<3)
                        j++;
                    else
                        j = 0;

                if(s.charAt(i)=='E')
                    if(j>0)
                        j--;
                    else
                        j = 3;
            }
            System.out.println(d.charAt(j));
        }
    }
}
