package Interfaces;

import Characters.Character;

public interface Healing extends ActionType {
    void heal(Character actor, Character target);
}
