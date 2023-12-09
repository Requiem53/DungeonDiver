package GameSystems;

import States.State;

public class StateMachine {
    protected State state;

    public void setState(State state){
        this.state = state;
        state.Start();
    }
    public State getState(){
        return state;
    }
}