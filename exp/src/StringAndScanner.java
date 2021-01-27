import java.util.Scanner;

public class StringAndScanner {
    public static void main(String[] args) {
        String s = "       Hello World 42 3.14     ";

        Scanner inpLine = new Scanner(s);

        System.out.println(inpLine.next());
        System.out.println(inpLine.next());
        System.out.println(inpLine.nextInt()+1);
        System.out.println(inpLine.nextDouble());
        System.out.println(inpLine.hasNext() ? "Something else is here" : "End" );
    }
}
