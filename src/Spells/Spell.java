package Spells;

import Characters.Character;
import Interfaces.*;
import Statuses.*;

public abstract class Spell{
    public String name;
    int manaCost;
    Spell(String name, int manaCost) {
        this.name = name;
        this.manaCost = manaCost;
    }

    public static class DamagingSpell extends Spell implements Damaging {

        int baseDamage; //actually in percent like baseDamage of 100 is actually 100% of a character's attack or
                        //magic power, not actual damage number

        public DamagingSpell(SpellBuilder builder) {
            super(builder.getName(), builder.getManaCost());
            this.baseDamage = builder.getBaseDamage();
        }

        @Override
        public void damage(Character actor, Character target) {       //Damaging Override
            if(!actor.decreaseMana(manaCost)){
                System.out.println("No more mana"); //TO BE IMPLEMENTED, FOR NOW STILL USE THE SPELL
            }
            int damageTaken = (int)(actor.getMagicPower() * (baseDamage/100f));
            System.out.println(actor.getName() + " used " + name);
            System.out.println(target.getName() + " received " + damageTaken + " magic damage");
            target.takeDamage(damageTaken);
        }

        @Override
        public int getSpeed() {
            return 0;
        }
    }

    public static class HealingSpell extends Spell implements Healing {
        int baseAmount;
        public HealingSpell(SpellBuilder builder) {
            super(builder.getName(), builder.getManaCost());
            this.baseAmount = builder.getBaseAmount();
        }

        @Override
        public void heal(Character actor, Character target) {
            int healingTaken = (int)(actor.getMagicPower() * (baseAmount/100f));
            System.out.println(actor.getName() + " used " + name);
            System.out.println(target.getName() + " was healed by " + healingTaken + " points.");
            target.heal(healingTaken);
        }

        @Override
        public int getSpeed() {
            return 0;
        }
    }

    public static class StatusSpell extends Spell implements StatusInflicting {

        Status status;
        public StatusSpell(SpellBuilder builder) {
            super(builder.getName(), builder.getManaCost());
            this.status = builder.getStatus();
        }

        @Override
        public void inflictStatus(Character actor, Character target) {
            //Implement after Statuses and CharacterClass
        }

        @Override
        public int getSpeed() {
            return 0;
        }
    }
}