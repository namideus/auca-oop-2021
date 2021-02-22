import java.util.Scanner;

public class Main2108 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str, max = "";
        StringBuilder sb;
        int cnt, i, MAX = 0;

        while(scanner.hasNextLine()) {
            str = scanner.nextLine();

            if(str.equals("0")) {
                System.out.println();
                System.out.println("The biggest word: "+max);
                break;
            }

            cnt=0;
            sb = new StringBuilder();
            str+=' ';

            for(i=0; i<str.length(); i++) {
                if(str.charAt(i)!=' ') {
                    ++cnt;
                    sb.append(str.charAt(i));
                } else {
                    if(MAX<=cnt) {
                        MAX = cnt;
                        max = sb.toString();
                    }
                    System.out.print(cnt+((i==str.length()-1) ? "\n" : "-"));
                    cnt = 0;
                    sb = new StringBuilder();
                }
            }
        }
    }
}
