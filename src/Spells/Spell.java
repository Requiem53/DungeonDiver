package Spells;

import Characters.Character;
import Characters.CharacterClass;
import Interfaces.*;
import Statuses.*;

public abstract class Spell {
    CharacterClass user;
    public String name;
    int manaCost;
    Spell(CharacterClass user, String name, int manaCost){
        this.user = user;
        this.name = name;
        this.manaCost = manaCost;
    }

    public static class DamagingSpell extends Spell implements Damaging {

        int baseDamage; //actually in percent like baseDamage of 100 is actually 100% of a character's attack or
                        //magic power, not actual damage number

        public DamagingSpell(SpellBuilder builder) {
            super(builder.getUser(), builder.getName(), builder.getManaCost());
            this.baseDamage = builder.getBaseDamage();
        }

        @Override
        public void damage(Character receiver) {
            int damageTaken = (int)(user.getMagicPower() * (baseDamage/100f));
            System.out.println(user.chara.getName() + " used " + name);
            System.out.println(receiver.getName() + " received " + damageTaken + " magic damage");
            receiver.takeDamage(damageTaken);
        }
    }

    public static class HealingSpell extends Spell implements Healing {
        int baseAmount;
        public HealingSpell(SpellBuilder builder) {
            super(builder.getUser(), builder.getName(), builder.getManaCost());
            this.baseAmount = builder.getBaseAmount();
        }

        @Override
        public void heal(Character receiver) {
            receiver.heal(user.getMagicPower() * (baseAmount/100));
        }
    }

    public static class StatusSpell extends Spell implements StatusInflicting {

        Status status;
        public StatusSpell(SpellBuilder builder) {
            super(builder.getUser(), builder.getName(), builder.getManaCost());
            this.status = builder.getStatus();
        }

        @Override
        public void inflictStatus(Character receiver) {
            //Implement after Statuses and CharacterClass
        }
    }
}