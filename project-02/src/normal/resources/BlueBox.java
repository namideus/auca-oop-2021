package normal.resources;

import java.awt.*;

public class BlueBox extends Actor {

    private boolean isInGoal = false;
    private final static String imagePath = "/home/iman/Documents/AUCA/SP/Java/auca-oop-2021/project-02/src/normal/resources/BoxBlue.png";

    public BlueBox(int row, int col) {
        super(row, col);
    }

    public static Image getImage() {
        Toolkit t = Toolkit.getDefaultToolkit();
        return t.getImage(imagePath);
    }

    public void setInGoal(boolean inGoal) {
        isInGoal = inGoal;
    }

    public boolean isInGoal() {
        return isInGoal;
    }
}
