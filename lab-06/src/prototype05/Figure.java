package prototype05;

import java.awt.*;

public abstract class Figure {

    protected int x, y;
    private boolean isSelected;

    public Figure(int x, int y) {
        this.x = x;
        this.y = y;
        this.isSelected = false;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    public abstract boolean contains(int xClick, int yClick);

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public abstract void draw(Graphics g);
}