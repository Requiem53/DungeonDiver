package Spells;

import Characters.Character;
import Interfaces.Healing;

public abstract class HealingSpell extends Spell implements Healing {
    int baseAmount;
    public HealingSpell(SpellBuilder builder) {
        super(builder.getName(), builder.getManaCost());
        this.baseAmount = builder.getBaseAmount();
    }

    @Override
    public void heal(Character actor, Character target) {
        int healingTaken = (int)Math.ceil(actor.getMagicPower() * (baseAmount/100f));
//            System.out.println(actor.getName() + " used " + name);
        System.out.println(flavorText(actor, target));
        System.out.println(target.getName() + " was healed by " + healingTaken + " points.");
        target.heal(healingTaken);
    }
}
