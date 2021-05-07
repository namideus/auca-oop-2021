package easy;

import java.awt.*;

public class Ground extends Actor {

    public Ground(int row, int col) {
        super(row, col);
        initGround();
    }

    public Ground() {
        initGround();
    }

    private void initGround() {
        String imagePath = "/home/iman/Documents/AUCA/SP/Java/auca-oop-2021/project-02/src/easy/resources/Ground.png";
        Toolkit t = Toolkit.getDefaultToolkit();
        Image image = t.getImage(imagePath);
        setImage(image);
        setImagePath(imagePath);
    }
}
