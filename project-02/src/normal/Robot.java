package normal;

import java.awt.*;

public class Robot extends Actor {

    private boolean left = false;
    private boolean right = false;
    private boolean down = false;
    private boolean up = false;

    public Robot(int row, int col) {
        super(row, col);
    }


    public static Image getImage() {
        String imagePath = "/home/iman/Documents/AUCA/SP/Java/auca-oop-2021/project-02/src/normal/resources/RobotL.png";
        Toolkit t = Toolkit.getDefaultToolkit();
        return  t.getImage(imagePath);
    }
}
