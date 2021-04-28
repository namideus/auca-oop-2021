package prototype03;

import java.util.ArrayList;
import java.util.Scanner;

public class MainPrototype03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayList<Figure> figures = Utils.createFigures();

        while(true) {
            System.out.print("x: ");
            int xClick = scan.nextInt();
            System.out.print("y: ");
            int yClick = scan.nextInt();

            if(xClick + yClick == -2) break;

            for(Figure f : figures)
                if(f.contains(xClick, yClick)) {
                    System.out.println(f);
                }
        }
    }
}
