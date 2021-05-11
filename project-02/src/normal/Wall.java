package normal;

import java.awt.*;

public class Wall extends Actor {

    public Wall(int row, int col) {
        super(row, col);
    }

    public static Image getImage() {
        String imagePath = "/home/iman/Documents/AUCA/SP/Java/auca-oop-2021/project-02/src/normal/resources/Wall.png";
        Toolkit t = Toolkit.getDefaultToolkit();
        return  t.getImage(imagePath);
    }
}
