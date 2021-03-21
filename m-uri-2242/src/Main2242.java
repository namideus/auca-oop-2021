import java.util.Scanner;

public class Main2242 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.next();
        StringBuilder sBuild = new StringBuilder();
        boolean ok = true;
        char ch;

        for(int i=0; i<s.length(); i++) {
            ch = s.charAt(i);
            if(ch=='a'||ch=='i'||ch=='o'||ch=='u'||ch=='e')
                sBuild.append(ch);
        }

        for(int i=0, j = sBuild.length()-1; i<j; i++, j--)
            if(sBuild.charAt(i) != sBuild.charAt(j)) {
                ok = false;
                break;
            }

        System.out.println((ok) ? "S" : "N");
    }
}
