import java.util.Scanner;

public class Main1514 {
    private static int m, n, i, j;

    static int cond_one(int[][] a) {
        int c;

        for(i=0;i<n;++i) {
            c = 0;

            for(j=0;j<m;++j)
                c += a[i][j];

            if(c==m)
                return 0;
        }
        return 1;
    }

    static int cond_two(int[][] a) {
        int c=0, b1;

        for(i=0; i<m; ++i) {
            b1 = 0;
            for(j=0; j<n; ++j)
                if(a[j][i]==1)
                    b1 = 1;

            if(b1==1)
                ++c;
        }

        return (c==m)? 1 : 0;
    }

    static int cond_three(int[][] a) {
        int c;

        for(i=0; i<m; ++i) {
            c = 0;
            for(j=0; j<n; ++j)
                c += a[j][i];
            if(c==n)
                return 0;
        }

        return 1;
    }

    static int cond_four(int[][] a) {
        int c = 0;

        for(i=0; i<n; ++i) {
            for(j=0; j<m; ++j)
                if(a[i][j]==1) {
                    c++;
                    break;
                }
        }

        return (c==n)? 1 : 0;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][] a = new int[101][101];
        while(scan.hasNextInt()) {
            n = scan.nextInt();
            m = scan.nextInt();

            if(n+m==0)
                break;

            for(i=0;i<n;++i) {
                for (j = 0; j < m; ++j)
                    a[i][j] = scan.nextInt();
            }

            System.out.println(cond_one(a) + cond_two(a) + cond_three(a) + cond_four(a));
        }
    }
}
