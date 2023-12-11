package Items;

import Characters.Character;
import Interfaces.Healing;

public abstract class HealingItem extends Item implements Healing {
    int amount;         //flat amount

    public HealingItem(ItemBuilder builder) {
        super(builder);
        this.amount = builder.getAmount();
    }

    public void doAction(Character actor, Character target){
        heal(actor, target);
    }

    @Override
    public void heal(Character actor, Character target) {
        System.out.println(flavorText(actor, target));
        System.out.println(target.getName() + " was healed by " + amount + " points.");
        target.heal(amount);
    }

    public static class HealingPotion extends HealingItem{
        public HealingPotion() {
            super(new ItemBuilder().setName("Health Potion").setAmount(50));
        }
        @Override
        public String flavorText(Character actor, Character target) {
            return actor + " used their health pot to heal " + target;
        }
    }
}
