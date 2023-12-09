package Items;

import Characters.Character;
import Interfaces.StatusInflicting;
import Statuses.Buff;
import Statuses.Status;

public abstract class StatusItem extends Item implements StatusInflicting {
    Status status;
    public StatusItem(ItemBuilder builder) {
        super(builder.getName());
        this.status = builder.getStatus();
    }

    @Override
    public void inflictStatus(Character actor, Character target) {
        //To be implemented
    }

    public static class SmokeBomb extends StatusItem{
        public SmokeBomb(ItemBuilder builder) {
            super(builder.setName("Smoke Bomb").setStatus(new Buff()));
        }

        @Override
        public String flavorText(Character actor, Character target) {
            return actor + " threw the smoke bomb on the ground!";
        }
    }
}
