public class Problem01 {

    private static final int CANVAS_SIZE = 20;
    private static char[][] canvas = new char[CANVAS_SIZE][CANVAS_SIZE];

    private static final int NORTH = 0;
    private static final int SOUTH = 2;
    private static final int EAST = 1;
    private static final int WEST = 3;
    private static int turtleRow = 0;
    private static int turtleCol = 0;
    private static boolean turtlesPenDown = false;
    private static int turtleDir = EAST;

    public static void main(String[] args) {
        init();
        penDown();
        move(10);
        print();
    }

    public static void penDown() {
        turtlesPenDown = true;
    }

    public static void move() {

    }

    public static void init() {
        for(int row = 0; row < CANVAS_SIZE; ++row) {
            for(int col = 0; col < CANVAS_SIZE; ++col) {
                canvas[row][col] = '.';
            }
        }
    }

    public static void moveTurtle() {

    }

        public static void print()
    {
        for(int row = 0; row < CANVAS_SIZE; ++row) {
            for(int col = 0; col < CANVAS_SIZE; ++col) {
                System.out.print(canvas[row][col]);
            }
            System.out.println();
        }
    }
}
