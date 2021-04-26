import javax.swing.*;
import java.awt.*;

public class Robot extends Actor {

    public Robot(int x, int y) {
        super(x, y);
        initRobot();
    }

    private void initRobot() {
        ImageIcon icon = new ImageIcon("resources/Robot.png");
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
