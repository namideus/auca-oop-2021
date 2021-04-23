import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.ConcurrentSkipListSet;

public class Main1104 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a,b,i,k1,k2;
        ConcurrentSkipListSet<Integer> s1, s2;

        while(scan.hasNextInt())
        {
            a = scan.nextInt();
            b = scan.nextInt();

            if(a+b==0)
                break;

            s1 = new ConcurrentSkipListSet<>();
            s2 = new ConcurrentSkipListSet<>();

            for(i=0; i<a; i++)
                s1.add(scan.nextInt());

            for(i=0; i<b; i++)
                s2.add(scan.nextInt());

            for(Integer key : s1)
            {
                if(s2.contains(key))
                {
                    s2.remove(key);
                    s1.remove(key);
                }
            }

            for(Integer key : s2)
            {
                if(s1.contains(key))
                {
                    s2.remove(key);
                    s1.remove(key);
                }
            }

            System.out.println(Math.min(s2.size(), s1.size()));
        }
    }
}
