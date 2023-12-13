package Spells;

import Characters.Character;
import Interfaces.Healing;

public abstract class HealingSpell extends Spell implements Healing {
    final float baseAmount;
    public HealingSpell(SpellBuilder builder) {
        super(builder);
        this.baseAmount = builder.getBaseAmount();
    }

    public void doAction(Character actor, Character target) {
        heal(actor, target);
    }

    @Override
    public void heal(Character actor, Character target) {
        int healingTaken = (int)Math.ceil(actor.getMagicPower() * baseAmount);
        System.out.println(flavorText(actor, target));
        System.out.println(target.getName() + " was healed by " + healingTaken + " points.");
        target.heal(healingTaken);
    }

    public static class Healing_Pulse extends HealingSpell{
        public Healing_Pulse() {
            super(new SpellBuilder().setName("Healing Pulse").setManaCost(4).setBaseAmount(1));
        }
        @Override
        public String flavorText(Character actor, Character target) {
            return actor + " boosts their team's morale by using " + name;
        }
    }
}
