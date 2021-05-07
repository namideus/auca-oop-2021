package easy;

import javax.swing.*;
import java.awt.*;

public class Robot extends Actor {

    public Robot(int row, int col) {
        super(row, col);
        initRobot();
    }

    public Robot() {
        initRobot();
    }

    private void initRobot() {
        String imagePath = "/home/iman/Documents/AUCA/SP/Java/auca-oop-2021/project-02/src/easy/resources/Robot.png";
        Toolkit t = Toolkit.getDefaultToolkit();
        Image image = t.getImage(imagePath);
        setImage(image);
    }
}
