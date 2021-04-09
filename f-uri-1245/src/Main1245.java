import java.util.*;

public class Main1245 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n, cnt;
        Boot[] arr;

        while(scan.hasNextInt()) {
            n = scan.nextInt();
            scan.nextLine();
            cnt = 0;

            arr = new Boot[n];

            for(int i=0; i<n; i++)
                arr[i] = new Boot(scan.nextInt(), scan.next().charAt(0));

            for(int i=0; i<n-1; i++)
                for(int j=i+1; j<n; j++) {
                    if(arr[i].no==arr[j].no && arr[i].size!=arr[j].size) {
                        arr[i] = new Boot(-1, 'A');
                        arr[j] = arr[i];
                        cnt++;
                        break;
                    }
                }

            System.out.println(cnt);
        }
    }

    static class Boot {
        int no;
        char size;

        public Boot(int no, char size) {
            this.no = no;
            this.size = size;
        }
    }
}
