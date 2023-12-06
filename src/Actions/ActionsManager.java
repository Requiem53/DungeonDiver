package Actions;

import java.util.Stack;


// class to store actions made
// can be used to automate set of moves sa usa ka enemy
public class ActionsManager {
    private Stack<I_Action> actionList;

    public ActionsManager() {
        actionList = new Stack<>();
    }

    public void addAction(I_Action newAction) {
        newAction.execute();
        actionList.push(newAction);
    }
}
