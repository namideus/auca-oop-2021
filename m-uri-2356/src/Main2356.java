import java.util.Scanner;

public class Main2356 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String d,s;

        while(scanner.hasNext()) {

            d = scanner.next();
            s = scanner.next();

            System.out.println((d.contains(s))?"Resistente" : "Nao resistente");
        }
    }
}
