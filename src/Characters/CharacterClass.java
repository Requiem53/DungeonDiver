package Characters;

import Spells.*;
import Statuses.*;
import Attacks.*;
import Items.*;

import java.util.ArrayList;

public abstract class CharacterClass {
    private int maxHealth;
    private int power;
    private int speed;
    private int defense;
    private int magicPower;

    private int currHealth;
    private int currMana;
    private ArrayList<Spell> spells;
    private ArrayList<Attack> attacks;
    private ArrayList<Item> items;

    public CharacterClass(int maxHealth, int power, int speed, int defense, int magicPower) {

        this.maxHealth = maxHealth;
        this.power = power;
        this.speed = speed;
        this.defense = defense;
        this.magicPower = magicPower;

        this.currHealth = maxHealth;
        this.currMana = magicPower;
        attacks = new ArrayList<>(){{
            add(new NormalAttack());
            add(new StrongAttack());
        }};
        spells = new ArrayList<>();
        items = new ArrayList<>();
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

    public int getCurrHealth() {
        return currHealth;
    }

    public int getCurrMana() {
        return currMana;
    }
    public void decreaseMana(int amount){
        currMana -= amount;
    }
    public ArrayList<Spell> getSpells(){
        return spells;
    }
    public ArrayList<Item> getItems(){
        return items;
    }
    public ArrayList<Attack> getAttacks(){
        return attacks;
    }
    public void addSpell(Spell spell) {
        spells.add(spell);
    }
    public void addItem(Item item){
        items.add(item);
    }

    public static class Warrior extends CharacterClass{
        public Warrior() {
            super(50, 25, 10, 10, 10);
            SpellBuilder spellBuilder = new SpellBuilder("Loyalty Hymn").setStatus(new Buff());
            addSpell(new Spell.DamagingSpell(spellBuilder));
            ItemBuilder itemBuilder = new ItemBuilder("Health Potion").setAmount(50);
            addItem(new Item.HealingItem(itemBuilder));
            addItem(new Item.HealingItem(itemBuilder));
        }
    }
    public static class Mage extends CharacterClass{

        public Mage() {
            super(40, 10, 15, 10, 25);
            SpellBuilder spellBuilder = new SpellBuilder("Meteors").setManaCost(5).setBaseDamage(90);
            addSpell(new Spell.DamagingSpell(spellBuilder));
            spellBuilder.setName("Ice beam").setManaCost(5).setBaseDamage(90);
            addSpell(new Spell.DamagingSpell(spellBuilder));
            ItemBuilder itemBuilder = new ItemBuilder("Health Potion").setAmount(50);
            addItem(new Item.HealingItem(itemBuilder));
            itemBuilder.setName("Smoke bomb").setStatus(new Buff());
            addItem(new Item.StatusItem(itemBuilder));
        }
    }
}
