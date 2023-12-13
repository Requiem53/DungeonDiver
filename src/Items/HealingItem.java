package Items;

import Characters.Character;
import Interfaces.Healing;

public abstract class HealingItem extends Item implements Healing {
    final int amount;         //flat amount

    public HealingItem(ItemBuilder builder) {
        super(builder);
        this.amount = builder.getAmount();
    }

    public String doAction(Character actor, Character target){
        return flavorText(actor, target) + "\n" +
                heal(actor, target);
    }

    @Override
    public String heal(Character actor, Character target) {
        return target.heal(amount);
    }

    @Override
    public String toString() {
        return name + "[Heal: " + amount + " pts.]";
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

    public static class GreaterHealingPotion extends HealingItem{
        public GreaterHealingPotion() {
            super(new ItemBuilder().setName("Greater Healing Potion").setAmount(100));
        }
        @Override
        public String flavorText(Character actor, Character target) {
            return actor + " used their greater health pot to heal " + target;
        }
    }
}
