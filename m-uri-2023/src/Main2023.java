
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main2023 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str,temp;

        Map<String, String> map = new TreeMap<>();
        while(scan.hasNextLine()) {
            str = scan.nextLine();
            map.put(str.toLowerCase(),str);
        }

        System.out.println(map.values().toArray()[map.size()-1]);
    }
}
