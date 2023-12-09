package Spells;

import Characters.Character;
import Interfaces.Damaging;
import Statuses.Buff;

public abstract class DamagingSpell extends Spell implements Damaging {

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
        int damageTaken = (int)Math.ceil(actor.getMagicPower() * (baseDamage/100f));
//        System.out.println(actor.getName() + " used " + name);
        System.out.println(flavorText(actor, target));
        System.out.println(target.getName() + " received " + damageTaken + " magic damage");
        target.takeDamage(damageTaken);
    }

    public static class LoyaltyHymn extends DamagingSpell{
        public LoyaltyHymn(SpellBuilder builder) {
            super(builder.setName("Loyalty Hymn").setStatus(new Buff()));
        }

        @Override
        public String flavorText(Character actor, Character target) {
            return actor + " used " + name + " to ambot!"; // wa ko kahibaw sa effect sorry
        }
    }

    public static class Meteors extends DamagingSpell{
        public Meteors(SpellBuilder builder){
            super(builder.setName("Meteors").setManaCost(5).setBaseDamage(90));
        }

        @Override
        public String flavorText(Character actor, Character target) {
            return actor + " invoked the power of the Gods to bring down meteors from the sky!";
        }
    }

    public static class IceBeam extends DamagingSpell{
        public IceBeam(SpellBuilder builder){
            super(builder.setName("Ice beam").setManaCost(5).setBaseDamage(90));
        }
        @Override
        public String flavorText(Character actor, Character target) {
            return "From the cold in the north, " + actor + " casted Ice Beam!";
        }
    }
}
