package Attacks;

import Interfaces.Damaging;

//Normal attack that does as much power as your power
public class NormalAttack extends Attack implements Damaging {

    public NormalAttack(){
        super(new AttackBuilder().setName("Normal Attack"));
    }

    @Override
    public int getSpeed() {
        return getBuilder().getSpeed();
    }
}
