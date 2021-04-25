package prototype04;


import java.util.ArrayList;
import java.util.Scanner;

public class MainPrototype04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String cmd;
        int xClick, yClick, xFrom, yFrom, xTo, yTo;

        ArrayList<Rect> rects = new ArrayList<>();
        rects.add(new Rect(100,100,200,100));
        rects.add(new Rect(600,100, 50, 50));
        rects.add(new Rect(300,500, 100, 100));

        ArrayList<Circle> circles = new ArrayList<>();
        circles.add(new Circle(100,500,10));
        circles.add(new Circle(600,500,10));
        circles.add(new Circle(10,10,10));

        while(true)
        {
            System.out.print("cmd: ");
            cmd = scan.nextLine();

            switch (cmd) {
                case "click":
                    System.out.print("x: ");
                    xClick = scan.nextInt();
                    System.out.print("y: ");
                    yClick = scan.nextInt();

                    if (xClick + yClick == -2)
                        System.exit(0);

                    for (Rect r : rects) {
                        if (r.contains(xClick, yClick)) {
                            System.out.println(r);
                        }
                    }

                    for (Circle c : circles) {
                        if (c.contains(xClick, yClick)) {
                            System.out.println(c);
                        }
                    }
                    break;
                case "showAll":
                    for (Rect r : rects)
                        System.out.println(r);

                    for (Circle c : circles)
                        System.out.println(c);

                    break;
                case "move":
                    System.out.print("x1: ");
                    xFrom = scan.nextInt();
                    System.out.print("y1: ");
                    yFrom = scan.nextInt();

                    System.out.print("x2: ");
                    xTo = scan.nextInt();
                    System.out.print("y2: ");
                    yTo = scan.nextInt();

                    for (Rect r : rects) {
                        if (r.contains(xFrom, yFrom)) {
                            r.setX(xTo);
                            r.setY(yTo);
                        }
                    }

                    for (Circle c : circles) {
                        if (c.contains(xFrom, yFrom)) {
                            c.setX(xTo);
                            c.setY(yTo);
                        }
                    }
                    break;
                case "stop":
                    System.exit(0);
                    break;
            }

        }
    }
}
