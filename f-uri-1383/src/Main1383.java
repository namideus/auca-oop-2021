import java.util.Scanner;

public class Main1383 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean f;
        int i, t, k, j, n;
        int[][] matrix, sm;
        int[] sl,sc;
        matrix = new int[9][9];

        n = scan.nextInt();
        scan.nextLine();
        for(t=1; t<=n; t++) {
            sl = new int[9];
            sc = new int[9];
            sm = new int[3][3];

            f = true;

            for(i=0;i<9;i++)
                for(j=0;j<9;j++)
                    matrix[i][j] = scan.nextInt();

            for(i=0;i<9;i++) {
                for(j=0;j<9;j++) {
                    k = matrix[i][j];
                    k*=k;
                    sl[i] += k;
                    sc[j] += k;
                    sm[i/3][j/3] += k;

                    if(i==8 && sc[j]!=285) {
                        f = false;
                        break;
                    }
                }
                if(sl[i] != 285) {
                    f = false;
                    break;
                }
            }

            if(f)
                for(i=0;i<3;i++) {
                    for(j=0;j<3;j++) {
                        if(sm[i][j]!=285)
                            f = false;
                    }
                }

            System.out.printf("Instancia %d\n"+((f) ? "SIM" : "NAO")+"\n\n", t);
        }
    }
}
