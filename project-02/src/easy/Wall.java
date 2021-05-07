package easy;

import java.awt.*;

public class Wall extends Actor {

    public Wall(int row, int col) {
        super(row, col);
        initWall();
    }
    public Wall() {
        initWall();
    }
    private void initWall() {
        String imagePath = "/home/iman/Documents/AUCA/SP/Java/auca-oop-2021/project-02/src/easy/resources/Wall.png";
        Toolkit t = Toolkit.getDefaultToolkit();
        Image image = t.getImage(imagePath);
        setImage(image);
    }
}
