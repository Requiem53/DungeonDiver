package Spells;

import Characters.Character;
import Interfaces.*;
import Statuses.*;

public abstract class Spell {
    Character user;
    String name;
    int manaCost;
    Spell(Character user, String name, int manaCost){
        this.user = user;
        this.name = name;
        this.manaCost = manaCost;
    }

    public class DamagingSpell extends Spell implements Damaging {

        int baseDamage; //actually in percent like baseDamage of 100 is actually 100% of a character's attack or
                        //magic power, not actual damage number

        DamagingSpell(SpellBuilder builder) {
            super(builder.getUser(), builder.getName(), builder.getManaCost());
            this.baseDamage = builder.getBaseDamage();
        }

        @Override
        public void damage(Character receiver) {
            receiver.takeDamage(user.getMagicPower() * (baseDamage/100));
        }
    }

    public class HealingSpell extends Spell implements Healing {
        int baseAmount;
        HealingSpell(SpellBuilder builder) {
            super(builder.getUser(), builder.getName(), builder.getManaCost());
            this.baseAmount = builder.getBaseAmount();
        }

        @Override
        public void heal(Character receiver) {
            receiver.heal(user.getMagicPower() * (baseAmount/100));
        }
    }

    public class StatusSpell extends Spell implements StatusInflicting {

        Status status;
        StatusSpell(SpellBuilder builder) {
            super(builder.getUser(), builder.getName(), builder.getManaCost());
            this.status = builder.getStatus();
        }

        @Override
        public void inflictStatus(Character receiver) {
            //Implement after Statuses and CharacterClass
        }
    }
}