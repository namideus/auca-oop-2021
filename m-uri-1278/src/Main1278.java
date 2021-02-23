import java.util.ArrayList;
import java.util.Scanner;

public class Main1278 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s;
        ArrayList<String> list;
        StringBuilder sb;
        char ch;
        int n,i,j,l,t,max;
        boolean f=false,f2;

        while(scanner.hasNextInt()) {
            n = scanner.nextInt();
            scanner.nextLine();

            list = new ArrayList<>();

            if(n==0) break;

            if(f)
                System.out.println();

            max = 0;

            for(i=0;i<n;++i) {
                sb = new StringBuilder();
                f2 = false;
                s = scanner.nextLine().trim();

                for(j=0;j<s.length();++j) {
                    if(Character.isAlphabetic(s.charAt(j))) {
                        sb.append(s.charAt(j));
                        f2 = true;
                    } else {
                        if(f2) {
                            sb.append(" ");
                            f2=false;
                        }
                    }
                }
                list.add(sb.toString());
                max = Math.max(sb.length(), max);
            }
            for(String str : list) {
                for(i=0;i<max-str.length();++i)
                    System.out.print(" ");
                System.out.println(str);
            }
            f=true;
        }
    }
}
