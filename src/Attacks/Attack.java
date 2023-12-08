package Attacks;

import Characters.Character;
import Interfaces.Damaging;

public class Attack implements Damaging {
    @Override
    public void damage(Character actor, Character target) {
        int damageTaken = actor.getPower();
        System.out.println(actor.getName() + " attacked");
        System.out.println(target.getName() + " received " + damageTaken + " points of damage");
        target.takeDamage(damageTaken);
    }
}
