package Weapons;

public class WeaponBuilder {
    private String name;
    private int maxHealth;
    private int power;
    private int speed;
    private int defense;
    private int magicPower;

    public WeaponBuilder(){ //set everything to 0 default
        name = "MissingWeapon";
        maxHealth = 0;
        power = 0;
        speed = 0;
        defense = 0;
        magicPower = 0;
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

    WeaponBuilder setName(String name){
        this.name = name;
        return this;
    }

    WeaponBuilder setMaxHealth(int maxHealth){
        this.maxHealth = maxHealth;
        return this;
    }
    WeaponBuilder setPower(int power){
        this.power = power;
        return this;
    }
    WeaponBuilder setSpeed(int speed){
        this.speed = speed;
        return this;
    }
    WeaponBuilder setDefense(int defense){
        this.defense = defense;
        return this;
    }
    WeaponBuilder setMagicPower(int magicPower){
        this.magicPower = magicPower;
        return this;
    }
}
