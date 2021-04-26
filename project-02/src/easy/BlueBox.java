package easy;

import javax.swing.*;
import java.awt.*;

public class BlueBox extends Actor {

    public BlueBox(int x, int y) {
        super(x, y);
        initBlueBox();
    }

    private void initBlueBox() {
        ImageIcon icon = new ImageIcon("easy/resources/BoxBlue.png");
        Image image = icon.getImage();
        setImage(image);
    }

    public void move(int x, int y) {

        int dx = getX() + x;
        int dy = getY() + y;

        setX(dx);
        setY(dy);
    }
}
