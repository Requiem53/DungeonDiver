import java.util.Comparator;
import java.util.List;

public abstract class Character implements Comparable<Character> {
    private String name;

    private int maxHealth;
    private int maxMana;

    private int health;
    private int mana;
    private int power;
    private int speed;

    private boolean isPlayable;
    private Weapon weapon;

    @Override
    public int compareTo(Character o){
        return Integer.compare(o.speed, this.speed);
    }

    public Character(String name, int maxHealth, int maxMana, int power, int speed) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.power = power;
        this.speed = speed;
        health = maxHealth;
        this.maxMana = maxMana;
        mana = maxMana;
    }

    public void currentDetails(){
        System.out.println(name + "\n"
        + "Health: " + " (" + health + "/" + maxHealth + ") \n"
        + "Mana: "  + " (" + mana + "/" + maxMana + ") \n"
        + "Power: " + power + "\n"
        + "Speed: " + speed + "\n"
        );
    }

    public int attack(Character character){
        character.takeDamage(power);
        return power;
    }

    public void takeDamage(int damage){
        health = Math.max(0, health-damage);
    }

    public String toString(){
        return name;
    }

    public void setPlayable(boolean isPlayable){
        this.isPlayable = isPlayable;
    }

    public void equipWeapon(Weapon weapon){
        this.weapon = weapon;
        power += weapon.getPower();
        maxMana += weapon.getMagicPower();
    }

    public static class Ally extends Character{
        public Ally(String name, int maxHealth, int maxMana, int power, int speed) {
            super(name, maxHealth, maxMana, power, speed);
            setPlayable(true);
        }
    }

    public static class Enemy extends Character{
        public Enemy(String name, int maxHealth, int maxMana, int power, int speed) {
            super(name, maxHealth, maxMana, power, speed);
            setPlayable(false);
        }
    }
}
