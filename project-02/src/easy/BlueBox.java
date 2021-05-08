package easy;

import javax.swing.*;
import java.awt.*;

public class BlueBox extends Actor {

    private boolean isInGoal = false;
    private final String imagePath1 = "/home/iman/Documents/AUCA/SP/Java/auca-oop-2021/project-02/src/easy/resources/BoxBlue.png";
    private final String imagePath2 = "/home/iman/Documents/AUCA/SP/Java/auca-oop-2021/project-02/src/easy/resources/BoxRed.png";

    public BlueBox(int row, int col) {
        super(row, col);
        initBlueBox();
    }
    public BlueBox() {
        initBlueBox();
    }
    private void initBlueBox() {
        Toolkit t = Toolkit.getDefaultToolkit();
        Image image = (isInGoal) ? t.getImage(imagePath2) : t.getImage(imagePath1);
        setImage(image);
    }

    @Override
    public Image getImage() {
        Toolkit t = Toolkit.getDefaultToolkit();
        return (isInGoal) ? t.getImage(imagePath2) : t.getImage(imagePath1);
    }

    public void setInGoal(boolean inGoal) {
        isInGoal = inGoal;
    }

    public boolean isInGoal() {
        return isInGoal;
    }
}
