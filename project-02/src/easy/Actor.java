package easy;

import java.awt.*;

public class Actor {
    private int row;
    private int col;
    private Image image;
    private String imagePath;

    public Actor() { }

    public Actor(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }
}
