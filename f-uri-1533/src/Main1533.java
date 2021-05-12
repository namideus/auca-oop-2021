import java.sql.SQLOutput;
import java.util.*;

public class Main1533 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n;
        Map<Integer, Integer> map;

        while(scan.hasNextInt()) {
            n = scan.nextInt();

            if(n==0)
                break;

            map = new TreeMap<>();

            for(int i=1; i<=n; i++)
                map.put(scan.nextInt(), i);

            ArrayList<Integer> list = new ArrayList(map.keySet());
            System.out.println(map.get(list.get(n-2)).intValue());
        }
    }
}
