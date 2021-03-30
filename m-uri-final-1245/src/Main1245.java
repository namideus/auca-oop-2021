import java.util.*;

public class Main1245 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n, m, cnt;
        char l;
        Map<Integer, Character> boots;

        while(scan.hasNextInt()) {
            n = scan.nextInt();
            scan.nextLine();
            cnt = 0;

            boots = new TreeMap<>();

            for(int i=0; i<n; i++)
                boots.put(scan.nextInt(), scan.next().charAt(0));

            ArrayList<Integer> no = new ArrayList<>(boots.keySet());
            ArrayList<Character> size = new ArrayList<>(boots.values());

            for(int i=0; i<boots.size()-1; i++)
                for(int j=i+1; j<boots.size(); j++)
                    if(no.get(i).equals(no.get(j)) && size.get(i)!=size.get(j)) {
                        boots.remove(no.get(i));
                        boots.remove(no.get(j));
                        cnt++;
                        break;
                    }

            System.out.println(cnt);
        }
    }
}
