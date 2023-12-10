package GameSystems;

import Characters.Character;
import Interfaces.*;
import States.*;

import java.util.*;

public class BattleSystem extends StateMachine{
    public User user;
    private final List<Character> characters;
    private int currentTurn = -1;

    List<Action> actions = new ArrayList<>();
    Queue<Action> actionsSorted;

    public BattleSystem(List<Character> characters){
        this.characters = characters;
        setState(new EnterName(this));
    }

    public List<Character> getAllies(){
        List<Character> allies = new ArrayList<>();
        for(Character chara : getCharacters()){
            if(chara instanceof Character.Ally){
                allies.add(chara);
            }
        }
        return allies;
    }

    public List<Character> getEnemies(){
        List<Character> enemies = new ArrayList<>();
        for(Character chara : getCharacters()){
            if(chara instanceof Character.Enemy){
                enemies.add(chara);
            }
        }
        return enemies;
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

    public List<Character> getCharacters() {
        return characters;
    }
    public Character getCurrChar(){
        return characters.get(getCurrentTurn());
    }
    public User getUser(){
        return user;
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
    public boolean currCharIsEnemy(){
        return getCurrChar() instanceof Character.Enemy;
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
}
