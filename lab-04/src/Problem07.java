import java.util.*;

public class Problem07 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayListInt list = new ArrayListInt(); // ArrayListInt

        while(scan.hasNextInt()) {
            int x = scan.nextInt();
            list.add(x);
        }

        System.out.println("Before reversing:");
        System.out.println(list);

        int lft = 0;
        int rgt = list.size()-1;
        while(lft<rgt) {
            int x = list.get(lft);
            list.set(lft, list.get(rgt));
            list.set(rgt, x);
            ++lft;
            --rgt;
        }

        System.out.println("After reversing:");
        System.out.println(list);
    }
}
