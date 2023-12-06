package Equipment;

public class EquippableBuilder {
    private String name;
    private int maxHealth;
    private int power;
    private int speed;
    private int defense;
    private int magicPower;

    public EquippableBuilder(){ //set everything to 0 default
        name = "MissingEquipment";
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

    EquippableBuilder setName(String name){
        this.name = name;
        return this;
    }

    EquippableBuilder setMaxHealth(int maxHealth){
        this.maxHealth = maxHealth;
        return this;
    }
    EquippableBuilder setPower(int power){
        this.power = power;
        return this;
    }
    EquippableBuilder setSpeed(int speed){
        this.speed = speed;
        return this;
    }
    EquippableBuilder setDefense(int defense){
        this.defense = defense;
        return this;
    }
    EquippableBuilder setMagicPower(int magicPower){
        this.magicPower = magicPower;
        return this;
    }
}
