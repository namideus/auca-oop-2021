import java.util.Scanner;

public class Main2694 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s;
        char c;
        int sum, num, n = scanner.nextInt();
        scanner.nextLine();

        while(n>0) {
            sum = num = 0;
            s = scanner.next();
            for(int i=0;i<14;i++) {
                c = s.charAt(i);
                if(c>='1' && c<='9') {
                    num+=(c-'0');
                    num*=10;
                } else {
                    sum+=num/10;
                    num=0;
                }
            }
            System.out.println(sum);
            --n;
        }
    }
}
