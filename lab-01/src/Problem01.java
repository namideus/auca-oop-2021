import java.util.Scanner;

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
    private static boolean turtlesPenUp = false;
    private static int turtleDir = EAST;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command;
        int steps;

        init();

        while(true)
        {
            command = scanner.next();

            switch (command)
            {
                case "PenUp":
                    penUp();
                    break;
                case "PenDown":
                    penDown();
                    break;
                case "TurnRight":
                    turnRight();
                    break;
                case "TurnLeft":
                    turnLeft();
                    break;
                case "Move":
                    steps = scanner.nextInt();
                    move(steps);
                    break;
                case "Print":
                    print();
                    System.exit(2);
                    break;
                default:
                    System.out.println("Undefined command.");
            }
        }
    }

    public static void penDown() {
        turtlesPenDown = true;
        turtlesPenUp = false;
    }

    public static void penUp() {
        turtlesPenDown = false;
        turtlesPenUp = true;
    }

    public static void move(int steps) {
        for(int i=0; i<steps; ++i) {
            if(turtlesPenDown)
            {
                canvas[turtleRow][turtleCol] = '*';
            }
            ++turtleCol;
        }
    }

    public static void turnLeft() {

    }

    public static void turnRight() {

    }

    public static void init() {
        for(int row = 0; row < CANVAS_SIZE; ++row) {
            for(int col = 0; col < CANVAS_SIZE; ++col) {
                canvas[row][col] = '.';
            }
        }
    }

    public static void print()
    {
        for(int row = 0; row < CANVAS_SIZE; ++row) {
            for(int col = 0; col < CANVAS_SIZE; ++col) {
                System.out.print(canvas[row][col]);
            }
            System.out.println();
        }
        System.out.println("Exit");
    }
}
