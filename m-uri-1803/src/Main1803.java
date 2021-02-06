import java.util.Scanner;

public class Main1803 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.next(),
                b = scanner.next(),
                c = scanner.next(),
                d = scanner.next();

        int f,l,m,i = a.length()-1;

        f = (a.charAt(0)-'0')*1000+(b.charAt(0)-'0')*100+(c.charAt(0)-'0')*10+(d.charAt(0)-'0');

        l = (a.charAt(i)-'0')*1000+(b.charAt(i)-'0')*100+(c.charAt(i)-'0')*10+(d.charAt(i)-'0');

        for(int j=1; j<i; ++j)
        {
            m = (a.charAt(j)-'0')*1000+(b.charAt(j)-'0')*100+(c.charAt(j)-'0')*10+(d.charAt(j)-'0');
            System.out.print((char)((f*m+l)%257));
        }
        System.out.println();
    }
}

