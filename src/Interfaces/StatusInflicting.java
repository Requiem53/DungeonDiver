package Interfaces;

import Characters.Character;

public interface StatusInflicting extends Move{
    @Override
    default void doMove(Character receiver){
        this.inflictStatus(receiver);
    }
    void inflictStatus(Character receiver);
}
