import java.util.Arrays;
import java.util.Scanner;

public class Main1248 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i,t = scanner.nextInt();
        int[] cnt;
        scanner.nextLine();
        String a,b,c;
        boolean f;

        while(t>0) {
            f = true;
            cnt = new int[128];

            a = scanner.nextLine();
            b = scanner.nextLine();
            c = scanner.nextLine();

            for(i=0;i<a.length();++i)
                ++cnt[a.charAt(i)];

            for(i=0;i<b.length();++i) {
                if(cnt[b.charAt(i)]>0)
                    a = a.replaceFirst(String.valueOf(b.charAt(i)), "");
                else {
                    f = false;
                    break;
                }
            }

            for(i=0;i<c.length();++i) {
                if(cnt[c.charAt(i)]>0)
                    a = a.replaceFirst(String.valueOf(c.charAt(i)), "");
                else {
                    f = false;
                    break;
                }
            }
            char[] arr = a.toCharArray();
            Arrays.sort(arr);
            if(f) {
                for(char ch: arr)
                    System.out.print(ch);
            } else
                System.out.print("CHEATER");
            System.out.println();
            --t;
        }
    }
}
