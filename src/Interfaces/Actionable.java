package Interfaces;

import Characters.Character;

public interface Actionable {
    int getSpeed();
    void doAction(Character actor, Character target);
}
