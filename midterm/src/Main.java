import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String e,str = "Hello world ddd aaaa gfkmgfbp aaaa kjhpkhp";
        Scanner strScan  = new Scanner(str);
        int cnt = 0;

        while(strScan.hasNext()) {
            strScan.next();
            ++cnt;
        }
        System.out.println(cnt);
    }
}
