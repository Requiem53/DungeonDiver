package Items;

import Characters.Character;
import Interfaces.*;
import Statuses.*;

public class Item{
    String name;
    Item(String name){
        this.name = name;
    }

    public static class DamagingItem extends Item implements Damaging{ //In case naa
        int damage;
        DamagingItem(ItemBuilder builder) {
            super(builder.getName());
            this.damage = builder.getDamage();
        }
        @Override
        public void damage(Character actor, Character target) {

        }

    }
    public static class HealingItem extends Item implements Healing{
        int amount;         //flat amount
        public HealingItem(ItemBuilder builder) {
            super(builder.getName());
            this.amount = builder.getAmount();
        }
        @Override
        public void heal(Character actor, Character target) {
            System.out.println(actor.getName() + " used " + name);
            System.out.println(target.getName() + " was healed by " + amount + " points.");
            target.heal(amount);
        }
    }

    public static class StatusItem extends Item implements StatusInflicting{
        Status status;
        public StatusItem(ItemBuilder builder) {
            super(builder.getName());
            this.status = builder.getStatus();
        }

        @Override
        public void inflictStatus(Character actor, Character target) {
            //To be implemented
        }
    }
}