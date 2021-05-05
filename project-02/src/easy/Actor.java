package easy;

import java.awt.*;

public class Actor {
    private final int SPACE = 20;
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

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getImagePath() {
        return imagePath;
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

    public boolean isLeftCollision(Actor actor) {
        return getRow() - SPACE == actor.getRow() && getCol() == actor.getCol();
    }

    public boolean isRightCollision(Actor actor) {
        return getRow() + SPACE == actor.getRow() && getCol() == actor.getCol();
    }

    public boolean isTopCollision(Actor actor) {
        return getCol() - SPACE == actor.getCol() && getRow() == actor.getRow();
    }

    public boolean isBottomCollision(Actor actor) {
        return getCol() + SPACE == actor.getCol() && getRow() == actor.getRow();
    }
}
