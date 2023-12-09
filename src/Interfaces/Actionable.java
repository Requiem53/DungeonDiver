package Interfaces;

import Characters.Character;

public interface Actionable {
    default int getSpeed(){
        return 0;
    }
    void doAction(Character actor, Character target);
    String flavorText(Character actor, Character target);
}
