package Interfaces;

import Characters.Character;

public interface StatusInflicting extends ActionType {
        String inflictStatus(Character actor, Character target);
        boolean isBuff();
}
