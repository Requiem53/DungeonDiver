package GameSystems;

import Characters.Character;

import java.util.Collections;
import java.util.List;

public class BattleSystem extends StateMachine{
    public User user;
    private List<Character> characters;
    private int currentTurn = -1;

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
    public void turnOrder(){
        Collections.sort(characters);
        System.out.println("Current turn order: ");
        int list = 1;
        for(Character chara : characters){
            System.out.println(list + ". " + chara);
            list++;
        }
        list = 1;
    }

    public void incrementTurn(){
        if(currentTurn+1 > characters.size()-1){
            currentTurn = 0;
        }else {
            currentTurn++;
        }
    }

    public int getCurrentTurn(){
        return currentTurn;
    }

}
