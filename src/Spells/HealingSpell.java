package Spells;

import Characters.Character;
import Interfaces.Healing;

public abstract class HealingSpell extends Spell implements Healing {
    int baseAmount;
    public HealingSpell(SpellBuilder builder) {
        super(builder);
        this.baseAmount = builder.getBaseAmount();
    }

    public void doAction(Character actor, Character target) {
        heal(actor, target);
    }

    @Override
    public void heal(Character actor, Character target) {
        int healingTaken = (int)Math.ceil(actor.getMagicPower() * (baseAmount/100f));
        System.out.println(flavorText(actor, target));
        System.out.println(target.getName() + " was healed by " + healingTaken + " points.");
        target.heal(healingTaken);
    }
}
