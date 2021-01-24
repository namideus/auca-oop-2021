import java.util.Scanner;

public class Main1241 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int l1,l2,id,t = scanner.nextInt();
        String a,b;
        boolean ok;
        while(t>0)
        {
            ok = true;

            a = scanner.next();
            b = scanner.next();

            l1 = a.length();
            l2 = b.length();

            if(l1<l2)
                System.out.println("nao encaixa");
            else {
                id = l1 - l2;
                for(int i=0; i<l2; ++i)
                {
                    if(a.charAt(id)!=b.charAt(i)) {
                        ok = false;
                        break;
                    }
                    ++id;
                }
                if(ok)
                    System.out.println("encaixa");
                else
                    System.out.println("nao encaixa");
            }
            --t;
        }
    }
}
