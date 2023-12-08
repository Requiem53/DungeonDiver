package GameSystems;

import Characters.Character;
import Interfaces.*;

import java.util.*;

public class BattleSystem extends StateMachine{
    public User user;
    private List<Character> characters;
    private int currentTurn = -1;
    List<Action> actions = new ArrayList<>();
    Queue<Action> actionsSorted;

    public BattleSystem(List<Character> characters){
        this.characters = characters;
        setState(new State.EnterName(this));
    }
    public List<Character> getCharacters() {
        return characters;
    }
    public User getUser(){
        return user;
    }
//    public void turnOrder(){
//        Collections.sort(characters);
//        System.out.println("Current turn order: ");
//        int list = 1;
//        for(Character chara : characters){
//            System.out.println(list + ". " + chara);
//            list++;
//        }
//        list = 1;
//    }

    public void incrementTurn(){
        currentTurn++;
    }
    public void resetTurn(){
        currentTurn = 0;
    }

    public int getCurrentTurn(){
        return currentTurn;
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
}
