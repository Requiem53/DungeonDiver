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
            return flavorText(actor, target) + "\n" +
                damage(actor, target);
        }
    }

    @Override
    public String damage(Character actor, Character target) {       //Damaging Override
        int damageTaken = (int)Math.ceil(actor.getMagicPower() * basePower);
        return target.takeDamage(damageTaken);
    }

    @Override
    public String toString() {
        return super.toString() + "[basePower: " + basePower + "]";
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

    public static class Hyper_Beam extends DamagingSpell{
        public Hyper_Beam() {
            super(new SpellBuilder().setName("Hyper beam").setManaCost(15).setBasePower(1.6f));
        }
        @Override
        public String flavorText(Character actor, Character target) {
            return actor + " definitely not just used the pokemon move Hyper Beam";
        }
    }

    public static class Celestial_Ray extends DamagingSpell{
        public Celestial_Ray() {
            super(new SpellBuilder().setName("Celestial Ray").setManaCost(20).setBasePower(2.0f));
        }

        @Override
        public String flavorText(Character actor, Character target) {
            return actor + " used the pinnacle of magic with 2.0 base Power, so powerful!";
        }
    }
}
