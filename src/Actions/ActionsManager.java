package Actions;

import java.util.ArrayList;
import java.util.List;


// class to store actions made
// can be used to automate set of moves sa usa ka enemy

public class ActionsManager {
    private List<I_Action> actionList;

    public ActionsManager() {
        actionList = new ArrayList<>();
    }

    public void addAction(I_Action newAction) {
        newAction.execute();
        actionList.add(newAction);
    }
}