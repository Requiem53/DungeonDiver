package Interfaces;

import Characters.Character;

public interface Healing extends ActionType {
    @Override
    default void doAction(Character actor, Character target){
        heal(actor, target);
    }

    void heal(Character actor, Character target);
}
