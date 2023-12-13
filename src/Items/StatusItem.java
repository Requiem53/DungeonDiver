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

    public String doAction(Character actor, Character target){
        return flavorText(actor, target) + "\n" +
                inflictStatus(actor, target);
    }

    @Override
    public String inflictStatus(Character actor, Character target) {
        StringBuilder string = new StringBuilder();
        if(actor == target){
            string.append(actor.getName()).append(" used ").append(name).append("onto himself").append("\n");
        }else{
            string.append(actor.getName()).append(" used ").append(name).append("onto ").append(target.getName()).append("\n");
        }

        if(status instanceof Buff){
            string.append(target.getName()).append(" was blessed with ").append(status);
        }else{
            string.append(target.getName()).append(" was inflicted with ").append(status);
        }
        target.addStatus(status.clone());

        return string.toString();
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
