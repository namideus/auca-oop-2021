package easy;

import javax.swing.*;
import java.awt.*;

public class Robot extends Actor {

    public Robot(int row, int col) {
        super(row, col);
    }

    public static Image getImage() {
        String imagePath = "/home/iman/Documents/AUCA/SP/Java/auca-oop-2021/project-02/src/easy/resources/Robot.png";
        Toolkit t = Toolkit.getDefaultToolkit();
        return  t.getImage(imagePath);
    }
}
