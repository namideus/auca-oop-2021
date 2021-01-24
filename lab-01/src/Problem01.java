import java.util.Scanner;

public class Problem01 {

    private static final int CANVAS_SIZE = 20;
    private static char[][] canvas = new char[CANVAS_SIZE][CANVAS_SIZE];
    private static Scanner scanner;
    private static String command;
    private static int steps;
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
        scanner = new Scanner(System.in);

        try {
            run();
        } catch(RuntimeException e) {
            System.out.println("Your turtle is out of canvas. Restart the program!");
        }
    }

    private static void run() {
        init();

        readUserCommand();

        while(!command.equals("Exit"))
        {
                switch (command) {
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
                        move(steps);
                        break;
                    case "Print":
                        print();
                        break;
                }
        }

        readUserCommand();
    }

    private static void readUserCommand() {
        String line = scanner.nextLine();
        switch (line) {
            case "PenUp":
            case "PenDown":
            case "Print":
            case "TurnLeft":
            case "TurnRight":
            case "Exit":
                command = line;
                steps = 0;
                return;
        }
        Scanner inpLine = new Scanner(line);
        command = inpLine.next();
        steps = inpLine.nextInt();
    }

    public static void penDown() {
        turtlesPenDown = true;
        turtlesPenUp = false;
    }

    public static void penUp() {
        turtlesPenDown = false;
        turtlesPenUp = true;
    }

    public static void move(int steps) throws ArrayIndexOutOfBoundsException
    {
            for (int i = 0; i < steps; ++i)
            {
                if(isOutOfCanvas(turtleRow, turtleCol))
                    throw new ArrayIndexOutOfBoundsException();

                if (turtlesPenDown) {
                    canvas[turtleRow][turtleCol] = '*';
                }

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
            }
    }

    public static void turnLeft() {
        --turtleDir;

        if(turtleDir==-1)
            turtleDir = 3;
    }

    public static void turnRight() {
        turtleDir = (turtleDir+1) % 4;
    }

    private static void init() {
        for(int row = 0; row < CANVAS_SIZE; ++row) {
            for(int col = 0; col < CANVAS_SIZE; ++col) {
                canvas[row][col] = '.';
            }
        }
    }

    private static void print()
    {
        for(int row = 0; row < CANVAS_SIZE; ++row) {
            for(int col = 0; col < CANVAS_SIZE; ++col) {
                System.out.print(canvas[row][col]);
            }
            System.out.println();
        }
    }

    private static boolean isOutOfCanvas(int turtleRow, int turtleCol) {
        return 0 > turtleRow || CANVAS_SIZE <= turtleRow && turtleCol < 0 || CANVAS_SIZE <= turtleCol;
    }
}
