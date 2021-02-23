import java.util.Scanner;

public class Main1262 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int procs, reads, p;
        String trace;

        while(scanner.hasNext()) {
            procs=reads=0;

            trace = scanner.next();
            p = scanner.nextInt();

            for(int i=0;i<trace.length();++i) {
                if(trace.charAt(i)=='R') {
                    ++reads;
                    if(reads==p) {
                        reads=0;
                        ++procs;
                    }
                } else {
                    ++procs;
                    if(reads>0) {
                        reads=0;
                        ++procs;
                    }
                }
            }
            if(reads>0)
                ++procs;
            System.out.println(procs);
        }
    }
}
