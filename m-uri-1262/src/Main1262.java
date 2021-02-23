import java.util.Scanner;

public class Main1262 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pr, r, p;
        String trace;

        while(scanner.hasNext()) {
            pr=r=0;

            trace = scanner.next();
            p = scanner.nextInt();

            for(int i=0;i<trace.length();++i) {
                if(trace.charAt(i)=='R') {
                    ++r;
                    if(r==p) {
                        r=0;
                        ++pr;
                    }
                } else {
                    ++pr;
                    if(r>0) {
                        r=0;
                        ++pr;
                    }
                }
            }
            if(r>0)
                ++pr;
            System.out.println(pr);
        }
    }
}
