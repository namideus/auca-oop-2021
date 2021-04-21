package prototype02;

public class Circle {
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

    public boolean contains(int xClick, int yClick) {
        int dx = x-xClick, dy = y-yClick;
        return dx*dx + dy*dy <= r*r;
    }

    @Override
    public String toString() {
        return String.format("Circle(%d, %d, %d)",x,y,r);
    }
}
