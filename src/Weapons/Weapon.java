package Weapons;

public abstract class Weapon{
    protected String name;
    protected int maxHealth;
    protected int power;
    protected int speed;
    protected int defense;
    protected int magicPower;
    Weapon(WeaponBuilder builder){
        name = builder.getName();
        maxHealth = builder.getMaxHealth();
        power = builder.getPower();
        speed = builder.getSpeed();
        defense = builder.getDefense();
        magicPower = builder.getMagicPower();
    }

    public class Sword extends Weapon{
        Sword(WeaponBuilder builder) {
            super(builder);
        }
    }
    public class Dagger extends Weapon{
        Dagger(WeaponBuilder builder) {
            super(builder);
        }
    }
    public class Wand extends Weapon{
        Wand(WeaponBuilder builder) {
            super(builder);
        }
    }
    public class Staff extends Weapon{
        Staff(WeaponBuilder builder) {
            super(builder);
        }
    }
}