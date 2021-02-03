import java.util.Scanner;

public class Problem01 {

    private static final int CANVAS_SIZE = 20;
    // canvas
    private static char[][] canvas = new char[CANVAS_SIZE][CANVAS_SIZE];
    private static Scanner scanner = new Scanner(System.in);
    private static String command ;
    private static int steps;
    private static final int NORTH = 0;
    private static final int SOUTH = 2;
    private static final int EAST = 1;
    private static final int WEST = 3;
    // turtle
    private static int turtleRow = 0;
    private static int turtleCol = 0;
    private static boolean turtlesPenDown = false;
    private static int turtleDir = EAST;

    private static int nLine = 0;

    public static void main(String[] args) {

        try {
            run();
        } catch(RuntimeException e) {
            System.out.println("Your program has a problem in line: "+nLine+":");
            System.out.println(e.getMessage());
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

    // Procedures (functions)
    private static void readUserCommand() {
        String line = scanner.nextLine().trim();
        ++nLine;
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

        if(!inpLine.hasNext()) {
            throw new RuntimeException("Wrong command: '"+line+"'");
        }

        String userCommand = inpLine.next();
        if(!userCommand.equals("Move")) {
            throw new RuntimeException("Unknown command: '"+line+"'");
        }

        if(!inpLine.hasNextInt()) {
            throw new RuntimeException("No integer in command 'Move': '"+line+"'");
        }

        int numberOfSteps = inpLine.nextInt();
        if(numberOfSteps<0)
        {
            throw new RuntimeException("Negative integer in command 'Move': '"+line+"'");
        }

        if (inpLine.hasNext()) {
            throw new RuntimeException("Too many parameters in command 'Move': '"+line+"'");
        }
        command = userCommand;
        steps = numberOfSteps;
    }

    public static void penDown() {
        turtlesPenDown = true;
        canvas[turtleRow][turtleCol] = '*';
    }

    public static void penUp() {
        turtlesPenDown = false;
    }

    public static void move(int steps) throws ArrayIndexOutOfBoundsException
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

                if(!isOnCanvas(turtleRow, turtleCol))
                    throw new RuntimeException("Turtle is out of canvas: " + turtleRow + ", " + turtleCol);

                if (turtlesPenDown) {
                    canvas[turtleRow][turtleCol] = '*';
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

    private static boolean isOnCanvas(int turtleRow, int turtleCol) {
        return (0 <= turtleRow && CANVAS_SIZE > turtleRow) && (turtleCol <= 0 && turtleCol<CANVAS_SIZE);
    }
}
