package easy;

import javax.swing.*;
import java.awt.*;

public class Wall extends Actor {
    private Image image;

    public Wall(int x, int y) {
        super(x, y);
        initWall();
    }

    private void initWall() {
        ImageIcon icon = new ImageIcon("easy/resources/Wall.png");
        image = icon.getImage();
        setImage(image);
    }
}
