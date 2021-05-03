package easy;

import javax.swing.*;
import java.awt.*;

public class Robot extends Actor {

    public Robot(int x, int y) {
        super(x, y);
        initRobot();
    }

    private void initRobot() {
        // ImageIcon icon = new ImageIcon("resources/Robot.png");
        // Image image = icon.getImage();

        Toolkit t = Toolkit.getDefaultToolkit();
        Image image = t.getImage("/home/iman/Documents/AUCA/SP/Java/auca-oop-2021/project-02/src/easy/resources/Robot.png");
        setImage(image);
    }

    public void move(int x, int y) {

        int dx = getX() + x;
        int dy = getY() + y;

        setX(dx);
        setY(dy);
    }
}
