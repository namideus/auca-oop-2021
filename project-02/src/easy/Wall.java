package easy;

import java.awt.*;

public class Wall extends Actor {

    public Wall(int x, int y) {
        super(x, y);
        initWall();
    }

    private void initWall() {
        // ImageIcon icon = new ImageIcon("resources/Wall.png");
        // Image image = icon.getImage();

        Toolkit t = Toolkit.getDefaultToolkit();
        Image image = t.getImage("/home/iman/Documents/AUCA/SP/Java/auca-oop-2021/project-02/src/easy/resources/Wall.png");
        setImage(image);
    }
}
