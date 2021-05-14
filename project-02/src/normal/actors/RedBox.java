package normal.actors;

import java.awt.*;

public class RedBox extends Actor {

    public RedBox(int row, int col) {
        super(row, col);
    }

    public static Image getImage() {
        String imagePath = "/home/iman/Documents/AUCA/SP/Java/auca-oop-2021/project-02/src/normal/resources/BoxRed.png";
        Toolkit t = Toolkit.getDefaultToolkit();
        return  t.getImage(imagePath);
    }
}
