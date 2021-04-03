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
        System.out.printf("\nGame(%s, width=%d, height=%d, mines=%d, flags=%d)\n", mode, width, height, maxMines, flags);

        for(int row = 0; row < height; ++row) {
            for(int col = 0; col < width; ++col) {
                System.out.print(charBoard[row][col]);
            }
            System.out.println();
        }
    }

    // Count the number of mines around row and col
    public int countAdjacentMines(int x, int y) {
        if(!isValid(x,y))
            return 0;

        int count=0;
        for (int k=0; k<8; ++k) {
            if (isValid(xs[k] + x, ys[k] + y)) {
                if (isMine(xs[k] + x, ys[k] + y)) {
                    ++count;
                }
            }
        }

        return count;
    }

    // A recursive function to play the Minesweeper Game
    public boolean playMinesweeperUtil(int x, int y) {
        // Base case
        if(charBoard[x][y]!='.')
            return false;

        // You opened a mine
        // You are going to lose
        if(realBoard[x][y]==MINE) {
            charBoard[x][y]='*';

            for (int i=0; i<maxMines; i++)
                // Reveal all mines
                charBoard[minesLocation[i][0]][minesLocation[i][1]] = '*';

            printBoard();
            System.out.println("\nYou lost!");
            return true;
        } else {
            int count = countAdjacentMines(x,y);
            --movesLeft;

            charBoard[x][y] = String.valueOf(count).charAt(0);
            realBoard[x][y] = count;

            if(count==0) {
                for (int k=0; k<8; ++k) {
                    if (isValid(xs[k] + x, ys[k] + y)) {
                        if (!isMine(xs[k] + x, ys[k] + y)) {
                            playMinesweeperUtil(xs[k] + x, ys[k] + y);
                        }
                    }
                }
            }
        }
        return false;
    }

    // Place mines on the field
    private void placeMines() {
        int i=0;
        while(i<maxMines) {
            int x=(int)(Math.random()*width);
            int y=(int)(Math.random()*height);

            if(realBoard[x][y]==MINE)
                continue;

            minesLocation[i][0] = x;
            minesLocation[i][1] = y;

            realBoard[x][y] = MINE;

            i++;
        }
    }


    public void setUp() {
        // Initialize variables and matrices
        realBoard = new int[width][height];
        charBoard = new char[width][height];
        minesLocation = new int[maxMines][2];
        movesLeft = width*height - maxMines;

        // Initialize
        initialize();

        // Place the mines randomly
        placeMines();
    }

    // Set up the game matrices
    public void initialize() {
        for(int x=0; x<width; x++) {
            for(int y=0; y<height; y++) {
                charBoard[x][y]='.';
                realBoard[x][y] = 0;
            }
        }
    }

    public int getMovesLeft() {
        return this.movesLeft;
    }

    // Left
    public boolean left(int x, int y) {
        return playMinesweeperUtil(x,y);
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
