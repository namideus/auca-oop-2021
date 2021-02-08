import java.util.Scanner;

public class Main1551 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i, c,t = scanner.nextInt();
        int[] cnt;
        scanner.nextLine();
        String text;
        while(t>0)
        {
            c=0;
            cnt = new int[128];

            text = scanner.nextLine();

            for(i=0; i<text.length(); i++)
                if(Character.isAlphabetic(text.charAt(i)))
                    cnt[(int)text.charAt(i)]++;

            for(i=0; i<128; i++)
                if(cnt[i]>0)
                    ++c;

            if(c==26)
                System.out.println("frase completa");
            else if(c>=13)
                System.out.println("frase quase completa");
            else
                System.out.println("frase mal elaborada");

            --t;
        }
    }
}
