import java.util.Scanner;

public class Main1516 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] image = new char[51][51];
        int n,m,a,b,r,c,i,j,k,t;

        while(scanner.hasNextInt()) {
            n = scanner.nextInt();
            m = scanner.nextInt();

            if(n==0 && m==0) break;

            String line;
            for(i=0;i<n;i++) {
                line = scanner.next();
                for (j = 0; j<m; j++) {
                    image[i][j] = line.charAt(j);
                }
            }

            a = scanner.nextInt();
            b = scanner.nextInt();

            r = a/n;
            c = b/m;

            for(i=0; i<n; i++) {
                for(k=0; k<r; k++) {
                    for(j=0;j<m;j++) {
                        for(t=0;t<c;t++) {
                            System.out.print(image[i][j]);
                        }
                    }
                    System.out.println();
                }
            }
            System.out.println();
        }
    }
}
