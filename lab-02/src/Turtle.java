public class Turtle {
    public static final int NORTH = 0;
    public static final int SOUTH = 2;
    public static final int EAST = 1;
    public static final int WEST = 3;

    private Canvas canvas;
    private int turtleRow = 0;
    private int turtleCol = 0;
    private boolean isPenDown = false;
    private int turtleDir = EAST;

    public Turtle(Canvas canvas, int row, int col, boolean isPenDown, int direction) {
        this.canvas = canvas;
        this.turtleDir = direction;
        this.turtleRow = row;
        this.turtleCol = col;
        this.isPenDown = isPenDown;
    }

    public void penDown() {
        this.isPenDown = true;
        canvas.set(turtleRow, turtleCol);
    }

    public void penUp() {
        this.isPenDown = false;
    }

    public void turnLeft() {
        --turtleDir;

        if(turtleDir==-1)
            turtleDir = 3;
    }

    public void turnRight() {
        turtleDir = (turtleDir+1) % 4;
    }

    public void move(int steps) throws ArrayIndexOutOfBoundsException
    {
        for (int i = 0; i < steps; ++i)
        {
            switch(turtleDir)
            {
                case EAST:
                    ++turtleCol;
                    break;
                case SOUTH:
                    ++turtleRow;
                    break;
                case WEST:
                    --turtleCol;
                    break;
                case NORTH:
                    --turtleRow;
                    break;
            }

            if(!canvas.isOnCanvas(turtleRow, turtleCol))
                throw new RuntimeException("Turtle is out of canvas: " + turtleRow + ", " + turtleCol);

            if (isPenDown) {
                canvas.set(turtleRow, turtleCol);
            }
        }
    }
}
