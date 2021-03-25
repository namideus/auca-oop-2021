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
    // start,finish,g[1001][1001],used[1001],from[1001],dist[1001];

    public static final String BEGINNER = "beginner",
                               INTERMEDIATE = "intermediate",
                               EXPERT = "expert",
                               CUSTOM = "custom";
    private int height, width, mines, flags;
    public String mode;
    private char[][] board;

    // First constructor
    public Game(String mode) {
        switch (mode) {
            case Game.BEGINNER:
                height = width = 9;
                break;
            case Game.INTERMEDIATE:
                height = width = 16;
                break;
            case Game.EXPERT:
                height = 16;
                width = 30;
                break;
            default:
                throw new RuntimeException("Undefined mode!");
        }
        this.mode = mode;
        board = new char[height][width];

        // Fill the board array
        for(int row = 0; row < height; ++row) {
            for(int col = 0; col < width; ++col) {
                board[row][col] = '.';
            }
        }
    }

    // Second constructor
    public Game(String mode, int height, int width) {
        this(mode);
        if(height>0)
            this.height = height;
        else
            throw new RuntimeException("Invalid int height!");

        if(width>0)
            this.width = width;
        else
            throw new RuntimeException("Invalid int width!");
    }

    public void floodFill(int x, int y) {
        // Check for boundaries of grid
        if(x>=0 && x<width && y>=0 && y<height) {
            if (board[x][y] == '.') {
                board[x][y] = '1';
                floodFill(x + 1, y);
                floodFill(x - 1, y);
                floodFill(x, y + 1);
                floodFill(x, y - 1);
            } else
                return;
        }

       /* int start = 0,v;

        used[start] = true;

        dist[start] = 0;

        Queue<Integer> q = new LinkedList<>();

        while(!q.isEmpty())
        {
            v = q.element();
            q.remove();

            for(int u=1; u<=n; u++)
                if(!used[u] && board[v][u]=='.')
                {
                    q.add(u);
                    used[u] = 1;
                    from[u] = v;
                }
        }*/
    }

    // Left
    public void left(int x, int y) {
        floodFill(x,y);
    }

    // Right
    public void right(int x, int y) {
        floodFill(x,y);
    }


    // Print the board array
    public void print() {
        System.out.printf("Game(%s, width=%d, height=%d, mines=%d, flags=%d)\n", mode, width, height, mines, flags);
        for(int row = 0; row < height; ++row) {
            for(int col = 0; col < width; ++col) {
                System.out.print(board[row][col]);
            }
            System.out.println();
        }
    }

//    public void set(int row, int col) {
//        if(row<0 || width<=row || col<0 || height<=col) {
//            throw new RuntimeException("Canvas: coordinates out of border");
//        }
//    }

    public boolean isOnBoard(int turtleRow, int turtleCol) {
        return 0<=turtleRow && turtleRow < width || 0 <= turtleCol && turtleCol < height;
    }
}
