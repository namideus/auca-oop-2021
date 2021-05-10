package easy;

import javax.swing.*;
import java.util.ArrayList;

public class GameModel {

    public static final int LEFT_COLLISION = 1;
    public static final int RIGHT_COLLISION = 2;
    public static final int TOP_COLLISION = 3;
    public static final int BOTTOM_COLLISION = 4;

    private int curLevel = 0;
    Puzzle puzzle;

    private static final char[][][] levels = {
            {
                    {'B','B','#','#','#','#','#','B'},
                    {'#','#','#',' ',' ',' ','#','B'},
                    {'#',' ','$',' ','#',' ','#','#'},
                    {'#',' ','#',' ',' ','E',' ','#'},
                    {'#',' ',' ',' ',' ','#',' ','#'},
                    {'#','#',' ','#',' ',' ',' ','#'},
                    {'B','#','R',' ',' ','#','#','#'},
                    {'B','#','#','#','#','#','B','B'}
            },
            {
                    {'B','B','#','#','#','#','#','B'},
                    {'#','#','#',' ',' ',' ','#','B'},
                    {'#',' ','$',' ','#',' ','#','#'},
                    {'#',' ','#',' ',' ','E',' ','#'},
                    {'#',' ',' ',' ',' ','#',' ','#'},
                    {'#','#','$','#','E',' ',' ','#'},
                    {'B','#','R',' ',' ','#','#','#'},
                    {'B','#','#','#','#','#','B','B'}
            },
            {
                    {'B','B','#','#','#','#','#','B'},
                    {'#','#','#',' ',' ',' ','#','B'},
                    {'#',' ','$',' ','#',' ','#','#'},
                    {'#',' ',' ',' ',' ','E',' ','#'},
                    {'#',' ','E',' ',' ','#',' ','#'},
                    {'#','#','$','#','E','$',' ','#'},
                    {'B','#','R',' ',' ','#','#','#'},
                    {'B','#','#','#','#','#','B','B'}
            }
    };

    public GameModel() {
        this.curLevel = 0;
        this.puzzle = new Puzzle(levels[curLevel]);
    }

    public void resetCurrentPuzzle() {
        this.puzzle = new Puzzle(levels[curLevel]);
    }

    public float getCurHeight() {
        return puzzle.getHeight();
    }

    public float getCurWidth() {
        return puzzle.getWidth();
    }

    public int getCurLevel() {
        return curLevel + 1;
    }

    public int getMoves() {
        return puzzle.getMoves();
    }

    public ArrayList<BlueBox> getBoxes() {
        return puzzle.getBoxes();
    }

    public ArrayList<Goal> getGoals() {
        return puzzle.getGoals();
    }

    public Robot getRobot() {
        return puzzle.getRobot();
    }

    public void nextLevel() {
        ++curLevel;
        if(curLevel==levels.length)
            curLevel = 0;
        puzzle = new Puzzle(levels[curLevel]);
    }
}
