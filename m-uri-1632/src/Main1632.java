import java.util.Scanner;

public class Main1632 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int i,cnt,t = scan.nextInt();
        scan.nextLine();
        String s;
        char ch;
        while(t>0) {
            cnt=1;
            s = scan.next();
            for(i=0;i<s.length();++i) {
                ch = s.charAt(i);
                if(ch=='a'||ch=='A'|| ch=='e'|| ch=='E'|| ch=='i'|| ch=='I'
                        || ch=='o'|| ch=='O'|| ch=='s'||ch=='S')
                    cnt*=3;
                else
                    cnt*=2;
            }
            System.out.println(cnt);
            --t;
        }
    }
}
