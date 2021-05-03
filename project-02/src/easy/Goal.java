package easy;

import javax.swing.*;
import java.awt.*;

public class Goal extends Actor {

    public Goal(int x, int y) {
        super(x, y);
        initGoal();
    }

    private void initGoal() {
        String imagePath = "/home/iman/Documents/AUCA/SP/Java/auca-oop-2021/project-02/src/easy/resources/Goal.png";
        Toolkit t = Toolkit.getDefaultToolkit();
        Image image = t.getImage(imagePath);
        setImagePath(imagePath);
        setImage(image);
    }
}
