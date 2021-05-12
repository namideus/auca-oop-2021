import java.util.Scanner;

public class Main1107 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean b;
        int a, c, cnt, w, x, tmp;

        while(scan.hasNextInt()) {
            a = scan.nextInt();
            c = scan.nextInt();

            if(a + c==0)
                break;

            cnt = 0;
            b = false;
            tmp = w = a;

            for(int i=0; i<c; ++i) {
                x = scan.nextInt();

                if (x <= tmp)
                    b = false;
                else {
                    if (!b)
                        cnt += w - tmp;
                    w = x;
                    b = true;
                }
                tmp = x;
            }
            if (!b)
                cnt += w - tmp;
            System.out.println(cnt);
        }
    }
}
