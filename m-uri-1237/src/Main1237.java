import java.util.Scanner;

public class Main1237 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String a, b;
        int cnt, m,i,j,k,c;
        while(scan.hasNextLine()) {
            a = scan.nextLine();
            b = scan.nextLine();
            m = 0;

            for(i=0; i<a.length(); ++i) {
                for(j=0; j<b.length(); ++j) {
                    if (a.charAt(i) == b.charAt(j)) {
                        cnt = 0;
                        for (k = i, c = j; k < a.length() && c<b.length(); ++k, ++c) {
                            if (a.charAt(k) != b.charAt(c))
                                break;
                            cnt++;
                        }
                        m = Math.max(cnt, m);
                    }
                }
            }

            System.out.println(m);
        }
    }
}
