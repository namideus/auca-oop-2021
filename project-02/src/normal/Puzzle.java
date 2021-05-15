package normal;

import normal.GameModel;
import normal.actors.BlueBox;
import normal.actors.Goal;
import normal.actors.Robot;

import java.util.ArrayList;

public class Puzzle {

    // Fields
    // For checking all eight neighbours
    private final int[] xs = { 1, -1, 0, 1,-1, 0, -1, 1};
    private final int[] ys = { 1, -1, 1, 0, 0,-1, 1 , -1 };

    private char[][] data; // board matrix
    private int height; // height
    private int width; // width
    private int moves; // moves
    private int maxMoves; // maximum moves

    // Object fields
    private ArrayList<BlueBox> boxes;
    private ArrayList<Goal> goals;
    private Robot robot;
    private GameModel game;

    public Puzzle(char[][] level, GameModel game) {
        this.game = game; // GameModel
        this.boxes = new ArrayList<>();
        this.goals = new ArrayList<>();
        this.height = level.length;
        this.width = level[0].length;
        this.moves = 0;
        int boxId = 0; // Box id
        this.data = new char[height][width];

        for(int r=0; r<height; ++r) {
            for(int c=0; c<width; ++c) {
                if(level[r][c]=='@') { // Robot
                    robot = new Robot(r,c);
                    data[r][c] = ' ';
                } else if(level[r][c]=='$') { // Box
                    boxes.add(new BlueBox(r,c,++boxId));
                    data[r][c] = ' ';
                } else if(level[r][c]=='.') { // Goal
                    goals.add(new Goal(r, c));
                    data[r][c] = ' ';
                }else if(level[r][c]=='*') { // Box set in goal
                    goals.add(new Goal(r,c));
                    BlueBox box = new BlueBox(r,c,++boxId);
                    box.setInGoal(true);
                    boxes.add(box);
                    data[r][c] = ' ';
                } else { // Else
                    data[r][c] = level[r][c];
                }
            }
        }

        clearEdges(0,0);
        clearEdges(0,width-1);
        clearEdges(height-1,0);
        clearEdges(height-1,width-1);
    }

    // If col and row are valid
    public boolean isValid(int row, int col) {
        return row>=0 && col>=0 && row<height && col<width;
    }

    // Flood fill algorithm
    public void clearEdges(int row, int col) {
        if(!isValid(row, col))
            throw new RuntimeException("Invalid parameters passed in clearEdges() function");

        // Base case
        if (data[row][col] != ' ')
            return;

        // Set counter or empty chart
        data[row][col] = 'B';

        // Recursion
        for (int k = 0; k < 8; ++k) {
            if (isValid(xs[k] + row, ys[k] + col)) {
                clearEdges(xs[k] + row, ys[k] + col);
            }
        }
    }

    // Move robot and box
    public void move(int dr, int dc, int collision) {
        switch (collision) {
            case GameModel.LEFT_COLLISION:
                for (BlueBox box : boxes) {
                    if (isLeftCollision(robot.getRow(), robot.getCol(), box.getRow(), box.getCol())) {
                        if (moveBox(dr, dc, box)) {
                            //game.addState(new State(dr, dc, collision, box.getId()));
                            moveRobot(dr, dc, collision,  box.getId(),true);
                        }
                        return;
                    }
                }
                moveRobot(dr, dc, collision,  -1,true);
                // game.addState(new State(dr, dc, collision));
                break;
            case GameModel.RIGHT_COLLISION:
                for (BlueBox box : boxes) {
                    if (isRightCollision(robot.getRow(), robot.getCol(), box.getRow(), box.getCol())) {
                        if (moveBox(dr, dc, box)) {
                            //game.addState(new State(dr, dc, collision, box.getId()));
                            moveRobot(dr, dc, collision,  box.getId(),true);
                        }
                        return;
                    }
                }
                moveRobot(dr, dc, collision,  -1,true);
                // game.addState(new State(dr, dc, collision));
                break;
            case GameModel.TOP_COLLISION:
                for (BlueBox box : boxes) {
                    if (isTopCollision(robot.getRow(), robot.getCol(), box.getRow(), box.getCol())) {
                        if (moveBox(dr, dc, box)) {
                            // game.addState(new State(dr, dc, collision, box.getId()));
                            moveRobot(dr, dc, collision,  box.getId(),true);
                        }
                        return;
                    }
                }
                moveRobot(dr, dc, collision,  -1,true);
                // game.addState(new State(dr, dc, collision));
                break;
            case GameModel.BOTTOM_COLLISION:
                for (BlueBox box : boxes) {
                    if (isBottomCollision(robot.getRow(), robot.getCol(), box.getRow(), box.getCol())) {
                        if (moveBox(dr, dc, box)) {
                            game.addState(new State(dr, dc, collision, box.getId()));
                            moveRobot(dr, dc, collision,  box.getId(),true);
                        }
                        return;
                    }
                }
                moveRobot(dr, dc, collision,  -1,true);
                // game.addState(new State(dr, dc, collision));
                break;
            case GameModel.TIME_TRAVEL:
                moveRobotInTime(dr,dc,false);

                State state = game.getState();

                for (BlueBox box : boxes) {
                    if (state.isHasMovedBox()) {
                        if (state.getBoxId() == box.getId()) {
                            moveBox(dr, dc, box);
                            break;
                        }
                    }
                }
                break;
            default:
                break;
        }
    }

    // Move robot if possible
    public void moveRobot(int dr, int dc, int collision, int boxId, boolean isCount) {
        int tRow = robot.getRow()+dr;
        int tCol = robot.getCol()+dc;

        if(data[tRow][tCol] == ' ') {
            if(isCount) {
                ++moves;
                maxMoves = moves;
            }
            game.addState(new State(dr, dc, collision, boxId));
            robot.setLocation(tRow, tCol);
        }
    }

    // Move robot if possible
    public void moveRobotInTime(int dr, int dc, boolean isCount) {
        int tRow = robot.getRow()+dr;
        int tCol = robot.getCol()+dc;

        if(data[tRow][tCol] == ' ') {
            if(isCount) {
                ++moves;
                maxMoves = moves;
            }
            robot.setLocation(tRow, tCol);
        }
    }

    // Move box if possible
    public boolean moveBox(int dr, int dc, BlueBox box) {
        int tRow = box.getRow()+dr;
        int tCol = box.getCol()+dc;

        if(data[tRow][tCol] == ' ') {
            box.setLocation(tRow, tCol);
            return true;
        }
        return false;
    }

    // Four direction collision detection
    public boolean isLeftCollision(int robotRow, int robotCol, int boxRow, int boxCol) {
        return robotRow == boxRow && robotCol-1 == boxCol;
    }

    // Is right collision
    public boolean isRightCollision(int robotRow, int robotCol, int boxRow, int boxCol) {
        return robotRow == boxRow && robotCol+1 == boxCol;
    }

    // Is top collision
    public boolean isTopCollision(int robotRow, int robotCol, int boxRow, int boxCol) {
        return robotCol == boxCol && robotRow-1 == boxRow;
    }

    // Is bottom collision
    public boolean isBottomCollision(int robotRow, int robotCol, int boxRow, int boxCol) {
        return robotCol == boxCol && robotRow+1 == boxRow;
    }

    // Check if the game is finished
    public boolean isWin() {
        int numberOfBoxes = boxes.size(), finishedBoxes = 0;
        for (int i = 0; i<numberOfBoxes; ++i) {
            if (goals.get(i).getRow() == boxes.get(i).getRow() && goals.get(i).getCol() == boxes.get(i).getCol()) {
                boxes.get(i).setInGoal(true);
                ++finishedBoxes;
            } else {
                boxes.get(i).setInGoal(false);
            }
        }
        return finishedBoxes==numberOfBoxes;
    }

    // Decrease count of moves
    public void decreaseMoves() {
        if(moves>0)
            moves-=1;
    }

    // Increase count of moves
    public void increaseMoves() {
        if(moves<maxMoves && moves>0)
            moves+=1;
    }

    // Get boxes
    public ArrayList<BlueBox> getBoxes() {
        return boxes;
    }

    // Get goals
    public ArrayList<Goal> getGoals() {
        return goals;
    }

    // Get robot
    public Robot getRobot() {
        return robot;
    }

    // Get width
    public int getWidth() {
        return width;
    }

    // Get height
    public int getHeight() {
        return height;
    }

    // Get current element
    public char getCurElement(int row, int col) {
        return data[row][col];
    }

    // Get count of moves
    public int getMoves() {
        return moves;
    }
}

