import java.util.Scanner;

public class Main2356 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNext())
            System.out.println(scanner.next().contains(scanner.next()) ? "Resistente" : "Nao resistente");
    }
}
