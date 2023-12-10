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
        float basePower = builder.getBasePower();
        int speed = builder.getSpeed();
        int flatAttackBonus = builder.getFlatAttackBonus();
        Status status = builder.getStatus();
    }

    @Override
    public void damage(Character actor, Character target) {
        System.out.println(flavorText(actor, target));
        //TEST
        int damageTaken = (int) Math.ceil(actor.getPower() + builder.getBasePower()) + builder.getFlatAttackBonus();
        target.takeDamage(damageTaken);
    }

    public String toString(){
        return getName();
    }

//    public int doAttack(Character actor, Character target){  //transfered functionality into damage() above
//        int damageTaken = (int) Math.ceil(actor.getPower() + builder.getBasePower()) + builder.getFlatAttackBonus();
//        target.takeDamage(damageTaken);
//
//        return damageTaken;
//    }

    public AttackBuilder getBuilder(){
        return builder;
    }

    public String getName(){
        return builder.getName();
    }

    public static class NormalAttack extends Attack{
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

    public static class StrongAttack extends Attack{
        public StrongAttack(){
            super(new AttackBuilder().setName("Strong Attack").setBasePower(1.5f).setSpeed(-20));
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
}
