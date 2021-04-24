public class GameModel {
    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;

    private int row;
    private int col;

    public void moveUp() {
        if(row>0)
            --row;
    }

    public void moveDown() {
        if(row<HEIGHT-1)
            ++row;
    }

    public void moveLeft() {
        if(col>0)
            --col;
    }

    public void moveRight() {
        if(col<WIDTH-1)
            ++col;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }
}
