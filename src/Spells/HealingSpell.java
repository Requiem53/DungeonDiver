package Spells;

import Characters.Character;
import Interfaces.Healing;

public abstract class HealingSpell extends Spell implements Healing {
    final float baseAmount;
    public HealingSpell(SpellBuilder builder) {
        super(builder);
        this.baseAmount = builder.getBaseAmount();
    }

    public String doAction(Character actor, Character target) {
        return flavorText(actor, target) + "\n" +
                heal(actor, target);
    }

    @Override
    public String heal(Character actor, Character target) {
        int healingTaken = (int)Math.ceil(actor.getMagicPower() * baseAmount);
        return target.heal(healingTaken);
    }

    @Override
    public String toString() {
        return super.toString() + "[baseAmount: " + baseAmount + "]";
    }

    @Override
    public String toStringHTML() {
        return "<html>" + super.toString() + "<br/>(baseAmount: " + baseAmount + ")</html>";
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
