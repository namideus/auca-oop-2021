package normal;

public class State {
    private int dr;
    private int dc;
    private int direction;

    public State(int dr, int dc, int direction) {
        this.dr = dr;
        this.dc = dc;
        this.direction = direction;
    }

    public int getDr() {
        return dr;
    }

    public int getDc() {
        return dc;
    }

    public int getDirection() {
        return direction;
    }
}
