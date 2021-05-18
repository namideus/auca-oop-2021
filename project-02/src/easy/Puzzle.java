package easy;

import javax.swing.*;
import java.util.ArrayList;

public class Puzzle {
    private char[][] data;
    private int height;
    private int width;
    private int moves;

    private ArrayList<BlueBox> boxes;
    private ArrayList<Goal> goals;
    private Robot robot;

    public Puzzle(char[][] level) {
        this.boxes = new ArrayList<>();
        this.goals = new ArrayList<>();
        this.height = level.length;
        this.width = level[0].length;
        this.moves = 0;
        this.data = new char[height][width];

        for(int r=0; r<height; ++r) {
            for(int c=0; c<width; ++c) {
                if(level[r][c]=='R') {
                    robot = new Robot(r,c);
                    data[r][c] = ' ';
                } else if(level[r][c]=='$') {
                    boxes.add(new BlueBox(r,c));
                    data[r][c] = ' ';
                } else if(level[r][c]=='E') {
                    goals.add(new Goal(r,c));
                    data[r][c] = ' ';
                } else {
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
                    if (isLeftCollision(robot.getRow(), robot.getCol(), box.getRow(), box.getCol())) {
                        for (BlueBox box1 : boxes) {
                            if (isLeftCollision(box.getRow(), box.getCol(), box1.getRow(), box1.getCol())) {
                                return;
                            }
                        }
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
                    if (isRightCollision(robot.getRow(), robot.getCol(), box.getRow(), box.getCol())) {
                        for (BlueBox box1 : boxes) {
                            if (isRightCollision(box.getRow(), box.getCol(), box1.getRow(), box1.getCol())) {
                                return;
                            }
                        }
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
                    if (isTopCollision(robot.getRow(), robot.getCol(), box.getRow(), box.getCol())) {
                        for (BlueBox box1 : boxes) {
                            if (isTopCollision(box.getRow(), box.getCol(), box1.getRow(), box1.getCol())) {
                                return;
                            }
                        }
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
                    if (isBottomCollision(robot.getRow(), robot.getCol(), box.getRow(), box.getCol())) {
                        for (BlueBox box1 : boxes) {
                            if (isBottomCollision(box.getRow(), box.getCol(), box1.getRow(), box1.getCol())) {
                                return;
                            }
                        }
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
        int tRow = robot.getRow()+dr;
        int tCol = robot.getCol()+dc;

        if(data[tRow][tCol] == ' ') {
            ++moves;
            robot.setLocation(tRow, tCol);
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
        for (BlueBox box : boxes) {
            for (int i = 0; i<numberOfBoxes; ++i) {
                if (goals.get(i).getRow() == box.getRow() && goals.get(i).getCol() == box.getCol()) {
                    box.setInGoal(true);
                    ++finishedBoxes;
                    break;
                } else {
                    box.setInGoal(false);
                }
            }
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

