package easy;

public class Puzzle {
    private char[][] data;
    private int height;
    private int width;
    private int robotRow;
    private int robotCol;
    private int boxRow;
    private int boxCol;
    private int exitRow;
    private int exitCol;
    private int moves;

    public Puzzle(char[][] level) {
        this.height = level.length;
        this.width = level[0].length;
        this.moves = 0;
        this.data = new char[height][width];
        for(int r=0; r<height; ++r) {
            for(int c=0; c<width; ++c) {
                if(level[r][c]=='R') {
                    robotRow = r;
                    robotCol = c;
                    data[r][c] = ' ';
                } else if(level[r][c]=='$') {
                    boxRow= r;
                    boxCol = c;
                    data[r][c] = ' ';
                } else if(level[r][c]=='E') {
                    exitRow = r;
                    exitCol = c;
                    data[r][c] = ' ';
                } else {
                    data[r][c] = level[r][c];
                    data[r][c] = level[r][c];
                }
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public char get(int row, int col) {
        return data[row][col];
    }

    public int getRobotCol() {
        return robotCol;
    }

    public int getRobotRow() {
        return robotRow;
    }

    public int getExitCol() {
        return exitCol;
    }

    public int getExitRow() {
        return exitRow;
    }

    public int getBoxCol() {
        return boxCol;
    }

    public int getBoxRow() {
        return boxRow;
    }

    public char getCurElement(int row, int col) {
        return data[row][col];
    }

    public int getMoves() {
        return moves;
    }

    public void moveRobot(int dr, int dc) {
        int tRow = robotRow+dr;
        int tCol = robotCol+dc;

        if(data[tRow][tCol] == ' ') {
            ++moves;
            robotRow = tRow;
            robotCol = tCol;
        }

        System.out.println("Right collision: " + isRightCollision(robotRow, robotCol, boxRow, boxCol));
        System.out.println("Left collision: " + isLeftCollision(robotRow, robotCol, boxRow, boxCol));

        if(isLeftCollision(robotRow, robotCol, boxRow, boxCol)) {
            moveBox(dr, dc);
        }
        if(isRightCollision(robotRow, robotCol, boxRow, boxCol)) {
            moveBox(dr, dc);
        }
         if(isTopCollision(robotRow, robotCol, boxRow, boxCol)) {
             moveBox(dr, dc);
         }
        if(isBottomCollision(robotRow, robotCol, boxRow, boxCol)) {
            moveBox(dr, dc);
        }
    }

    public void moveBox(int dr, int dc) {
        int tRow = boxRow+dr;
        int tCol = boxCol+dc;

        if(data[tRow][tCol] == ' ') {
            boxRow = tRow;
            boxCol = tCol;
        }
    }

    public boolean isLeftCollision(int robotRow, int robotCol, int boxRow, int boxCol) {
        return robotRow == boxRow && robotCol-1 == boxCol;
    }

    public boolean isRightCollision(int robotRow, int robotCol, int boxRow, int boxCol) {
        return robotRow == boxRow && robotCol+1 == boxCol;
    }

    public boolean isTopCollision(int robotRow, int robotCol, int boxRow, int boxCol) {

        return robotCol - 1 == boxCol && robotRow == boxRow;
    }

    public boolean isBottomCollision(int robotRow, int robotCol, int boxRow, int boxCol) {
        return robotCol + 1 == boxCol && robotRow == boxRow;
    }

    public boolean isVictorious() {
        // int numberOfBoxes = boxes.size();
        //        int finishedBoxes = 0;
        //
        //        for (BlueBox box : boxes) {
        //            for (Goal goal : goals)
        //                if (goal.getX() == box.getX() && goal.getY() == box.getY())
        //                    ++finishedBoxes;
        //        }
        //
        //        if(finishedBoxes==numberOfBoxes) {
        //            isCompleted = true;
        //            repaint();
        //        }
        return boxRow==exitRow && boxCol==exitCol;
    }
}
