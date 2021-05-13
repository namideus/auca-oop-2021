package normal;

public class State {

    private int dr;
    private int dc;
    private int dir;

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
