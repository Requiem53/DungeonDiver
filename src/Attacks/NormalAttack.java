package Attacks;

import Characters.Character;
import Interfaces.Damaging;

//Normal attack that does as much power as your power
public class NormalAttack extends Attack implements Damaging {

    public NormalAttack(AttackBuilder builder){
        super(builder.setName("Normal Attack"));
    }

    @Override
    public int getSpeed() {
        return getBuilder().getSpeed();
    }
}
