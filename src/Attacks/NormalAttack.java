package Attacks;

import Characters.Character;
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

    @Override
    public String flavorText(Character actor, Character target) {
        return actor + " struck " + target + "!";
    }
}
