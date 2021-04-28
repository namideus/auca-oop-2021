package prototype05;

import java.awt.*;

public abstract class Figure {

    protected int x, y;

    public Figure(int x, int y) {
        this.x = x;
        this.y = y;
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

    public abstract void draw(Graphics g);
}