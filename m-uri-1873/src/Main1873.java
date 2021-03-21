import java.util.Scanner;

public class Main1873 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        scan.nextLine();
        String a,b;
        while(t>0) {
            a = scan.next();
            b = scan.next();

            if(a.equals(b))
                System.out.println("empate");
            else if(a.equals("tesoura")&&b.equals("papel") ||
                    a.equals("papel")  &&b.equals("pedra") ||
                    a.equals("pedra")  &&b.equals("lagarto") ||
                    a.equals("lagarto")&&b.equals("spock") ||
                    a.equals("spock")  &&b.equals("tesoura") ||
                    a.equals("tesoura")&&b.equals("lagarto") ||
                    a.equals("lagarto")&&b.equals("papel") ||
                    a.equals("papel")  &&b.equals("spock") ||
                    a.equals("spock")  &&b.equals("pedra") ||
                    a.equals("pedra")  &&b.equals("tesoura"))
                System.out.println("rajesh");
            else
                System.out.println("sheldon");

            --t;
        }
    }
}
