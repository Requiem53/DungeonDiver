package Characters;

import Equipment.Armor;
import Equipment.Weapon;
import Spells.DamagingSpell;

public abstract class EnemyClass extends CharacterClass{

    public EnemyClass(String name, int maxHealth, int power, int speed, int defense, int magicPower) {
        super(name, maxHealth, power, speed, defense, magicPower);
    }

    public static class Goblin extends EnemyClass{
        public Goblin() {
            super("Goblin", 40, 10, 10, 10, 2);
            equipWeapon(new Weapon.Sword());
            equipArmor(new Armor.ClothArmor());
        }
    }

    public static class EvilMage extends EnemyClass{
        public EvilMage() {
            super("Evil Mage", 30, 2, 5, 5, 10);
            equipWeapon(new Weapon.Staff());
            equipArmor(new Armor.Elven_Robe());
            addSpell(new DamagingSpell.Meteors());
        }
    }

    public static class FinalBoss extends EnemyClass{
        public FinalBoss(){
            super("Final Boss", 1000, 100, 25, 20, 30);
            equipWeapon(new Weapon.Executioner_Blade());
            equipArmor(new Armor.Cleric_Garment());
            addSpell(new DamagingSpell.EndOfTimes());
        }
    }
}
