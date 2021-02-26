import java.util.Scanner;

public class Main1305 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double num,cutoff;
        int a;

        while(scan.hasNextDouble()) {
            num = scan.nextDouble();
            cutoff = scan.nextDouble();
            a = (int)num;
            num-=a;
            System.out.println((num>cutoff)?++a:a);
        }
    }
}
