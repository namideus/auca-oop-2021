package prototype01;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayList<Rect> rects = new ArrayList<>();
        rects.add(new Rect(100,100,200,100));
        rects.add(new Rect(600,100, 50, 50));
        rects.add(new Rect(300,500, 100, 100));

        while(true) {
            System.out.print("x: ");
            int xClick = scan.nextInt();
            System.out.print("y: ");
            int yClick = scan.nextInt();

            if(xClick+yClick==-2)
                break;

            for(Rect r : rects) {
                if(r.contains(xClick, yClick)){
                    System.out.println(r);
                }
            }
        }
    }
}

