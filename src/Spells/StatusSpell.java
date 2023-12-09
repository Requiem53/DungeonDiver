package Spells;

import Characters.Character;
import Interfaces.StatusInflicting;
import Statuses.Buff;
import Statuses.Status;

public abstract class StatusSpell extends Spell implements StatusInflicting {

    Status status;
    public StatusSpell(SpellBuilder builder) {
        super(builder.getName(), builder.getManaCost());
        this.status = builder.getStatus();
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

    public static class LoyaltyHymn extends StatusSpell{
        public LoyaltyHymn() {
            super(new SpellBuilder().setName("Loyalty Hymn").setStatus(new Buff.Loyalty()));
        }

        @Override
        public String flavorText(Character actor, Character target) {
            return actor + " used " + name + " to ambot!"; // wa ko kahibaw sa effect sorry
        }
    }
}
