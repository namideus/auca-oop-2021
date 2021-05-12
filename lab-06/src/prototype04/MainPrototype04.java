package prototype04;

import java.util.ArrayList;
import java.util.Scanner;

public class MainPrototype04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String cmd;
        int xClick, yClick, xFrom, yFrom, xTo, yTo;

        ArrayList<Figure> figures = Utils.createFigures();

        while(true) {
            System.out.print("cmd: ");
            cmd = scan.nextLine();

            switch (cmd) {
                case "click":
                    System.out.print("x: ");
                    xClick = scan.nextInt();
                    System.out.print("y: ");
                    yClick = scan.nextInt();

                    for(Figure f : figures)
                        if(f.contains(xClick, yClick)) {
                            System.out.println(f);
                        }
                    break;
                case "showAll":
                    System.out.println(figures);
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

                    for(Figure f : figures) {
                        if (f.contains(xFrom, yFrom)) {
                            f.move(xTo - xFrom, yTo - yFrom);
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
