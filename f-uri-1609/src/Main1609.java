import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main1609 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t,n;

        Set<Integer> set;

        while(scan.hasNextInt()) {
            t = scan.nextInt();

            while(t>0) {
                n = scan.nextInt();
                set = new HashSet<>();

                while(n>0) {
                    set.add(scan.nextInt());
                    --n;
                }

                System.out.println(set.size());
                --t;
            }
        }
    }
}
