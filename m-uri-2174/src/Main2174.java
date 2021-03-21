import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main2174 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        Set<String> pomekons = new HashSet<>();
        while(n>0) {
            pomekons.add(scanner.next());
            --n;
        }
        System.out.println("Falta(m) "+(151-pomekons.size())+" pomekon(s).");
    }
}
