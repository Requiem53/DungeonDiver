package Equipment;

public class Equippable {
    protected String name;
    protected int maxHealth;
    protected int power;
    protected int speed;
    protected int defense;
    protected int magicPower;
    protected float evasion;

    Equippable(EquippableBuilder builder){
        name = builder.getName();
        maxHealth = builder.getMaxHealth();
        power = builder.getPower();
        speed = builder.getSpeed();
        defense = builder.getDefense();
        magicPower = builder.getMagicPower();
        evasion = builder.getEvasion();
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

    public float getEvasion() {
        return evasion;
    }
}
