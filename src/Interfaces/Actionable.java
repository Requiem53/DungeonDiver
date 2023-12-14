package Interfaces;

import Characters.Character;
import GameSystems.BattleSystem;
import States.State;

import java.util.List;
import java.util.Scanner;

public abstract class Actionable {
    protected String name;

    public abstract String doAction(Character actor, Character target);

    public int getSpeed(){
        return 0;
    }

    public Character chooseTarget(){
        if(this instanceof Damaging) return chooseCharacter(State.randomEnemies);
        else if(this instanceof Healing) return chooseCharacter(State.livingAllies);
        else if(this instanceof StatusInflicting)
            if (((StatusInflicting) this).isBuff()) return chooseCharacter(State.livingAllies);
            else return chooseCharacter(State.randomEnemies);
        return null;
    }
    public List<Character> chooseTargets(){
        if(this instanceof Damaging) return State.randomEnemies;
        else if(this instanceof Healing) return State.livingAllies;
        else if(this instanceof StatusInflicting)
            if (((StatusInflicting) this).isBuff()) return State.livingAllies;
            else return State.randomEnemies;
        return null;
    }

    private Character chooseCharacter(List<Character> characters){
        int actionChoice;
        Scanner sc = new Scanner(System.in);
        System.out.println(BattleSystem.outputCharacters(characters));
        System.out.println("Enter number: ");
        actionChoice = sc.nextInt();
        return characters.get(actionChoice - 1);
    }

    public String toString(){
        return name;
    }
    public String toStringHTML(){
        return toString();
    };
    public String getName(){
        return name;
    }
}
