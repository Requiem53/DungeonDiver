public class StateMachine {
    protected State state;

    public void setState(State state){
        this.state = state;
        state.Start();
    }
}
