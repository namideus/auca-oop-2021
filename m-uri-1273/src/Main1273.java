import java.util.ArrayList;
import java.util.Scanner;

public class Main1273 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s;
        int i,MAX, n;
        boolean f = false;
        ArrayList<String> arrayList;

        while(scanner.hasNextInt())
        {
            n = scanner.nextInt();

            if(n==0)
                break;

            if(f)
                System.out.println();

            MAX = 0;
            arrayList = new ArrayList<>();

            for(i=0; i<n; ++i)
            {
                s = scanner.next();
                arrayList.add(s);
                MAX = Math.max(MAX, s.length());
            }

            for(String str : arrayList)
            {
                for(i=0; i<MAX-str.length(); ++i)
                    System.out.print(" ");
                System.out.println(str);
            }
            f = true;
        }
    }
}
