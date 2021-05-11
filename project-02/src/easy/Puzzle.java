package easy;

import javax.swing.*;
import java.util.ArrayList;

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

    private ArrayList<BlueBox> boxes;
    private ArrayList<Goal> goals;
    private ArrayList<Boolean> isInGoal;
    private Robot robot;

    public Puzzle(char[][] level) {
        this.boxes = new ArrayList<>();
        this.goals = new ArrayList<>();
        this.isInGoal = new ArrayList<>();
        this.height = level.length;
        this.width = level[0].length;
        this.moves = 0;
        this.data = new char[height][width];

        for(int r=0; r<height; ++r) {
            for(int c=0; c<width; ++c) {
                if(level[r][c]=='R') {
                    robotRow = r;
                    robotCol = c;
                    robot = new Robot(r,c);
                    data[r][c] = ' ';
                } else if(level[r][c]=='$') {
                    boxRow= r;
                    boxCol = c;
                    boxes.add(new BlueBox(r,c));
                    isInGoal.add(false);
                    data[r][c] = ' ';
                } else if(level[r][c]=='E') {
                    exitRow = r;
                    exitCol = c;
                    goals.add(new Goal(r,c));
                    data[r][c] = ' ';
                } else {
                    data[r][c] = level[r][c];
                    //data[r][c] = level[r][c];
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

    public char getCurElement(int row, int col) {
        return data[row][col];
    }

    public int getMoves() {
        return moves;
    }

    public void move(int dr, int dc, int collision) {
        switch (collision) {
            case GameModel.LEFT_COLLISION:
                for (BlueBox box : boxes) {
                    if (isLeftCollision(robotRow, robotCol, box.getRow(), box.getCol())) {
                        if (moveBox(dr, dc, box)) {
                            moveRobot(dr, dc);
                        }
                        return;
                    }
                }
                moveRobot(dr,dc);
                break;
            case GameModel.RIGHT_COLLISION:
                for (BlueBox box : boxes) {
                    if (isRightCollision(robotRow, robotCol, box.getRow(), box.getCol())) {
                        if (moveBox(dr, dc, box)) {
                            moveRobot(dr, dc);
                        }
                        return;
                    }
                }
                moveRobot(dr,dc);
                break;
            case GameModel.TOP_COLLISION:
                for (BlueBox box : boxes) {
                    if (isTopCollision(robotRow, robotCol, box.getRow(), box.getCol())) {
                        if (moveBox(dr, dc, box)) {
                            moveRobot(dr, dc);
                        }
                        return;
                    }
                }
                moveRobot(dr,dc);
                break;
            case GameModel.BOTTOM_COLLISION:
                for (BlueBox box : boxes) {
                    if (isBottomCollision(robotRow, robotCol, box.getRow(), box.getCol())) {
                        if (moveBox(dr, dc, box)) {
                            moveRobot(dr, dc);
                        }
                        return;
                    }
                }
                moveRobot(dr,dc);
                break;
            default:
                break;
        }
    }

    public void moveRobot(int dr, int dc) {
        int tRow = robotRow+dr;
        int tCol = robotCol+dc;

        if(data[tRow][tCol] == ' ') {
            ++moves;
            robotRow = tRow;
            robotCol = tCol;
            robot.setLocation(robotRow, robotCol);
        }
    }

    public boolean moveBox(int dr, int dc, BlueBox box) {
        int tRow = box.getRow()+dr;
        int tCol = box.getCol()+dc;

        if(data[tRow][tCol] == ' ') {
            box.setLocation(tRow, tCol);
            return true;
        }
        return false;
    }

    public boolean isLeftCollision(int robotRow, int robotCol, int boxRow, int boxCol) {
        return robotRow == boxRow && robotCol-1 == boxCol;
    }

    public boolean isRightCollision(int robotRow, int robotCol, int boxRow, int boxCol) {
        return robotRow == boxRow && robotCol+1 == boxCol;
    }

    public boolean isTopCollision(int robotRow, int robotCol, int boxRow, int boxCol) {
        return robotCol == boxCol && robotRow-1 == boxRow;
    }

    public boolean isBottomCollision(int robotRow, int robotCol, int boxRow, int boxCol) {
        return robotCol == boxCol && robotRow+1 == boxRow;
    }

    public boolean isWin() {
        int numberOfBoxes = boxes.size(), finishedBoxes = 0;
        for (int i = 0; i<boxes.size(); ++i) {
            if (goals.get(i).getRow() == boxes.get(i).getRow() && goals.get(i).getCol() == boxes.get(i).getCol()) {
                boxes.get(i).setInGoal(true);
                ++finishedBoxes;
            } else
                boxes.get(i).setInGoal(false);
        }
        return finishedBoxes==numberOfBoxes;
    }

    public ArrayList<BlueBox> getBoxes() {
        return boxes;
    }

    public ArrayList<Goal> getGoals() {
        return goals;
    }

    public Robot getRobot() {
        return robot;
    }
}

