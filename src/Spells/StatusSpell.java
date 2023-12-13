package Spells;

import Characters.Character;
import Interfaces.StatusInflicting;
import Statuses.Buff;
import Statuses.Status;

public abstract class StatusSpell extends Spell implements StatusInflicting {

    final Status status;
    public StatusSpell(SpellBuilder builder) {
        super(builder);
        this.status = builder.getStatus();
    }

    public void doAction(Character actor, Character target){
        inflictStatus(actor, target);
    }

    @Override
    public void inflictStatus(Character actor, Character target) {
        if(actor == target){
            System.out.println(actor.getName() + " used " + name + " onto himself");
        }else{
            System.out.println(actor.getName() + " used " + name + " onto " + target.getName());
        }

        if(status instanceof Buff){
            System.out.println(target.getName() + " was blessed with " + status);
        }else{
            System.out.println(target.getName() + " was inflicted with " + status);
        }
        target.addStatus(status.clone());
    }

    public boolean isBuff(){
        return this.status instanceof Buff;
    }

    public static class LoyaltyHymn extends StatusSpell{
        public LoyaltyHymn() {
            super(new SpellBuilder().setManaCost(3).setName("Loyalty Hymn").setStatus(new Buff.Loyalty()));
        }

        @Override
        public String flavorText(Character actor, Character target) {
            return actor + " used " + name + " as the loyal protector of their party";
        }
    }

    public static class Shroud_Mist extends StatusSpell{
        public Shroud_Mist(){
            super(new SpellBuilder().setManaCost(5).setName("Shroud Mist").setStatus(new Buff.Shrouded()));
        }

        @Override
        public String flavorText(Character actor, Character target) {
            return actor + " produced a " + name + " to lurk away from the enemies";
        }
    }

    public static class Strength extends StatusSpell{
        public Strength() {
            super(new SpellBuilder().setManaCost(5).setName("Strength").setStatus(new Buff.Brute_Force()));
        }
        @Override
        public String flavorText(Character actor, Character target) {
            return actor + " will now strengthen their teammate's power";
        }
    }
    public static class Wisdom extends StatusSpell{
        public Wisdom(){
            super(new SpellBuilder().setManaCost(5).setName("Wisdom").setStatus(new Buff.Wise()));
        }
        @Override
        public String flavorText(Character actor, Character target) {
            return actor + " will now share knowledge to their teammate";
        }
    }
}
