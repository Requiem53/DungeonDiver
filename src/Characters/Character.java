package Characters;

import Equipment.Equipment;
import Equipment.Weapon;
import Equipment.Armor;
import Spells.*;

import java.util.ArrayList;

public abstract class Character implements Comparable<Character> {
    //pun an guro spells pero I guess sakto na ang weapons
    //simple only
    //Add AI to enemy too
    //simply only as well
    private String name;
    private CharacterClass charClass;
    private Equipment equipment;

    public Character(String name, CharacterClass charClass) {
        this.name = name;
        this.charClass = charClass;

        equipment = new Equipment();
    }

    //Debug Methods
    public void currentDetails(){
        System.out.println(name + "\n"
        + "Health: " + " (" + getCurrHealth() + "/" + getMaxHealth() + ") \n"
        + "Mana: "  + " (" + getCurrMana() + "/" + getMagicPower() + ") \n"
        + "Power: " + getPower() + "\n"
        + "Speed: " + getSpeed() + "\n"
        + "Defense: " + getDefense() + "\n"
        );
    }

    public void printCurrWeapon(){
        System.out.println(name);

        if(equipment.getWeapon() == null) System.out.println("You have no weapons equipped!");
        else System.out.println(equipment.getWeapon());
    }

    //Actions
    public int attack(Character character){
        return charClass.attack(character);
    }
    public void takeDamage(int damage){
        charClass.takeDamage(damage);
    }
    public void heal(int amount){
        charClass.heal(amount);
    }

    //Equip Stuff
    public void equipWeapon(Weapon weapon){
        equipment.equipWeapon(weapon);
    }
    public void unequipWeapon(){
        equipment.unequipWeapon();
    }

    public void equipArmor(Armor armor){
        equipment.equipArmor(armor);
    }

    public void unequipArmor(){
        equipment.unequipArmor();
    }

    //Getters
    public String toString(){
        return name;
    }

    public boolean isAlive(){
        return getCurrHealth() > 0;
    }

    public String getName() {
        return name;
    }
    public int getMaxHealth() {
        return charClass.getMaxHealth() + getBonusMaxHealth();
    }

    public int getPower() {
        return charClass.getPower() + getBonusPower();
    }

    public int getSpeed() {
        return charClass.getSpeed() + getBonusSpeed();
    }

    public int getDefense() {
        return charClass.getDefense() + getBonusDefense();
    }

    public int getMagicPower() {
        return charClass.getMagicPower() + getBonusMagicPower();
    }

    public int getCurrHealth() {
        return charClass.getCurrHealth();
    }

    public int getCurrMana(){
        return charClass.getCurrMana();
    }
    public ArrayList<Spell> getSpells(){
        return charClass.getSpells();
    }
    public String toStringSpells(){
        String string = name + "'s spells: ";
        for(int i=0; i<getSpells().size(); i++){
            string += "[" + getSpells().get(i)+1 + ".] " + getSpells().get(1).name;
        }
        return string;
    }

    //Bonus from buffs and equipments
    public int getBonusMaxHealth(){
        int total = 0;
        if(equipment.getWeapon() != null) total += equipment.getWeapon().getMaxHealth();
        if(equipment.getArmor() != null) total += equipment.getArmor().getMaxHealth();

        return total;
    }

    public int getBonusPower(){
        int total = 0;
        if(equipment.getWeapon() != null) total += equipment.getWeapon().getPower();
        if(equipment.getArmor() != null) total += equipment.getArmor().getPower();

        return total;
    }

    public int getBonusSpeed(){
        int total = 0;
        if(equipment.getWeapon() != null) total += equipment.getWeapon().getSpeed();
        if(equipment.getArmor() != null) total += equipment.getArmor().getSpeed();

        return total;
    }

    public int getBonusDefense(){
        int total = 0;
        if(equipment.getWeapon() != null) total += equipment.getWeapon().getDefense();
        if(equipment.getArmor() != null) total += equipment.getArmor().getDefense();

        return total;
    }

    public int getBonusMagicPower(){
        int total = 0;
        if(equipment.getWeapon() != null) total += equipment.getWeapon().getMagicPower();
        if(equipment.getArmor() != null) total += equipment.getArmor().getMagicPower();

        return total;
    }

    @Override
    public int compareTo(Character o){
        return Integer.compare(o.getSpeed(), this.getSpeed());
    }

    public static class Ally extends Character{
        public Ally(String name, CharacterClass charClass) {
            super(name, charClass);
        }
    }

    public static class Enemy extends Character{
        public Enemy(String name, CharacterClass charClass) {
            super(name, charClass);
        }
    }
}
