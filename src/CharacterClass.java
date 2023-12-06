public class CharacterClass {
    private int maxHealth;
    private int power;
    private int speed;
    private int defense;
    private int magicPower;

    private int currHealth;
    private int currMana;

    public CharacterClass(int maxHealth, int power, int speed, int defense, int magicPower) {
        this.maxHealth = maxHealth;
        this.power = power;
        this.speed = speed;
        this.defense = defense;
        this.magicPower = magicPower;

        this.currHealth = maxHealth;
        this.currMana = magicPower;
    }

    public void takeDamage(int damage){
        currHealth = Math.max(0, currHealth-damage);
    }

    public int attack(Character character){
        character.takeDamage(power);
        return power;
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

    public int getCurrHealth() {
        return currHealth;
    }

    public int getCurrMana() {
        return currMana;
    }

    public static class Warrior extends CharacterClass{
        public Warrior() {
            super(10, 10, 10, 10, 10);
        }
    }
}
