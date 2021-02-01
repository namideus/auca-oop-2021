import java.util.Scanner;

public class Main1607 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cnt, l, t = scanner.nextInt();
        scanner.nextLine();
        String a,b;
        while(t>0)
        {
            cnt = 0;

            a = scanner.next();
            b = scanner.next();
            l = a.length();

            for(int i=0; i<l; ++i) {
                cnt += (a.charAt(i) <= b.charAt(i) ?
                        b.charAt(i) - a.charAt(i) : 26 - (a.charAt(i) - b.charAt(i)));
            }

            System.out.println(cnt);

            --t;
        }
    }
}
