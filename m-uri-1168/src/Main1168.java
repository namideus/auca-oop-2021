import java.util.Scanner;

public class Main1168 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        String str;
        char ch;
        int leds;
        for (int i = 1; i <= t; i++) {
            str = s.next();
            leds = 0;
            for (int j = 0; j < str.length(); j++) {
                ch = str.charAt(j);
                if (ch == '0' || ch == '6' || ch == '9')
                    leds += 6;
                if (ch == '1')
                    leds += 2;
                if (ch == '2' || ch == '3' || ch == '5')
                    leds += 5;
                if (ch == '4')
                    leds += 4;
                if (ch == '7')
                    leds += 3;
                if (ch == '8')
                    leds += 7;
            }
            System.out.println(leds + " leds");
        }
    }
}
