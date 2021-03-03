import java.util.*;

public class Problem04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayList<Integer> list = new ArrayList<>();

        while(scan.hasNextInt()) {
            int x = scan.nextInt();
            list.add(x);
        }

        System.out.println("Before reversing:");
        System.out.println(list);

        int lft = 0;
        int rgt = list.size()-1;
        while(lft<rgt) {
            Integer x = list.get(lft);
            list.set(lft, list.get(rgt));
            list.set(rgt, x);
            ++lft;
            --rgt;
        }

        System.out.println("After reversing:");
        System.out.println(list);
    }
}
