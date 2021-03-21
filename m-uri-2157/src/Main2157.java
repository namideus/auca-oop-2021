    import java.util.Scanner;

    public class Main2157 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int a,b,t=scanner.nextInt();
            scanner.nextLine();
            StringBuilder sb;

            while(t>0) {
                sb = new StringBuilder();
                a = scanner.nextInt();
                b = scanner.nextInt();

                for(int i=a; i<=b; ++i)
                    sb.append(i);

                System.out.println(sb.toString()+sb.reverse().toString());
                --t;
            }
        }
    }
