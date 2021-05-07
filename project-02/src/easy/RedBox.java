package easy;

import java.awt.*;

public class RedBox extends Actor {

    public RedBox(int row, int col) {
        super(row, col);
        initBlueBox();
    }

    public RedBox() {
        initBlueBox();
    }

    private void initBlueBox() {
        String imagePath = "/home/iman/Documents/AUCA/SP/Java/auca-oop-2021/project-02/src/easy/resources/BoxRed.png";
        Toolkit t = Toolkit.getDefaultToolkit();
        Image image = t.getImage(imagePath);
        setImage(image);
    }
}
