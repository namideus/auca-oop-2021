package normal;

public class State {
    private int dr;
    private int dc;

    public State(int dr, int dc) {

        if(dr<0) {
            this.dr = 1;
        } else if(dr>0) {
            this.dr = -1;
        } else {
            this.dr = 0;
        }
        if(dc<0) {
            this.dc = 1;
        } else if(dc>0) {
            this.dc = -1;
        } else {
            this.dc = 0;
        }
    }

    public int getDr() {
        return dr;
    }

    public int getDc() {
        return dc;
    }

}
