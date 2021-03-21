import java.util.Scanner;

public class Main2484 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i,j,l;
        String str;

        while(scanner.hasNext()) {
            str = scanner.next();
            l = str.length();

            for(int count = 0; count<l; ++count) {
                for(j=0; j<count; ++j)
                    System.out.print(" ");

                for(i=0; i<l-count; ++i)
                    System.out.print(str.charAt(i)+( i!=l-count-1 ? " ": ""));

                System.out.println();
            }

            System.out.println();
        }
    }
}
