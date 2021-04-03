import java.util.Scanner;

/**
 * author Iman Augustine
 *
 * Game is a logic class of Minesweeper game with a nice interface
 * accessed from  the driver program.
 *
 * OOP course, Dmitry Shostak.
 *
 * * */

public class MinesweeperGame {

    // Variables
    public static final String BEGINNER = "beginner";
    public static final String INTERMEDIATE = "intermediate";
    public static final String EXPERT = "expert";
    public static final String CUSTOM = "custom";
    private final int MINE = -1;
    private final int FLAG = -2;
    private final int height;
    private final int width;
    private final int maxMines;
    private int flags, movesLeft;
    public String mode;

    // Matrices
    private char[][] charBoard;
    private int[][] realBoard;
    private int[][] minesLocation;

    // For checking all eight neighbours
    private final int[] xs = { 1, -1, 0, 1,-1, 0, -1, 1};
    private final int[] ys = { 1, -1, 1, 0, 0,-1, 1 , -1 };

    // Constructor for three modes of Minesweeper Game
    public MinesweeperGame(String mode) {
        switch (mode) {
            case MinesweeperGame.BEGINNER:
                height = 9;
                width = 9;
                maxMines = 9;
                break;
            case MinesweeperGame.INTERMEDIATE:
                height = 16;
                width = 16;
                maxMines = 40;
                break;
            case MinesweeperGame.EXPERT:
                height = 16;
                width = 30;
                maxMines = 99;
                break;
            default:
                usage(mode);
                throw new RuntimeException("");
        }
        this.mode = mode;

        // Setup the game critical data
        setUp();
    }

    // Constructor for custom Minesweeper Game
    public MinesweeperGame(int height, int width, int mines) {
        this.mode = CUSTOM;

        if(height>0 && width>0 && mines>=0) {
            this.height = height;
            this.width = width;
            this.maxMines = mines;
        } else
            throw new RuntimeException("Invalid height and/or width and/or mines!");

        // Setup the game critical data
        setUp();
    }

    // If col and row are valid
    public boolean isValid(int x, int y) {
        return x>=0 && y>=0 && x<width && y<height;
    }

    // Check if it is a mine
    public boolean isMine(int x, int y) {
        return realBoard[x][y]==MINE;
    }

    // Print the board
    public void printBoard() {
        System.out.printf("\nGame(%s, width=%d, height=%d, mines=%d, flags=%d)\n", mode.toUpperCase(), width, height, maxMines, flags);

        for(int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                System.out.print(charBoard[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Count the number of mines around row and col
    public int countAdjacentMines(int row, int col) {
        if(!isValid(row, col))
            return 0;

        int count=0;
        for (int k=0; k<8; ++k)
            //if (isValid(xs[k] + row, ys[k] + col)) {
            count+=(isValid(xs[k] + row, ys[k] + col) && isMine(xs[k] + row, ys[k] + col))? 1 : 0;
            //}

        return count;
    }

    // A recursive function to play the Minesweeper Game
    public boolean playMinesweeperUtil(int row, int col) {
        // Base case
        if(charBoard[row][col]!='.')
            return false;

        // You opened a mine
        // You are going to lose
        if(realBoard[row][col] == MINE) {
            charBoard[row][col] = '*';

            // Reveal all mines
            for (int i=0; i<maxMines; i++)
                charBoard[minesLocation[i][0]][minesLocation[i][1]] = '*';

            // printBoard();
            //System.out.println("\nYou lost! Next time you will be better!");
            return true;
        } else {
            int count = countAdjacentMines(row, col);
            --movesLeft;

            charBoard[row][col] = (count==0) ? '#': String.valueOf(count).charAt(0);
            realBoard[row][col] = count;

            if(count==0) {
                for (int k=0; k<8; ++k) {
                    if (isValid(xs[k] + row, ys[k] + col)) {
                        if (!isMine(xs[k] + row, ys[k] + col)) {
                            playMinesweeperUtil(xs[k] + row, ys[k] + col);
                        }
                    }
                }
            }
        }
        return false;
    }

    // Place mines on the field
    private void placeMines() {
        for(int i=0;i<maxMines; ++i) {

            int x=(int)(Math.random()*width);
            int y=(int)(Math.random()*height);

            if(realBoard[x][y]==MINE)
                continue;

            minesLocation[i][0] = x;
            minesLocation[i][1] = y;

            realBoard[x][y] = MINE;
        }
    }

    // Set up the Minesweeper Game boards
    public void setUp() {
        // Initialize variables and matrices
        realBoard = new int[height][width];
        charBoard = new char[height][width];
        minesLocation = new int[maxMines][2];
        movesLeft = width*height - maxMines;

        // Initialize
        initialize();

        // Place the mines randomly
        placeMines();
    }

    // Set up the game matrices
    public void initialize() {
        for(int i=0; i<width; i++)
            for(int j=0; j<height; j++)
                charBoard[i][j]='.';
    }

    public int getMovesLeft() {
        return this.movesLeft;
    }

    // Left
    public boolean left(int row, int col) {
        return playMinesweeperUtil(row, col);
    }

    // Right
    public void right(int x, int y) {

    }

    // Help info
    public void help() {
        System.out.println("Help:");
        System.out.println("left <row> <col>");
        System.out.println("\t- left click with coordinates (row, col)");
        System.out.println("right <row> <col>");
        System.out.println("\t- right click with coordinates (row, col)");
        System.out.println("show");
        System.out.println("\t- show all mines (cheating)");
        System.out.println("quit");
        System.out.println("\t- quit the game (EOF work too)");
        System.out.println("help");
        System.out.println("\t- this text");
    }

    // Usage info
    private void usage(String mode) {
        System.out.println("Unknown mode: "+mode+
                "\nUsage: " +
                "\njava -jar Minesweeper.jar beginner" +
                "\n\t- game in the beginner mode: width=9, height=9, mines=10" +
                "\njava -jar Minesweeper.jar intermediate" +
                "\n\t- game in the intermediate mode: width=16, height=16, mines=40" +
                "\njava -jar Minesweeper.jar expert" +
                "\n\t- game in the expert mode: width=9, height=9, mines=10" +
                "\njava -jar Minesweeper.jar" +
                "\n\t- equivalent to \"java -jar Minesweeper.jar beginner\"" +
                "\njava -jar Minesweeper.jar <width> <height> <mines>" +
                "\n\t- game with the specified width, height and number of mines");
    }
}

// User command
class UserCommand {
    public static final String LEFT = "left";
    public static final String RIGHT = "right";
    public static final String SHOW = "show";
    public static final String HELP = "help";
    public static final String QUIT = "quit";

    private final String command;
    private int row, col;

    public UserCommand(String line) {
        line = line.trim();
        switch (line) {
            case SHOW:
            case HELP:
            case QUIT:
                command = line;
                return;
        }

        Scanner inpLine = new Scanner(line);
        if(!inpLine.hasNext()) {
            throw new RuntimeException("Wrong command: '"+line+"'");
        }

        String userCommand = inpLine.next();
        if(!userCommand.equals(LEFT) && !userCommand.equals(RIGHT)) {
            throw new RuntimeException("Unknown command: '"+line+"'");
        }

        if(!inpLine.hasNextInt()) {
            throw new RuntimeException("No integer in command "+userCommand+": '"+line+"'");
        }

        int row = inpLine.nextInt();
        if(row<0) {
            throw new RuntimeException("Negative row in command "+userCommand+": '"+line+"'");
        }

        if (!inpLine.hasNext()) {
            throw new RuntimeException("Not enough parameters in command "+userCommand+": '"+line+"'");
        }

        int col = inpLine.nextInt();
        if(col<0) {
            throw new RuntimeException("Negative col in command "+userCommand+": '"+line+"'");
        }

        if (inpLine.hasNext()) {
            throw new RuntimeException("Too many parameters in command "+userCommand+": '"+line+"'");
        }

        command = userCommand;
        this.row = row;
        this.col = col;
    }

    // Getter
    public String getCommand() {
        return command;
    }

    public int getRow() {
        if(!command.equals(LEFT) && !command.equals(RIGHT)) {
            throw new RuntimeException("Undefined row or col: current command is not "+LEFT+" or "+RIGHT);
        }
        return this.row;
    }

    public int getCol() {
        if(!command.equals(LEFT) && !command.equals(RIGHT)) {
            throw new RuntimeException("Undefined row or col: current command is not "+LEFT+" or "+RIGHT);
        }
        return this.col;
    }
}