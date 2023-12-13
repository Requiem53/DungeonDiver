package Spells;

import Characters.Character;
import Interfaces.Damaging;

public abstract class DamagingSpell extends Spell implements Damaging {
    final float basePower; //multiplier for the caster's MagicPower to determine damage

    public DamagingSpell(SpellBuilder builder) {
        super(builder);
        this.basePower = builder.getBasePower();
    }

    public String doAction(Character actor, Character target){
        if(!actor.decreaseMana(getManaCost())){
            return "No more mana"; //TO BE IMPLEMENTED, FOR NOW STILL USE THE SPELL
        }else{
            damage(actor, target);
            return flavorText(actor, target);
        }
    }

    @Override
    public void damage(Character actor, Character target) {       //Damaging Override
        int damageTaken = (int)Math.ceil(actor.getMagicPower() * basePower);
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
