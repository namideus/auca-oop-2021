import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Problem06 {
    static final int N = 100000;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        long beg = System.currentTimeMillis();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<N; ++i) {
            list.add(i);;
        }
        long end = System.currentTimeMillis();
        System.out.println("milliseconds: "+(end - beg));


        long beg2 = System.currentTimeMillis();
        ArrayListInt list2 = new ArrayListInt();
        for(int i=0; i<N; ++i) {
            list2.add(i);;
        }
        long end2 = System.currentTimeMillis();
        System.out.println("milliseconds: "+(end2 - beg2));
    }
}
