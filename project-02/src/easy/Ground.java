package easy;

import javax.swing.*;
import java.awt.*;

public class Ground extends Actor {

    public Ground(int x, int y) {
        super(x, y);
        initGround();
    }

    private void initGround() {
        //  ImageIcon icon = new ImageIcon("resources/Ground.png");
        //   Image image = icon.getImage();

        Toolkit t = Toolkit.getDefaultToolkit();
        Image image = t.getImage("/home/iman/Documents/AUCA/SP/Java/auca-oop-2021/project-02/src/easy/resources/Ground.png");
        setImage(image);
    }
}
