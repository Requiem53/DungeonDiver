package GameSystems;

import Characters.Character;
import Characters.Party;
import Interfaces.*;
import States.*;

import java.util.*;

public class BattleSystem extends StateMachine{
    public User user;
    private int currentTurn = -1;

    private Party party;

    List<Action> actions = new ArrayList<>();
    Queue<Action> actionsSorted;

    public BattleSystem(){
        party = new Party();
        setState(new EnterName(this));
    }

    public static void outputCharacters(List<Character> characters){
        for(int i=0; i < characters.size(); i++){
            System.out.println(i+1 + ". " + characters.get(i));
        }
    }

    public void addAction(Action action){
        actions.add(action);
    }
    public void sortActions(){
        Collections.sort(actions);
        actionsSorted = new LinkedList<>(actions);
    }
    public Action dequeueActionsSorted(){
        if(actionsSorted.isEmpty()){
            return null;
        }
        return actionsSorted.remove();
    }
    public void actionListsReset(){
        actions.clear();
        actionsSorted.clear();
        currentTurn = -1;
    }
    public void incrementTurn(){
        currentTurn++;
    }
    public int getCurrentTurn(){
        return currentTurn;
    }
    public boolean currCharIsAlly(){
        return getCurrChar() instanceof Character.Ally;
    }

    //Getters
    public Queue<Action> getActionsSorted() {
        return actionsSorted;
    }
    public Character getCurrChar(){
        return getPartyMembers().get(getCurrentTurn());
    }
    public User getUser(){
        return user;
    }
    public Party getParty() {
        return party;
    }
    public ArrayList<Character> getPartyMembers(){
        return getParty().getParty();
    }
}
