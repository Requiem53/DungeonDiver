package Attacks;

import java.lang.Math;

import Characters.Character;
import Interfaces.Damaging;
import Statuses.Status;

public abstract class Attack implements Damaging {
    private final AttackBuilder builder;

    public Attack(AttackBuilder builder) {
        this.builder = builder;
        String name = builder.getName();
        int baseDamage = builder.getBaseDamage();
        int speed = builder.getSpeed();
        //for multiplying amplifier for attack
        int flatAttackBonus = builder.getFlatAttackBonus();
        Status status = builder.getStatus();
    }

    @Override
    public void damage(Character actor, Character target) {
        System.out.println(flavorText(actor, target));
        System.out.println(target.getName() + " received " + doAttack(actor, target) + " points of damage");
    }

    public abstract String flavorText(Character actor, Character target);

    public int doAttack(Character actor, Character target){
        int damageTaken = (int) Math.ceil((actor.getPower() + (builder.getBaseDamage())/100f)) + builder.getFlatAttackBonus();
        target.takeDamage(damageTaken);

        return damageTaken;
    }

    public AttackBuilder getBuilder(){
        return builder;
    }

    public String getName(){
        return builder.getName();
    }
}
