package Equipment;

public class EquippableBuilder {
    private String name;
    private int maxHealth;
    private int power;
    private int speed;
    private int defense;
    private int magicPower;
    private float evasion;

    public EquippableBuilder(){ //set everything to 0 default
        name = "MissingEquipment";
        maxHealth = 0;
        power = 0;
        speed = 0;
        defense = 0;
        magicPower = 0;
        evasion = 0;
    }

    String getName() {
        return name;
    }
    int getMaxHealth() {
        return maxHealth;
    }
    int getPower() {
        return power;
    }
    int getSpeed() {
        return speed;
    }
    int getDefense() {
        return defense;
    }
    int getMagicPower() {
        return magicPower;
    }

    public float getEvasion() {
        return evasion;
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

    EquippableBuilder setEvasion(float evasion) {
        this.evasion = evasion;
        return this;
    }
}
