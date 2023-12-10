package Interfaces;

import Characters.Character;

public interface Damaging extends ActionType {
    @Override
    default void doAction(Character actor, Character target){
        damage(actor, target);
    }

    void damage(Character actor, Character target);
}
