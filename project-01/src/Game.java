public class Game {
    public static final int CANVAS_SIZE = 20;
    private char[][] data;

    // Constructor
    public Game() {
        data = new char[CANVAS_SIZE][CANVAS_SIZE];

        for(int row = 0; row < CANVAS_SIZE; ++row) {
            for(int col = 0; col < CANVAS_SIZE; ++col) {
                data[row][col] = '.';
            }
        }
    }

    public void show() {
        for(int row = 0; row < CANVAS_SIZE; ++row) {
            for(int col = 0; col < CANVAS_SIZE; ++col) {
                System.out.print(data[row][col]);
            }
            System.out.println();
        }
    }

    public void set(int row, int col) {
        if(row<0 || CANVAS_SIZE<=row || col<0 || CANVAS_SIZE<=col) {
            throw new RuntimeException("Canvas: coordinates out of border");
        }
        data[row][col] = '*';
    }

    public boolean isOnCanvas(int turtleRow, int turtleCol) {
        return 0<=turtleRow && turtleRow < CANVAS_SIZE || 0 <= turtleCol && turtleCol < CANVAS_SIZE;
    }
}
