package Interfaces;

import java.util.Queue;

public class ActionExecutor {
    public void executeAction(Action action){
        action.execute();
    }

    public void executeActions(Queue<Action> actions){
        while (!actions.isEmpty()){
            actions.peek().execute();
            actions.remove();
        }
    }
}
