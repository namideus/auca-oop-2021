package easy;

import javax.swing.*;
import java.awt.*;

public class Ground extends Actor {

    public Ground(int x, int y) {
        super(x, y);
        initGround();
    }

    private void initGround() {
        ImageIcon icon = new ImageIcon("easy/resources/Ground.png");
        Image image = icon.getImage();
        setImage(image);
    }
}
