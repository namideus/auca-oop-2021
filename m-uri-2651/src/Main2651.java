import java.util.Scanner;

public class Main2651 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i;
        String str = scanner.next();
        StringBuilder sb = new StringBuilder(str);

        for(i=0; i<str.length(); i++)
            if(Character.isUpperCase(sb.charAt(i)))
                sb.setCharAt(i, Character.toLowerCase(sb.charAt(i)));

        str = sb.toString();

        if(str.contains("zelda"))
            System.out.println("Link Bolado");
        else
            System.out.println("Link Tranquilo");
    }
}
