package Attacks;

import java.lang.Math;

import Characters.Character;
import Interfaces.Damaging;
import Statuses.Status;

public abstract class Attack implements Damaging {
    private final AttackBuilder builder;

    public Attack(AttackBuilder builder){
        this.builder = builder;
        String name = builder.getName();
        int baseDamage = builder.getBaseDamage();
        int speed = builder.getSpeed();
        //for multiplying amplifier for attack
        int flatAttackBonus = builder.getFlatAttackBonus();
        Status status = builder.getStatus();
    }
    public String getName(){
        return builder.getName();
    }

    @Override
    public void damage(Character actor, Character target) {
        int damageTaken = (int) Math.ceil((actor.getPower() + (builder.getBaseDamage())/100f)) + builder.getFlatAttackBonus();
        System.out.println(actor.getName() + " attacked");
        System.out.println(target.getName() + " received " + damageTaken + " points of damage");
        target.takeDamage(damageTaken);
    }

    public AttackBuilder getBuilder(){
        return builder;
    }
}
