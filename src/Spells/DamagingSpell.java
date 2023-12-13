package Spells;

import Characters.Character;
import Interfaces.Damaging;

public abstract class DamagingSpell extends Spell implements Damaging {
    final float basePower; //multiplier for the caster's MagicPower to determine damage

    public DamagingSpell(SpellBuilder builder) {
        super(builder);
        this.basePower = builder.getBasePower();
    }

    public void doAction(Character actor, Character target){
        damage(actor, target);
    }

    @Override
    public void damage(Character actor, Character target) {       //Damaging Override
        if(!actor.decreaseMana(getManaCost())){
            System.out.println("No more mana"); //TO BE IMPLEMENTED, FOR NOW STILL USE THE SPELL
        }
        int damageTaken = (int)Math.ceil(actor.getMagicPower() * basePower);
//        System.out.println(actor.getName() + " used " + name);
        System.out.println(flavorText(actor, target));
        target.takeDamage(damageTaken);
    }

    public static class Meteors extends DamagingSpell{
        public Meteors(){
            super(new SpellBuilder().setName("Meteors").setManaCost(10).setBasePower(1.2f));
        }

        @Override
        public String flavorText(Character actor, Character target) {
            return actor + " invoked the power of the Gods to bring down meteors from the sky!";
        }
    }

    public static class IceBeam extends DamagingSpell{
        public IceBeam(){
            super(new SpellBuilder().setName("Ice beam").setManaCost(5).setBasePower(0.9f));
        }
        @Override
        public String flavorText(Character actor, Character target) {
            return "From the cold in the north, " + actor + " casted Ice Beam!";
        }
    }
}
