package normal;

import java.awt.*;

public class Robot extends Actor {

    private boolean left = false;
    private boolean right = false;
    private boolean down = false;
    private boolean up = false;

    private static String imagePath = "/home/iman/Documents/AUCA/SP/Java/auca-oop-2021/project-02/src/normal/resources/RobotU.png";

    public Robot(int row, int col) {
        super(row, col);
    }

    public static Image getImage() {
        Toolkit t = Toolkit.getDefaultToolkit();
        return  t.getImage(imagePath);
    }

    public void setLeft() {
        this.left = true;
        this.right = false;
        this.down = false;
        this.up = false;
        imagePath = "/home/iman/Documents/AUCA/SP/Java/auca-oop-2021/project-02/src/normal/resources/RobotL.png";
    }

    public void setRight() {
        this.left = false;
        this.right = true;
        this.down = false;
        this.up = false;
        imagePath = "/home/iman/Documents/AUCA/SP/Java/auca-oop-2021/project-02/src/normal/resources/RobotR.png";
    }

    public void setDown() {
        this.left = false;
        this.right = false;
        this.down = true;
        this.up = false;
        imagePath = "/home/iman/Documents/AUCA/SP/Java/auca-oop-2021/project-02/src/normal/resources/RobotD.png";
    }

    public void setUp() {
        this.left = false;
        this.right = false;
        this.down = false;
        this.up = true;
        imagePath = "/home/iman/Documents/AUCA/SP/Java/auca-oop-2021/project-02/src/normal/resources/RobotU.png";
    }
}
