package prototype05;

public class Circle extends Figure {
    private int x;
    private int y;
    private int r;

    public Circle(int x, int y, int r) {
        if(r<0)
            throw new IllegalArgumentException("Circle: radius < 0");

        this.x = x;
        this.y = y;
        this.r = r;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean contains(int xClick, int yClick) {
        int dx = x-xClick, dy = y-yClick;
        return dx*dx + dy*dy <= r*r;
    }

    @Override
    public String toString() {
        return String.format("Circle(%d, %d, %d)",x,y,r);
    }
}
