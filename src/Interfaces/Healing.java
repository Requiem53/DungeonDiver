package Interfaces;

import Characters.Character;

public interface Healing extends Move{
    @Override
    default void doMove(Character receiver){
        this.heal(receiver);
    }
    void heal(Character receiver);
}
