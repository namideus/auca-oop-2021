import java.util.Scanner;

public class Main1238 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m1,m2,i, t = scanner.nextInt();
        String a,b;

        while(t>0)
        {
            a = scanner.next();
            b = scanner.next();

            m1 = m2 = 0;

            for(i=0; i<50; ++i)
            {
                if(a.charAt(i)=='\0')
                    m1 = 1;

                if(b.charAt(i)=='\0')
                    m2 = 1;

                if(m1==1 && m2==1) break;

                if(m1==0)
                    System.out.print(a.charAt(i));

                if(m2==0)
                    System.out.print(a.charAt(i));
            }

            System.out.println();
            --t;
        }
    }
}



