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
    private boolean leftClicked;
    private int height;
    private int width;
    private int minesNumber;
    public String mode;
    private boolean[][] flags;
    private boolean[][] revealed;
    private char[][] board;
    private int[][] mines;

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
        setup();
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

        setup();
    }

    // Set up the game matrices
    private void setup() {
        board = new char[height][width];
        revealed = new boolean[height][width];
        flags = new boolean[height][width];
        for(int x=0; x<width; x++){
            for(int y=0; y<height; y++){
                mines[x][y]=0;
                flags[x][y]=false;
                revealed[x][y]=false;
            }
        }
    }

    // Fill the board array
    private void fillBoard() {
        board = new char[height][width];
        revealed = new boolean[height][width];

        for(int row = 0; row < height; ++row) {
            for(int col = 0; col < width; ++col) {
                board[row][col] = '.';
            }
        }
    }

    // How many mines are near
    int calcNear(int x, int y) {
        if(isOutBounds(x,y))return 0;
        int i=0;
        for (int offsetX=-1; offsetX<=1; offsetX++) {
            for (int offsetY=-1; offsetY<=1; offsetY++) {
                if (isOutBounds(offsetX+x, offsetY+y))continue;
                i+=mines[offsetX+x][offsetY+y];
            }
        }
        return i;
    }

    void reveal(int x, int y){
        if(isOutBounds(x,y)) return;
        if(revealed[x][y]) return;
        revealed[x][y]=true;
        if(calcNear(x,y)!=0)return;
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
    private void seedMines() {
        int i=0;
        while(i<minesNumber) {
            int x=(int)(Math.random()*width+1);
            int y=(int)(Math.random()*height+1);
            if(mines[x][y]==1)
                continue;
            mines[x][y]=1;
            i++;
        }
    }

    // Clear mines
    private void clearMines() {
        for (int x=0; x<width; x++)
            for (int y=0; y<height; y++)
                mines[x][y]=0;
    }

    // Left
    public void left(int x, int y) {
        seedMines();
        seedMines();
    }

    // Right
    public void right(int x, int y) {
        //seedMines();
        seedMines();
    }


    // Print the board array
    public void print() {
        System.out.printf("\nGame(%s, width=%d, height=%d, mines=%d, flags=%d)\n", mode, width, height, mines, flags);
        for(int row = 0; row < height; ++row) {
            for(int col = 0; col < width; ++col) {
                System.out.print(board[row][col]);
            }
            System.out.println();
        }
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

    // True if x and y are out of bounds
    public boolean isOutBounds(int x, int y) {
        return x<0||y<0||x>=width||y>=height;
    }
}
