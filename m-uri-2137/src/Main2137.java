import java.util.Arrays;
import java.util.Scanner;

public class Main2137 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n,i,j;
        int[] arr;

        while(scanner.hasNextInt()) {
            n = scanner.nextInt();
            scanner.nextLine();

            arr = new int[n];

            for(i=0; i<n; ++i)
               arr[i] = scanner.nextInt();

            Arrays.sort(arr);

            for(i=0;i<n;++i) {
                for(j=0;j<4-(arr[i]+"").length(); ++j)
                    System.out.print("0");

                System.out.println(arr[i]);
            }
        }
    }
}
