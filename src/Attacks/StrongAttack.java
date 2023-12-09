package Attacks;

import Characters.Character;
import Interfaces.Damaging;

public class StrongAttack extends Attack implements Damaging {

    public StrongAttack(){
        super(new AttackBuilder().setName("Strong Attack").setBaseDamage(150).setSpeed(-20));
    }
    @Override
    public int getSpeed() {
        return getBuilder().getSpeed();
    }

    @Override
    public String flavorText(Character actor, Character target) {
        return actor + " lunges forward to deal a heavy blow!";
    }
}
