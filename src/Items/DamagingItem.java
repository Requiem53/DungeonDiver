package Items;

import Characters.Character;
import Interfaces.Damaging;

public abstract class DamagingItem extends Item implements Damaging { //In case naa
    int damage;
    DamagingItem(ItemBuilder builder) {
        super(builder);
        this.damage = builder.getDamage();
    }
    @Override
    public void damage(Character actor, Character target) {

    }
}
