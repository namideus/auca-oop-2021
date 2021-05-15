package normal.actors;

import java.awt.*;
import java.io.IOException;

public class BlueBox extends Actor {

    private boolean isInGoal = false;
    private int id = 0;

    public BlueBox(int row, int col, int id) {
        super(row, col);
        this.id = id;
    }

    public static Image getImage() throws IOException {
        final String imagePath = "/home/iman/Documents/AUCA/SP/Java/auca-oop-2021/project-02/src/normal/resources/BoxBlue.png";
        Toolkit t = Toolkit.getDefaultToolkit();
        return t.getImage(imagePath);
    }

    public void setInGoal(boolean inGoal) {
        isInGoal = inGoal;
    }

    public boolean isInGoal() {
        return isInGoal;
    }

    public int getId() {
        return id;
    }
}
