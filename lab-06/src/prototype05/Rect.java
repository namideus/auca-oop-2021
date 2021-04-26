package prototype05;

public class Rect extends Figure {
    private int x;
    private int y;
    private int w;
    private int h;

    public Rect(int x, int y, int w, int h) {
        if(w<0)
            throw new IllegalArgumentException("Rectangle: width < 0");
        if(h<0)
            throw new IllegalArgumentException("Rectangle: height < 0");

        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean contains(int xClick, int yClick) {
        return x<=xClick && xClick<=x+w && y<=yClick && yClick<=y+h;
    }

    @Override
    public String toString() {
        return String.format("Rect(%d, %d, %d, %d)",x,y,w,h);
    }
}
