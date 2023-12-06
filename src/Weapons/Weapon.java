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

    public String toString(){
        return getName();
    }

    public String getName() {
        return name;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getPower() {
        return power;
    }

    public int getSpeed() {
        return speed;
    }

    public int getDefense() {
        return defense;
    }

    public int getMagicPower() {
        return magicPower;
    }

    public static class Sword extends Weapon{
        public Sword(WeaponBuilder builder) {
            super(builder.setName("Sword").setPower(10));
        }
    }

    public static class Dagger extends Weapon{
        Dagger(WeaponBuilder builder) {
            super(builder);
        }
    }
    public static class Wand extends Weapon{
        Wand(WeaponBuilder builder) {
            super(builder);
        }
    }
    public static class Staff extends Weapon{
        Staff(WeaponBuilder builder) {
            super(builder);
        }
    }
}