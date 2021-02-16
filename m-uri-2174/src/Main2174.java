import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main2174 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String s;
        Set<String> pomekons = new HashSet<>();
        while(n>0) {
            s = scanner.next();
            pomekons.add(s);
            --n;
        }
        System.out.println("Falta(m) "+(151-pomekons.size())+" pomekon(s).");
    }
}
