package Attacks;

import Characters.Character;
import Interfaces.Damaging;

public class StrongAttack extends Attack implements Damaging {

    public StrongAttack(AttackBuilder builder){
        super(builder.setName("Strong Attack").setBaseMultiDamage(1.5f).setSpeed(-20));
    }
    @Override
    public int getSpeed() {
        return getBuilder().getSpeed();
    }
}
