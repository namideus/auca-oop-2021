package prototype02;

import prototype01.Rect;

import java.util.ArrayList;
import java.util.Scanner;

public class MainPrototype02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayList<Rect> rects = new ArrayList<>();
        rects.add(new Rect(100,100,200,100));
        rects.add(new Rect(600,100, 50, 50));
        rects.add(new Rect(300,500, 100, 100));

        ArrayList<Circle> circles = new ArrayList<>();
        circles.add(new Circle(100,500,10));
        circles.add(new Circle(600,500,10));

        while(true)
        {
            int xClick = scan.nextInt();
            int yClick = scan.nextInt();

            if(xClick + yClick == -2)
                break;

//            for(Rect r : rects) {
//                if(r.contains(xClick, yClick)) {
//                    System.out.println(r);
//                }
//            }

            for(Circle c : circles) {
                if(c.contains(xClick, yClick)){
                    System.out.println(c);
                }
            }
        }
    }
}

