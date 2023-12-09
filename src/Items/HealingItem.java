package Items;

import Characters.Character;
import Interfaces.Healing;

public abstract class HealingItem extends Item implements Healing {
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

    public static class HealingPotion extends HealingItem{
        public HealingPotion(ItemBuilder builder) {
            super(builder.setName("Health Potion").setAmount(50));
        }
    }
}
