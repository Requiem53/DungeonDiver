package Characters;

import CharacterComponents.DoableActions;
import Equipment.Equipment;
import Equipment.Weapon;
import Equipment.Armor;
import Spells.*;
import Statuses.*;
import Attacks.*;
import Items.*;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public abstract class CharacterClass {
    private String name;

    public BufferedImage sprite;
    public abstract void loadSprites();

    private int maxHealth;
    private int power;
    private int speed;
    private int defense;
    private int magicPower;
    private float evasion;
    private int currHealth;
    private int currMana;

    private Equipment equipment;
    private final DoableActions initialActions;
    private List<Status> statuses;

    public CharacterClass(String name, int maxHealth, int power, int speed, int defense, int magicPower) {
        this.name = name;

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
            add(new Attack.QuickAttack());
            add(new Attack.StrongAttack());
        }};

        ArrayList<Spell> spells = new ArrayList<>();
        ArrayList<Item> items = new ArrayList<>();

        equipment = new Equipment();

        initialActions = new DoableActions(attacks, spells, items);
        statuses = new ArrayList<>();
    }

    public void regenerateToFull(){
        currHealth = maxHealth;
        currMana = magicPower;
    }

    public DoableActions getInitialActions(){
        return initialActions;
    }

    public void takeDamage(int damage){
        currHealth = Math.max(0, currHealth-damage);
    }

    public void heal(int amount){
        currHealth = Math.min(maxHealth, currHealth+amount);
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

    public void equipWeapon(Weapon weapon){
        equipment.equipWeapon(weapon);
        equipment.addEquippable(weapon);
    }
    public void equipArmor(Armor armor){
        equipment.equipArmor(armor);
        equipment.addEquippable(armor);
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

    //Getters
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
    public Equipment getEquipment() {
        return equipment;
    }
    public void decreaseMana(int amount){
        currMana -= amount;
    }
    public String getName(){
        return name;
    }
    public String toString(){
        return name;
    }
}
