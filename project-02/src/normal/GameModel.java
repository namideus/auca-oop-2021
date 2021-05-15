package normal;

import normal.actors.BlueBox;
import normal.actors.Goal;
import normal.actors.Robot;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GameModel {

    public static final int LEFT_COLLISION = 1;
    public static final int RIGHT_COLLISION = 2;
    public static final int TOP_COLLISION = 3;
    public static final int BOTTOM_COLLISION = 4;
    public static final int TIME_TRAVEL = 5;

    private ArrayList<State> states;

    private int curState = 0;
    private int curLevel = 0;

    private Puzzle puzzle;
    private State state;

    private ArrayList<String> levelsList = new ArrayList<>();

    private static final char[][][] levels = {
            {
                    {'B','B','#','#','#','#','#','B'},
                    {'#','#','#',' ',' ',' ','#','B'},
                    {'#',' ','$',' ','#',' ','#','#'},
                    {'#',' ','#',' ',' ','.',' ','#'},
                    {'#',' ',' ',' ',' ','#',' ','#'},
                    {'#','#',' ','#',' ',' ',' ','#'},
                    {'B','#','@',' ',' ','#','#','#'},
                    {'B','#','#','#','#','#','B','B'}
            },
            {
                    {'B','B','#','#','#','#','#','B'},
                    {'#','#','#',' ',' ',' ','#','B'},
                    {'#',' ','$',' ','#',' ','#','#'},
                    {'#',' ','#',' ',' ','.',' ','#'},
                    {'#',' ',' ',' ',' ','#',' ','#'},
                    {'#','#','$','#','.',' ',' ','#'},
                    {'B','#','@',' ',' ','#','#','#'},
                    {'B','#','#','#','#','#','B','B'}
            },
            {
                    {'B','B','#','#','#','#','#','B'},
                    {'#','#','#',' ',' ',' ','#','B'},
                    {'#',' ','$',' ','#',' ','#','#'},
                    {'#',' ',' ',' ',' ','.',' ','#'},
                    {'#',' ','.',' ',' ','#',' ','#'},
                    {'#','#','$','#','.','$',' ','#'},
                    {'B','#','@',' ',' ','#','#','#'},
                    {'B','#','#','#','#','#','B','B'}
            }
    };

    //
    //  here should be file IO part, read levels from a txt file
    //

    public GameModel() {
        //---------------------Experiment-----------------------
        StringBuilder curPuzzle = new StringBuilder();
        try {
            try (Scanner scan = new Scanner(new File("levels/MiniCosmos.txt"))) {
                while(scan.hasNextLine()) {
                    String line = scan.nextLine();
                    if(line.length()==0) {
                        continue;
                    }
                    if(line.startsWith(";")) {
                        levelsList.add(curPuzzle.toString());
                        curPuzzle = new StringBuilder();
                    } else {
                        curPuzzle.append(line).append("\n");
                    }
                }
            }
            System.out.println("Size: "+levelsList.size());

            int count = 0;
            for(String puzzle : levelsList) {
                //  System.out.println(++count);
                //  System.out.println(puzzle);
                // System.out.println(Arrays.toString(puzzle.split("\n")));
            }
            System.out.println(Arrays.toString(levelsList.get(0).split("\n")));
            //------------------------------------------------------

            this.curLevel = 0;
            this.puzzle = new Puzzle(parseLevel(levelsList.get(curLevel).split("\n")), this);//new Puzzle(levels[curLevel], this);
            this.states = new ArrayList<>();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void resetCurrentPuzzle() {
        //this.puzzle = new Puzzle(levels[curLevel], this);
        this.puzzle = new Puzzle(parseLevel(levelsList.get(curLevel).split("\n")), this);
    }

    public float getHeight() {
        return puzzle.getHeight();
    }

    public float getWidth() {
        return puzzle.getWidth();
    }

    public int getCurLevel() {
        return curLevel + 1;
    }

    public char getCurElement(int row, int col) {
        return puzzle.getCurElement(row, col);
    }

    public int getMoves() {
        return puzzle.getMoves();
    }

    public void increaseMoves() {
        puzzle.increaseMoves();
    }

    public void decreaseMoves() {
        puzzle.decreaseMoves();
    }

    public void move(int dr, int dc, int collision) {
        puzzle.move(dr,dc,collision);
    }

    public ArrayList<BlueBox> getBoxes() {
        return puzzle.getBoxes();
    }

    public ArrayList<Goal> getGoals() {
        return puzzle.getGoals();
    }

    public ArrayList<State> getStates() {
        return states;
    }

    public State redoState() {
        if(curState<states.size()) {
            state = states.get(curState++);
            return state; // states.get(curState++);
        }
        return null;
    }

    public State undoState() {
        if(curState>0 && states.size()>0) {
            state = states.get(--curState);
            return state; //states.get(--curState);
        } else {
            states.clear();
        }
        return null;
    }

    public void addState(State state) {
        states.add(state);
        ++curState;
    }

    public State getState() {
        return state; // states.get(curState);
    }

    public void deleteStates() {
        states.clear();
        curState = 0;
    }

    public Robot getRobot() {
        return puzzle.getRobot();
    }

    public boolean isWin() {
        return puzzle.isWin();
    }

    public void nextLevel() {
        ++curLevel;

        //if(curLevel==levels.length)
        if(curLevel==levelsList.size())
            curLevel = 0;

        // puzzle = new Puzzle(levels[curLevel], this);
        this.puzzle = new Puzzle(parseLevel(levelsList.get(curLevel).split("\n")), this);//new Puzzle(levels[curLevel], this);
    }

    public void prevLevel() {
        --curLevel;

        if(curLevel<0)
            curLevel = levelsList.size()-1;
        //curLevel = levels.length-1;

        //  puzzle = new Puzzle(levels[curLevel], this);
        this.puzzle = new Puzzle(parseLevel(levelsList.get(curLevel).split("\n")), this);//new Puzzle(levels[curLevel], this);
    }

    //--------------------Experiment----------------------------
    private char[][] parseLevel(String[] strArray) {
        int height = strArray.length;
        int width = 0;

        for(String str : strArray)
            width = Math.max(str.length(), width);

        char[][] level = new char[height][width];

        for(int r=0; r<height; ++r) {
            for (int c = 0; c < width; ++c) {
                level[r][c] = ' ';
            }
        }

        for(int r=0; r<height; ++r) {
            for (int c = 0; c < strArray[r].length(); ++c) {
                level[r][c] = strArray[r].charAt(c);
            }
        }

        return level;
    }
}
