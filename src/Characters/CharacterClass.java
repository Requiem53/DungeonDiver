package Characters;

import CharacterComponents.DoableActions;
import Spells.*;
import Statuses.*;
import Attacks.*;
import Items.*;

import java.util.ArrayList;
import java.util.List;

public abstract class CharacterClass {
    private int maxHealth;
    private int power;
    private int speed;
    private int defense;
    private int magicPower;
    private float evasion;
    private int currHealth;
    private int currMana;

    private final DoableActions initialActions;
    private List<Status> statuses;

    public CharacterClass(int maxHealth, int power, int speed, int defense, int magicPower) {

        this.maxHealth = maxHealth;
        this.power = power;
        this.speed = speed;
        this.defense = defense;
        this.magicPower = magicPower;
        this.evasion = 1f;

        this.currHealth = maxHealth;
        this.currMana = magicPower;

        ArrayList<Attack> attacks = new ArrayList<>(){{
            add(new Attack.NormalAttack());
            add(new Attack.StrongAttack());
        }};

        ArrayList<Spell> spells = new ArrayList<>();
        ArrayList<Item> items = new ArrayList<>();

        initialActions = new DoableActions(attacks, spells, items);
        statuses = new ArrayList<>();
    }

    public DoableActions getInitialActions(){
        return initialActions;
    }

    public void takeDamage(int damage){
        currHealth = Math.max(0, currHealth-damage);
    }

    public void heal(int amount){
        currHealth = Math.max(maxHealth, currHealth+amount);
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
    public float getEvasion(){
        return evasion;
    }

    public int getCurrHealth() {
        return currHealth;
    }

    public int getCurrMana() {
        return currMana;
    }
    public List<Status> getStatuses(){
        return statuses;
    }
    public void decreaseMana(int amount){
        currMana -= amount;
    }

    public void addSpell(Spell spell) {
        initialActions.addSpell(spell);
    }
    public void addItem(Item item){
        initialActions.addItem(item);
    }
    public void addStatus(Status status){
        statuses.add(status);
    }
    public void decrementStatusDuration(){
        List<Status> toBeRemoved = new ArrayList<>();
        for(Status status : statuses){
            status.decrementDuration();
            if(status.getDuration() <= 0){
                toBeRemoved.add(status);
            }
        }
        statuses.removeAll(toBeRemoved);
    }
    public static class Warrior extends CharacterClass{
        public Warrior() {
            super(50, 25, 10, 10, 10);
            addSpell(new StatusSpell.LoyaltyHymn());
            addItem(new HealingItem.HealingPotion());
            addItem(new HealingItem.HealingPotion());
        }
    }
    public static class Mage extends CharacterClass{

        public Mage() {
            super(40, 10, 15, 10, 25);
            addSpell(new DamagingSpell.Meteors());
            addSpell(new DamagingSpell.IceBeam());
            addItem(new HealingItem.HealingPotion());
            addItem(new StatusItem.SmokeBomb());
        }
    }
}
