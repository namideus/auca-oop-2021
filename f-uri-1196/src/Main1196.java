import java.util.Scanner;

public class Main1196 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int i;
        char c;
        String s, alph = "`1234567890-=QWERTYUIOP[]\\ASDFGHJKL;'ZXCVBNM,./";

        while(scan.hasNextLine()) {
            s = scan.nextLine();

            for(i=0; i<s.length(); i++) {
                c = s.charAt(i);

                if(c!=' ')
                    System.out.print(alph.charAt(alph.indexOf(c)-1));

                if(c==' ' || c=='`')
                    System.out.print(c);
            }
            System.out.println();
        }
    }
}
