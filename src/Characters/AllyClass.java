package Characters;

import Items.HealingItem;
import Items.StatusItem;
import Spells.DamagingSpell;
import Spells.StatusSpell;

import java.util.List;

public abstract class AllyClass extends CharacterClass{
    //Himo ug scaling class creator chuchu
    public AllyClass(String name, int maxHealth, int power, int speed, int defense, int magicPower) {
        super(name, maxHealth, power, speed, defense, magicPower);
    }

    public static class Warrior extends AllyClass{
        public Warrior() {
            super("Warrior", 50, 25, 10, 10, 10);
            addSpell(new StatusSpell.LoyaltyHymn());
            addItem(new HealingItem.HealingPotion());
            addItem(new HealingItem.HealingPotion());
        }
    }
    public static class Mage extends AllyClass{

        public Mage() {
            super("Mage", 40, 10, 15, 10, 25);
            addSpell(new DamagingSpell.Meteors());
            addSpell(new DamagingSpell.IceBeam());
            addItem(new HealingItem.HealingPotion());
            addItem(new StatusItem.SmokeBomb());
        }
    }
}
