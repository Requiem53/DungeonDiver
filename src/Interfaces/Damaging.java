package Interfaces;

import Characters.Character;

public interface Damaging extends ActionType {
    void damage(Character actor, Character target);
}
