import java.util.Scanner;

public class Main1743 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[][] plug = new int[2][5];

        for(int i=0; i<2; ++i)
            for(int j=0; j<5; ++j)
                plug[i][j] = scan.nextInt();

        for(int j=0; j<5; ++j) {
            plug[0][j] ^= 1;
            if (plug[0][j] != plug[1][j]) {
                System.out.println("N");
                System.exit(0);
            }
        }
        System.out.println("Y");
    }
}
