package Attacks;

import java.lang.Math;

import Characters.Character;
import Interfaces.Actionable;
import Interfaces.Damaging;
import Statuses.Status;

public abstract class Attack extends Actionable implements Damaging {
    private final AttackBuilder builder;

    float basePower;
    int speed;
    int flatAttackBonus;
    Status status;

    public Attack(AttackBuilder builder) {
        this.builder = builder;
        name = builder.getName();
        basePower = builder.getBasePower();
        speed = builder.getSpeed();
        flatAttackBonus = builder.getFlatAttackBonus();
        status = builder.getStatus();
    }

    public String doAction(Character actor, Character target){
        return flavorText(actor, target) + "\n" +
                 damage(actor, target);
    }

    @Override
    public String damage(Character actor, Character target) {
        int damageTaken = totalPower(actor);
        return target.takeDamage(damageTaken);
    }

    public AttackBuilder getBuilder(){
        return builder;
    }

    public int totalPower(Character actor){
        return (int) Math.ceil((actor.getPower() + builder.getFlatAttackBonus()) * builder.getBasePower());
    }

    public static class NormalAttack extends Attack{
        public NormalAttack(){
            super(new AttackBuilder().setName("Normal Attack"));
        }

        @Override
        public int getSpeed() {
            return speed;
        }

        @Override
        public String flavorText(Character actor, Character target) {
            return actor + " struck " + target + "!";
        }
    }

    public static class QuickAttack extends Attack{
        public QuickAttack(){
            super(new AttackBuilder().setName("Quick Attack").setBasePower(0.5f).setSpeed(100));
        }

        @Override
        public int getSpeed() {
            return speed;
        }

        @Override
        public String flavorText(Character actor, Character target) {
            return actor + " struck " + target + "!";
        }
    }

    public static class StrongAttack extends Attack{
        public StrongAttack(){
            super(new AttackBuilder().setName("Strong Attack").setBasePower(1.5f).setSpeed(-100));
        }
        @Override
        public int getSpeed() {
            return speed;
        }

        @Override
        public String flavorText(Character actor, Character target) {
            return actor + " lunges forward to deal a heavy blow!";
        }
    }
}
