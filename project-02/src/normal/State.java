package normal;

import normal.actors.Robot;

public class State {

    public static final int ROBOT = 1;
    public static final int BOX = 2;

    private int dr;
    private int dc;
    private int dir;
    private int boxId = -1;
    private boolean hasMovedBox;

    public State(int dr, int dc, int dir) {
        this.dr = Integer.compare(0, dr);
        this.dc = Integer.compare(0, dc);
        this.dir = dir;
        this.hasMovedBox = false;
    }

    public State(int robotDr, int robotDc, int dir, int boxId) {
        this.dr = Integer.compare(0, robotDr);
        this.dc = Integer.compare(0, robotDc);
        this.dir = dir;
        this.boxId = boxId;
        this.hasMovedBox = true;
    }

    public int getDr() {
        return dr;
    }

    public int getDc() {
        return dc;
    }

    public int getBoxId() {
        return boxId;
    }

    public void setBoxId(int boxId) {
        this.boxId = boxId;
    }

    public boolean isHasMovedBox() {
        return hasMovedBox;
    }

    public void setHasMovedBox(boolean hasMovedBox) {
        this.hasMovedBox = hasMovedBox;
    }

    public void setRobot(Robot robot) {
        switch(dir) {
            case GameModel.LEFT_COLLISION:
                robot.setLeft();
                break;
            case GameModel.RIGHT_COLLISION:
                robot.setRight();
                break;
            case GameModel.TOP_COLLISION:
                robot.setUp();
                break;
            case GameModel.BOTTOM_COLLISION:
                robot.setDown();
                break;
        }
    }
}
