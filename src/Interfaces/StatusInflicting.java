package Interfaces;

import Characters.Character;

public interface StatusInflicting extends ActionType {
    @Override
    default void doAction(Character actor, Character target){
        inflictStatus(actor, target);
    }

    void inflictStatus(Character actor, Character target);
}
