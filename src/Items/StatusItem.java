package Items;

import Characters.Character;
import Interfaces.StatusInflicting;
import Statuses.Buff;
import Statuses.Status;

public abstract class StatusItem extends Item implements StatusInflicting {
    final Status status;

    public StatusItem(ItemBuilder builder) {
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

    @Override
    public String toString() {
        return name + "[Heal: " + status + "]";
    }
    public static class SmokeBomb extends StatusItem{
        public SmokeBomb() {
            super(new ItemBuilder().setName("Smoke Bomb").setStatus(new Buff.Shrouded()));
        }

        @Override
        public String flavorText(Character actor, Character target) {
            return actor + " threw the smoke bomb on the ground!";
        }
    }
    public static class HealthPlus extends StatusItem{
        public HealthPlus() {
            super(new ItemBuilder().setName("Health Plus").setStatus(new Buff.Vitality()));
        }
        @Override
        public String flavorText(Character actor, Character target) {
            return actor + " used the latest vitamin Health Plus";
        }
    }
}
