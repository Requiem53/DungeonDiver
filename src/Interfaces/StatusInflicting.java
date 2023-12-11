package Interfaces;

import Characters.Character;

public interface StatusInflicting extends ActionType {
        void inflictStatus(Character actor, Character target);
        boolean isBuff();
}
