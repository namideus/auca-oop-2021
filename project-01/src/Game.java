import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

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
    private final int height;
    private final int width;
    private final int minesNumber;
    private int flags;
    public String mode;

    private char[][] charBoard, myBoard, realBoard;
    private int[][] board;

    private int[] xs = { 1, -1, 0, 1,-1, 0, -1, 1};
    private int[] ys = { 1, -1, 1, 0, 0,-1, 1 , -1 };

    // First constructor
    public Game(String mode) {
        switch (mode) {
            case Game.BEGINNER:
                height = width = 9;
                minesNumber = 9;
                break;
            case Game.INTERMEDIATE:
                height = width = 16;
                minesNumber = 40;
                break;
            case Game.EXPERT:
                height = 16;
                width = 30;
                minesNumber = 99;
                break;
            default:
                usage(mode);
                throw new RuntimeException("");
        }
        this.mode = mode;

        //setup();
    }

    // Second constructor
    public Game(int height, int width, int mines) {
        this.mode = CUSTOM;

        if(height>0 && width>0 && mines>=0) {
            this.height = height;
            this.width = width;
            this.minesNumber = mines;
        } else
            throw new RuntimeException("Invalid height and/or width and/or mines!");

        //setup();
    }


    public void setUp() {
        board = new int[width][height];
        //myBoard = new char[width][height];
        //realBoard = new char[width][height];
        charBoard = new char[width][height];

        initialize();
        placeMines();
    }

    // Set up the game matrices
    public void initialize() {
        for(int x=0; x<width; x++) {
            for(int y=0; y<height; y++) {
                charBoard[x][y]='.';
                board[x][y] = 0;
            }
        }
    }

    // Check if it is a mine
    public boolean isMine(int x, int y) {
        return board[x][y]==-1;
    }

    // Count the number of mines around row and col
    public int countAdjacentMines(int x, int y) {
        if(!isValid(x,y))
            return 0;

        int count=0;
        for (int k=0; k<8; ++k)
            if (isValid(xs[k]+x, ys[k]+y))
                if(isMine(xs[k]+x,ys[k]+y))
                    ++count;

        return count;
    }

    // Reveal?
    public void reveal(int x, int y){
        if(!isValid(x,y))
            return;

        if(charBoard[x][y]=='#')
            return;

        charBoard[x][y]='#';

        if(countAdjacentMines(x,y)!=0)
            return;

        reveal(x-1,y-1);
        reveal(x-1,y+1);
        reveal(x+1,y-1);
        reveal(x+1,y+1);
        reveal(x-1,y);
        reveal(x+1,y);
        reveal(x,y-1);
        reveal(x,y+1);
    }

    // Seed mines on the field
    private void placeMines() {
        int i=0;
        while(i<minesNumber) {
            int x=(int)(Math.random()*width);
            int y=(int)(Math.random()*height);

            if(board[x][y]==-1)
                continue;

            board[x][y]=-1;

            i++;
        }
    }

    // Left
    public void left(int x, int y) {

    }

    // Right
    public void right(int x, int y) {

    }

    // Print the board
    public void print() {
        System.out.printf("\nGame(%s, width=%d, height=%d, mines=%d, flags=%d)\n",
                mode, width, height, minesNumber, flags);

        for(int row = 0; row < height; ++row) {
            for(int col = 0; col < width; ++col) {
                System.out.print(charBoard[row][col]);
            }
            System.out.println();
        }
    }

    // If col and row are valid
    public boolean isValid(int x, int y) {
        return x>=0 && y>=0 && x<width && y<height;
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
