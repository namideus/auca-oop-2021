import java.util.Scanner;

public class Main1276 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str;
        StringBuilder sb;
        char first,last,temp;
        boolean f;
        while(scan.hasNextLine()) {
            str = scan.nextLine();
            sb = new StringBuilder();
            int[] cnt = new int[128];
            if(str.isEmpty())
                System.out.println();
            else {
                for(int i=0;i<str.length();++i)
                    cnt[str.charAt(i)]+=(str.charAt(i)!=' ')?1:0;
                for(int i=92; i<123; ++i)
                    if(cnt[i]>0)
                        sb.append((char)i);
                first=last=temp=sb.charAt(0);
                f=false;
                for(int i=1;i<sb.length();++i) {
                    ++temp;
                    if(sb.charAt(i)==temp)
                        last = sb.charAt(i);
                    else {
                        System.out.print((f?" ":"")+first+":"+last+",");
                        first=last=temp=sb.charAt(i);
                        f=true;
                    }
                }
                System.out.println((f?" ":"")+first+":"+last);
            }
        }
    }
}
