package prototype03;

import java.util.ArrayList;

public class Utils {
    public static ArrayList<Figure> createFigures() {
        ArrayList<Figure> figures = new ArrayList<>();

        figures.add(new Rect(100,100,200,100));
        figures.add(new Rect(600,100, 50, 50));
        figures.add(new Rect(300,500, 100, 100));
        figures.add(new Circle(100,500,10));
        figures.add(new Circle(600,500,10));
        figures.add(new Circle(10,10,10));

        return figures;
    }
}
