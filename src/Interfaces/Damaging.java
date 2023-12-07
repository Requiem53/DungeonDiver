package Interfaces;

import Characters.Character;

public interface Damaging extends Move{
    @Override
    default void doMove(Character receiver){
        this.damage(receiver);
    }
    void damage(Character receiver);
}
