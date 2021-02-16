import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main1367 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n,t,s,p;
        int[] time, cnt;
        String correct;
        char ch;
        while(scanner.hasNextInt()) {
            n = scanner.nextInt();

            if(n==0) break;

            scanner.nextLine();

            time = new int[128];
            cnt = new int[128];

            s = p = 0;
            while(n>0)
            {
                ch = scanner.next().toCharArray()[0];
                t = Integer.parseInt(scanner.next());
                correct = scanner.next();

                if(correct.equals("correct"))
                {
                    time[ch]+=t;
                    if(cnt[ch]>0)
                        time[ch] += cnt[ch]*20;
                } else
                    cnt[ch]++;
                --n;
            }
            for(int i=0; i<128; ++i)
            {
                p+=time[i];
                if(time[i]>0)
                    ++s;
            }
            System.out.println(s+" "+p);
        }
    }
}

