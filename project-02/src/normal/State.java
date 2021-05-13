package normal;

public class State {
    private int dr;
    private int dc;

    public State(int dr, int dc) {

        this.dr = Integer.compare(0, dr);

        this.dc = Integer.compare(0, dc);
    }

    public int getDr() {
        return dr;
    }

    public int getDc() {
        return dc;
    }

}
