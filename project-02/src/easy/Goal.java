package easy;

import javax.swing.*;
import java.awt.*;

public class Goal extends Actor {

    public Goal(int x, int y) {
        super(x, y);
        initGoal();
    }

    private void initGoal() {
        ImageIcon icon = new ImageIcon("easy/resources/Goal.png");
        Image image = icon.getImage();
        setImage(image);
    }
}
