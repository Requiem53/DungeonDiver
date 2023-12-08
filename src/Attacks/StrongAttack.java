package Attacks;

import Interfaces.Damaging;

public class StrongAttack extends Attack implements Damaging {

    public StrongAttack(){
        super(new AttackBuilder().setName("Strong Attack").setBaseDamage(150).setSpeed(-20));
    }
    @Override
    public int getSpeed() {
        return getBuilder().getSpeed();
    }
}
