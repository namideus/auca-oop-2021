import java.util.Scanner;

public class Main1217 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double v, av, sum;
        String s;
        int kg, n = scan.nextInt();
        scan.nextLine();

        av = 0;
        sum = 0;

        for(int i=1; i<=n; i++) {
            kg = 0;
            v = scan.nextDouble();
            scan.nextLine();

            av += v;

            s = scan.nextLine();

            s+= " ";

            for(int j=0; j<s.length(); j++)
                if(s.charAt(j)==' ')
                    kg++;

            sum += kg;

            System.out.printf("day %d: %d kg\n", i, kg);
        }

        System.out.printf("%.2f kg by day\n", sum/n);
        System.out.printf("R$ %.2f by day\n", av/n);
    }
}
