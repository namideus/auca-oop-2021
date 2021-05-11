package normal.resources;

import java.awt.*;

public class Ground extends Actor {

    public Ground(int row, int col) {
        super(row, col);
    }

    public static Image getImage() {
        String imagePath = "/home/iman/Documents/AUCA/SP/Java/auca-oop-2021/project-02/src/normal/resources/Ground.png";
        Toolkit t = Toolkit.getDefaultToolkit();
        return  t.getImage(imagePath);
    }
}
