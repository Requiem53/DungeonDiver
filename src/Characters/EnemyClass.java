package Characters;

import Equipment.Armor;
import Equipment.Weapon;
import Spells.DamagingSpell;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public abstract class EnemyClass extends CharacterClass{
    public EnemyClass(String name, int maxHealth, int power, int speed, int defense, int magicPower) {
        super(name, maxHealth, power, speed, defense, magicPower);
    }



    public static class Goblin extends EnemyClass{
        public Goblin() {
            super("Goblin", 40, 10, 10, 10, 2);
            equipWeapon(new Weapon.Sword());
            equipArmor(new Armor.ClothArmor());

            loadSprites();
        }

        @Override
        public void loadSprites() {
            try {
                sprite = ImageIO.read(Objects.requireNonNull(getClass().
                        getResourceAsStream("/monsters/baragonus.png")));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static class EvilMage extends EnemyClass{
        public EvilMage() {
            super("Evil Mage", 30, 2, 5, 5, 10);
            equipWeapon(new Weapon.Staff());
            equipArmor(new Armor.Elven_Robe());
            addSpell(new DamagingSpell.Meteors());

            loadSprites();
        }

        @Override
        public void loadSprites() {
            try {
                sprite = ImageIO.read(Objects.requireNonNull(getClass().
                        getResourceAsStream("/monsters/blissbird.png")));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static class FinalBoss extends EnemyClass{
        public FinalBoss(){
            super("Final Boss", 1000, 100, 25, 20, 30);
            equipWeapon(new Weapon.Executioner_Blade());
            equipArmor(new Armor.Cleric_Garment());
            addSpell(new DamagingSpell.EndOfTimes());

            loadSprites();
        }

        @Override
        public void loadSprites() {
            try {
                sprite = ImageIO.read(Objects.requireNonNull(getClass().
                        getResourceAsStream("/monsters/bosstroll.png")));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
