package normal;

import normal.actors.Robot;

public class State {

    public static final int ROBOT = 1;
    public static final int BOX = 2;

    private int dr;
    private int dc;
    private int dir;
    private int type;

    public State(int dr, int dc, int dir) {
        this.dr = Integer.compare(0, dr);
        this.dc = Integer.compare(0, dc);
        this.dir = dir;
    }

    public int getDr() {
        return dr;
    }

    public int getDc() {
        return dc;
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
