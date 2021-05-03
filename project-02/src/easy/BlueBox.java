package easy;

import javax.swing.*;
import java.awt.*;

public class BlueBox extends Actor {

    public BlueBox(int x, int y) {
        super(x, y);
        initBlueBox();
    }

    private void initBlueBox() {
//        ImageIcon icon = new ImageIcon("src/resources/BoxBlue.png");
//        Image image = icon.getImage();

        Toolkit t = Toolkit.getDefaultToolkit();
        Image image = t.getImage("/home/iman/Documents/AUCA/SP/Java/auca-oop-2021/project-02/src/easy/resources/BoxBlue.png");
        setImage(image);
    }

    public void move(int x, int y) {

        int dx = getX() + x;
        int dy = getY() + y;

        setX(dx);
        setY(dy);
    }
}
