package prototype01;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x1 = 100,y1 = 100, w1 = 200, h1 = 100;

        ArrayList<Rect> rects = new ArrayList<>();
        rects.add(new Rect(100,100,200,100));
        rects.add(new Rect(600,100, 50, 50));
        rects.add(new Rect(300,500, 100, 100));

        while(true) {
            int xClick = scan.nextInt();
            int yClick = scan.nextInt();

            if(xClick+yClick==-2) break;

            for(Rect r : rects) {
                if(r.contains(xClick, yClick)){
                    System.out.println(r);
                }
            }
        }
    }
}

