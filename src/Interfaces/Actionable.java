package Interfaces;

import Characters.Character;
import GameSystems.BattleSystem;
import States.State;

import java.util.List;
import java.util.Scanner;

public abstract class Actionable {
    protected String name;

    public abstract void doAction(Character actor, Character target);

    public String toString(){
        return name;
    }

    public String getName(){
        return name;
    }

    public int getSpeed(){
        return 0;
    }

    public Character chooseTarget(){
        if(this instanceof Damaging) return chooseCharacter(State.getRandomEnemies());
        else if(this instanceof Healing) return chooseCharacter(State.getLivingAllies());
        else if(this instanceof StatusInflicting)
            if (((StatusInflicting) this).isBuff()) return chooseCharacter(State.getLivingAllies());
            else return chooseCharacter(State.getRandomEnemies());
        return null;
    }

    private Character chooseCharacter(List<Character> characters){
        int actionChoice;
        Scanner sc = new Scanner(System.in);
        BattleSystem.outputCharacters(characters);
        System.out.println("Enter number: ");
        actionChoice = sc.nextInt();

        return characters.get(actionChoice - 1);
    }
}
