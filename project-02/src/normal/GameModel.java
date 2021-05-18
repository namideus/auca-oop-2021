package normal;

import normal.actors.BlueBox;
import normal.actors.Goal;
import normal.actors.Robot;

import java.util.ArrayList;

/**
 *
 * @author Iman Augustine
 *
 * Sokoban project game, OOP, 2021
 *
 * instructor: S. Shostak
 *
 * */

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

    public GameModel() {
        //---------------------------------File-IO-------------------------------
        try {
            this.levelsList = Parser.readLevelsFromFile("levels/MiniCosmos.txt");
            this.curLevel = 0;
            this.puzzle = new Puzzle(Parser.parseLevel(levelsList.get(curLevel)), this);
            this.states = new ArrayList<>();
        } catch(Exception e) {
            System.out.println(e.getMessage());
            System.exit(2);
        }
    }

    public void resetCurrentPuzzle() {
        this.puzzle = new Puzzle(Parser.parseLevel(levelsList.get(curLevel)), this);
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

    public ArrayList<String> getLevelsList() {
        return levelsList;
    }

    public int getLevelsSize() {
        return levelsList.size();
    }

    // Redo state
    public State redoState() {
        if(curState<states.size()) {
            state = states.get(curState++);
            return state;
        }
        return null;
    }

    public State undoState() {
        if(curState>0 && states.size()>0) {
            state = states.get(--curState);
            return state;
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
        return state;
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

        if(curLevel==levelsList.size())
            curLevel = 0;

        this.puzzle = new Puzzle(Parser.parseLevel(levelsList.get(curLevel)), this);
    }

    public void prevLevel() {
        --curLevel;

        if(curLevel<0)
            curLevel = levelsList.size()-1;

        this.puzzle = new Puzzle(Parser.parseLevel(levelsList.get(curLevel)), this);
    }
}
