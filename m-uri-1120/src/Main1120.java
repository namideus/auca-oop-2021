import java.util.Scanner;

public class Main1120 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int max, n = scanner.nextInt();
        scanner.nextLine();
        StringBuilder list;
        int[] cnt;
        String line;
        char ch;

        while(!scanner.next().equals("0") && !scanner.next().equals("0"))
        {
            max = 0;
            list = new StringBuilder();
            cnt = new int[128];
            line = scanner.nextLine();

            for(int i=0; i<line.length(); ++i)
            {
                ch = Character.toLowerCase(line.charAt(i));

                if(Character.isAlphabetic(ch))
                {
                    cnt[ch]++;
                    if(cnt[ch]>max)
                        max = cnt[ch];
                }
            }

            for(int i=0; i<128; ++i)
                if(max==cnt[i])
                    list.append((char)i);

            System.out.println(list.toString());

            --n;
        }
    }
}
