package easy;

import java.awt.*;

public class Actor {
    private final int SPACE = 20;
    private int x;
    private int y;
    private Image image;

    public Actor(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isLeftCollision(Actor actor) {
        return getX() - SPACE == actor.getX() && getY() == actor.getY();
    }

    public boolean isRightCollision(Actor actor) {
        return getX() + SPACE == actor.getX() && getY() == actor.getY();
    }

    public boolean isTopCollision(Actor actor) {
        return getY() - SPACE == actor.getY() && getX() == actor.getX();
    }

    public boolean isBottomCollision(Actor actor) {
        return getY() + SPACE == actor.getY() && getX() == actor.getX();
    }
}
