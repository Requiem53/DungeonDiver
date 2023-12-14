package Characters;

import Equipment.Armor;
import Equipment.Weapon;
import Items.HealingItem;
import Items.StatusItem;
import Spells.DamagingSpell;
import Spells.HealingSpell;
import Spells.StatusSpell;

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
            equipWeapon(new Weapon.Sword());
            equipArmor(new Armor.KnightsArmor());
        }


        @Override
        public void loadSprites() {

        }
    }
    public static class Rogue extends AllyClass{
        public Rogue() {
            super("Rogue", 25, 20, 15, 10, 10);
            addSpell(new StatusSpell.Shroud_Mist());
            addItem(new HealingItem.HealingPotion());
            addItem(new StatusItem.SmokeBomb());
            equipWeapon(new Weapon.Dagger());
            equipArmor(new Armor.ClothArmor());
        }

        @Override
        public void loadSprites() {

        }
    }

    public static class Mage extends AllyClass{

        public Mage() {
            super("Mage", 30, 5, 12, 10, 25);
            addSpell(new DamagingSpell.Meteors());
            addSpell(new DamagingSpell.IceBeam());
            addItem(new HealingItem.HealingPotion());
            addItem(new StatusItem.SmokeBomb());
            equipWeapon(new Weapon.Wand());
            equipArmor(new Armor.ClothArmor());
        }

        @Override
        public void loadSprites() {

        }
    }
    public static class Healer extends AllyClass{
        public Healer() {
            super("Healer", 40, 5, 14, 10, 20);
            addSpell(new HealingSpell.Healing_Pulse());
            addSpell(new StatusSpell.Strength());
            addSpell(new StatusSpell.Wisdom());
            addItem(new HealingItem.HealingPotion());
            addItem(new HealingItem.HealingPotion());
            equipWeapon(new Weapon.Staff());
            equipArmor(new Armor.KnightsArmor());
        }

        @Override
        public void loadSprites() {

        }
    }
}
