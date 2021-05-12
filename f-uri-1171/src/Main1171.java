import java.util.*;

public class Main1171 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] arr = new int[2001];
        int n, t = scan.nextInt();
        scan.nextLine();

        Set<Integer> set = new TreeSet<>();

        while(t>0) {
            n = scan.nextInt();
            set.add(n);
            ++arr[n];
            --t;
        }

        for(int i : set)
            System.out.printf("%d aparece %d vez(es)\n", i, arr[i]);
    }
}
