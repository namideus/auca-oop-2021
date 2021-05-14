package normal;

public class PairState {
    private State robotState;
    private State boxState;

    public PairState(State robotState, State boxState) {
        this.robotState = robotState;
        this.boxState = boxState;
    }

    public State getBoxState() {
        return boxState;
    }

    public State getRobotState() {
        return robotState;
    }
}
