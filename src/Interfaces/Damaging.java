package Interfaces;

import Characters.Character;

public interface Damaging extends ActionType {
    String damage(Character actor, Character target);
}
