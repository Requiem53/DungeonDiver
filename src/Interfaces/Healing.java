package Interfaces;

import Characters.Character;

public interface Healing extends ActionType {
    String heal(Character actor, Character target);
}
