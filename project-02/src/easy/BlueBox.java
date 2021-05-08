package easy;

import javax.swing.*;
import java.awt.*;

public class BlueBox extends Actor {

    private boolean isInGoal = false;

    public BlueBox(int row, int col) {
        super(row, col);
        initBlueBox();
    }
    public BlueBox() {
        initBlueBox();
    }
    private void initBlueBox() {
        String imagePath = "/home/iman/Documents/AUCA/SP/Java/auca-oop-2021/project-02/src/easy/resources/BoxBlue.png";
        Toolkit t = Toolkit.getDefaultToolkit();
        Image image = t.getImage(imagePath);
        setImage(image);
    }

    public void setInGoal(boolean inGoal) {
        isInGoal = inGoal;
    }

    public boolean isInGoal() {
        return isInGoal;
    }
}
