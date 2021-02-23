import java.util.ArrayList;
import java.util.Scanner;

public class Main1277 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String str;
        String[] std;
        ArrayList<String> list;

        int val,pr,d, n = s.nextInt();
        s.nextLine();

        for(int t=0; t<n; t++) {
            d = s.nextInt();

            std = new String[d];
            list = new ArrayList<>();

            for(int i=0; i<d; i++)
                std[i] = s.next();

            for(int i=0; i<d; i++) {
                val = pr = 0;
                str = s.next();

                for (int j = 0; j < str.length(); j++)
                    if (str.charAt(j) == 'P')
                        ++pr;
                    else if (str.charAt(j) == 'M')
                        ++val;

                if ((100 * pr)/(str.length() - val) < 75)
                    list.add(std[i]);
            }

            for(int i=0; i<list.size(); i++)
                System.out.print(list.get(i)+((i<list.size()-1) ? " " : ""));

            System.out.println();
        }
    }
}
