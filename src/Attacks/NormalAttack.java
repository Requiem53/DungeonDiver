package Attacks;

import Characters.Character;
import Interfaces.Damaging;

//Normal attack that does as much power as your power
public class NormalAttack implements Damaging {
    @Override
    public void damage(Character actor, Character target) {
        int damageTaken = actor.getPower();
        System.out.println(actor.getName() + " attacked");
        System.out.println(target.getName() + " received " + damageTaken + " points of damage");
        target.takeDamage(damageTaken);
    }
}
