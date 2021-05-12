package prototype03;

public class Rect extends Figure{
    private final int w;
    private final int h;

    public Rect(int x, int y, int w, int h) {
        super(x,y);

        if(w<0)
            throw new IllegalArgumentException("Rectangle: width < 0");
        if(h<0)
            throw new IllegalArgumentException("Rectangle: height < 0");

        this.w = w;
        this.h = h;
    }

    @Override
    public boolean contains(int xClick, int yClick) {
        return x<=xClick && xClick<=x+w && y<=yClick && yClick<=y+h;
    }

    @Override
    public String toString() {
        return String.format("Rect(%d, %d, %d, %d)",x, y, w, h);
    }
}
