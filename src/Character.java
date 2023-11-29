import java.util.Comparator;
import java.util.List;

public class Character implements Comparable<Character> {
    private String name;

    private int maxHealth;
    private int maxMana;

    private int health;
    private int mana;
    private int power;
    private int speed;

    private boolean isPlayable;

    @Override
    public int compareTo(Character o){
        return Integer.compare(o.speed, this.speed);
    }

    public Character(String name){
        this.name = name;
        power = 10;
        speed = 10;
        maxHealth = 20;
        health = maxHealth;
        maxMana = 20;
        mana = maxMana;
        isPlayable = false;
    }

    public Character(String name, int maxHealth, int maxMana, int power, int speed, boolean isPlayable) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.power = power;
        this.speed = speed;
        health = maxHealth;
        this.maxMana = maxMana;
        mana = maxMana;
        this.isPlayable = isPlayable;
    }

    public void currentDetails(){
        System.out.println(name + "\n"
        + "Health: " + " (" + health + "/" + maxHealth + ") \n"
        + "Mana: "  + " (" + mana + "/" + maxMana + ") \n"
        + "Power: " + power + "\n"
        + "Speed: " + speed + "\n"
        );
    }

    public void takeDamage(int damage){
        health = Math.max(0, health-damage);
    }

    public String toString(){
        return name;
    }

    public boolean isPlayable(){
        return isPlayable;
    }
}
