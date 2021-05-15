package normal.actors;

import java.awt.*;
import java.io.IOException;

public class Robot extends Actor {

    private static String imagePath = "/home/iman/Documents/AUCA/SP/Java/auca-oop-2021/project-02/src/normal/resources/RobotU.png";

    public Robot(int row, int col) {
        super(row, col);
    }

    public static Image getImage() throws IOException {
        Toolkit t = Toolkit.getDefaultToolkit();
        return  t.getImage(imagePath);
    }

    public void setLeft() {
        imagePath = "/home/iman/Documents/AUCA/SP/Java/auca-oop-2021/project-02/src/normal/resources/RobotL.png";
    }

    public void setRight() {
        imagePath = "/home/iman/Documents/AUCA/SP/Java/auca-oop-2021/project-02/src/normal/resources/RobotR.png";
    }

    public void setDown() {
        imagePath = "/home/iman/Documents/AUCA/SP/Java/auca-oop-2021/project-02/src/normal/resources/RobotD.png";
    }

    public void setUp() {
        imagePath = "/home/iman/Documents/AUCA/SP/Java/auca-oop-2021/project-02/src/normal/resources/RobotU.png";
    }
}
