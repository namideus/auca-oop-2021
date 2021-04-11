import java.util.Arrays;

/**
 * author Iman Augustine
 *
 * Game is a logic class of Minesweeper game with a nice interface
 * accessed from  the driver program.
 *
 * OOP course, Dmitry Shostak.
 *
 * * */

public class Game {

    // Variables
    public static final String BEGINNER = "beginner";
    public static final String INTERMEDIATE = "intermediate";
    public static final String EXPERT = "expert";
    public static final String CUSTOM = "custom";
    private final int MINE = -1;
    private final int FLAG = -2;
    private boolean isMined = false;
    private int height;
    private int width;
    private int maxMines;
    private int flags = 0, movesLeft;
    public String mode;

    // Matrices
    private char[][] charBoard;
    private int[][] realBoard;
    private int[][] minesLocation;

    // For checking all eight neighbours
    private final int[] xs = { 1, -1, 0, 1,-1, 0, -1, 1};
    private final int[] ys = { 1, -1, 1, 0, 0,-1, 1 , -1 };

    // Constructor for three modes of Minesweeper Game
    public Game(String mode) {
        switch (mode) {
            case Game.BEGINNER:
                height = width = 9;
                maxMines = 9;
                break;
            case Game.INTERMEDIATE:
                height = width = 16;
                maxMines = 40;
                break;
            case Game.EXPERT:
                height = 16;
                width = 30;
                maxMines = 99;
                break;
            default:
                usage("Unknown mode: "+mode);
        }
        this.mode = mode;

        // Setup the game critical data
        setUp();
    }

    // Constructor for custom Minesweeper Game
    public Game(int height, int width, int mines) {
        this.mode = CUSTOM;

        if(height < 1) {
            throw new IllegalArgumentException("Height cannot be less than 1: " + height);
        }
        if(width < 1) {
            throw new IllegalArgumentException("Width cannot be less than 1: " + width);
        }
        if(mines < 1 || mines>=height*width) {
            throw new IllegalArgumentException("Incorrect number of mines: " + mines);
        }
        this.height = height;
        this.width = width;
        this.maxMines = mines;

        //usage("Incorrect mode: mines >= width * height");
        // Setup the game critical data
        setUp();
    }

    // If col and row are valid
    public boolean isValid(int row, int col) {
        return row>=0 && col>=0 && row<height && col<width;
    }

    // Check if it is a mine
    public boolean isMine(int x, int y) {
        return realBoard[x][y]==MINE;
    }

    // Count the number of mines around row and col
    public int countAdjacentMines(int row, int col) {
        if(!isValid(row, col))
            return 0;

        int count=0; // Counter
        for (int k=0; k<8; ++k)
            count+=(isValid(xs[k] + row, ys[k] + col) && isMine(xs[k] + row, ys[k] + col))? 1 : 0;
        return count;
    }

    // Place mines on the field
    private void placeMines(int userX, int userY) {
        for(int i=0;i<maxMines; ++i) {
            // Random position of mines
            int x=(int)(Math.random()*height);
            int y=(int)(Math.random()*width);
            // Already mined, continue
            if(realBoard[x][y]==MINE || userX==x && userY==y)
                continue;
            // Save mine's position
            minesLocation[i][0] = x;
            minesLocation[i][1] = y;
            // Mine
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
    }

    // Set up the game matrices
    public void initialize() {
        for(int i=0; i<height; i++)
            for(int j=0; j<width; j++)
                charBoard[i][j]='.';
    }

    // Gets moves left
    public int getMovesLeft() {
        return this.movesLeft;
    }

    // Get flags count
    public int getFlags() {
        return flags;
    }

    // Get number of mines
    public int getMaxMines() {
        return maxMines;
    }

    // Get height
    public int getHeight() {
        return height;
    }

    // Get width
    public int getWidth() {
        return width;
    }

    public boolean isMined() {
        return this.isMined;
    }

    // A recursive function to play the Minesweeper Game
    // Only works on left click at x y
    public boolean left(int row, int col) {
        if(!isValid(row, col))
            throw new RuntimeException("Invalid parameters passed in left() function");

        // Place mines randomly on first left click
        if(!isMined) {
            isMined = true;
            placeMines(row, col);
        } else {
            // Base case
            if (charBoard[row][col] != '.' && charBoard[row][col] != 'F')
                return false;

            // You opened a mine
            // You are going to lose
            if (isMine(row, col)) {
                charBoard[row][col] = '*';

                // Reveal all mines
                for (int i = 0; i < maxMines; i++) {
                    charBoard[minesLocation[i][0]][minesLocation[i][1]] = '*';
                }

                return true;
            } else {
                int count = countAdjacentMines(row, col);
                --movesLeft;

                // Set counter or empty chart
                charBoard[row][col] = (count == 0) ? '#' : String.valueOf(count).charAt(0);
                realBoard[row][col] = count;

                // If count is zero
                if (count == 0) {
                    for (int k = 0; k < 8; ++k) {
                        if (isValid(xs[k] + row, ys[k] + col)) {
                            if (!isMine(xs[k] + row, ys[k] + col)) {
                                left(xs[k] + row, ys[k] + col);
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    // Right click at x, y
    public void right(int row, int col) {
        if(!isValid(row, col))
            throw new RuntimeException("Invalid parameters passed in right() function");

        if(charBoard[row][col]!='.')
            return;

        if(charBoard[row][col]=='F' && isMine(row, col)) {
            charBoard[row][col] = '.';
            --flags;
        }

        if(isMine(row, col)) {
            charBoard[row][col] = 'F';
            ++flags;
        }

        for (int k=0; k<8; ++k) {
            if (isValid(xs[k] + row, ys[k] + col))
                if(isMine(xs[k] + row, ys[k] + col)) {
                    charBoard[xs[k] + row][ys[k] + col] = 'F';
                    ++flags;
            }
        }
    }

    // To string
    @Override
    public String toString() {
        String warning = "the field will be mined after the first left click";
        String header = String.format("Game(%s, width=%d, height=%d, mines=%d, flags=%d)\n", mode.toUpperCase(), width, height, maxMines, flags);
        StringBuilder r = new StringBuilder();
        if(!isMined)
            r.append(warning).append("\n");

        r.append(header);

        for(int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                r.append(charBoard[i][j]).append(" ");
            }
            r.append("\n");
        }

        return r.toString();
    }

    // Help info
    public static String help() {
        return "Help:" +
                "\nleft <row> <col>" +
                "\n\t- left click with coordinates (row, col)" +
                "\nright <row> <col>" +
                "\n\t- right click with coordinates (row, col)" +
                "\nshow" +
                "\n\t- show all mines (cheating)" +
                "\nquit" +
                "\n\t- quit the game (EOF work too)" +
                "\nhelp\n\t- this text\n";
    }

    // Usage info
    public static void usage(String message) {
        System.out.println(message+
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
        throw new RuntimeException("");
    }
}







