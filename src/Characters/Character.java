package Characters;

import CharacterComponents.DoableActions;
import Equipment.Equipment;
import Equipment.Weapon;
import Equipment.Armor;
import Interfaces.Actionable;
import Statuses.*;
import Spells.*;
import Attacks.*;
import Items.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Character implements Comparable<Character> {
    //pun an guro spells pero I guess sakto na ang weapons
    //simple only
    //Add AI to enemy too
    //simply only as well
    private String name;
    private CharacterClass charClass;
//    private getEquipment() getEquipment();
    private DoableActions doableActions;

    public Character(String name, CharacterClass charClass) {
        this.name = name;
        this.charClass = charClass;

//        getEquipment() = new getEquipment()();
        doableActions = charClass.getInitialActions();
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

        if(getEquipment().getWeapon() == null) System.out.println("You have no weapons equipped!");
        else System.out.println(getEquipment().getWeapon());
    }

    //Actions
    public int attack(Character character){
        return charClass.attack(character);
    }
    public void takeDamage(int damage){
        Random random = new Random();
        if(random.nextFloat() < getEvasion()){
            charClass.takeDamage(damage);
            System.out.println(name + " received " + damage + " pts of damage");
        }else{
            System.out.println(name + " evaded the hit!");
        }
    }
    public void heal(int amount){
        charClass.heal(amount);
    }

    //Equip Stuff
    public void equipWeapon(Weapon weapon){
        getEquipment().equipWeapon(weapon);
    }
    public void unequipWeapon(){
        getEquipment().unequipWeapon();
    }

    public void equipArmor(Armor armor){
        getEquipment().equipArmor(armor);
    }

    public void unequipArmor(){
        getEquipment().unequipArmor();
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

    //Character Class
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
    public float getEvasion(){
        return charClass.getEvasion() + getBonusEvasion();
    }

    public int getCurrHealth() {
        return charClass.getCurrHealth();
    }

    public int getCurrMana(){
        return charClass.getCurrMana();
    }

    public String getClassName(){
        return charClass.getName();
    }

    public Equipment getEquipment() {
        return charClass.getEquipment();
    }

    //Doable Actions
    public ArrayList<Attack> getAttacks(){
        return doableActions.getAttacks();
    }
    public ArrayList<Spell> getSpells(){
        return doableActions.getSpells();
    }
    public ArrayList<Item> getItems(){
        return doableActions.getInventory();
    }

    public void listAttacks(){
        System.out.println(name + "'s attacks: ");
        doableActions.listActions(new ArrayList<>(getAttacks()));
    }

    public void listSpells(){
        System.out.println(name + "'s spells: ");
        doableActions.listActions(new ArrayList<>(getSpells()));
    }

    public void listItems(){
        System.out.println(name + "'s items: ");
        doableActions.listActions(new ArrayList<>(getItems()));
    }

    //Bonus from buffs and getEquipment()s
    public int getBonusMaxHealth(){
        int total = 0;
        if(getEquipment().getWeapon() != null) total += getEquipment().getWeapon().getMaxHealth();
        if(getEquipment().getArmor() != null) total += getEquipment().getArmor().getMaxHealth();
        for(Status status : charClass.getStatuses()){
            if(status.getStatusStat() == StatusStat.HEALTH){
                if(status instanceof Buff) total += (int) (status.getChangeAmount() * charClass.getMaxHealth());
                else total -= (int) (status.getChangeAmount() * charClass.getMaxHealth());
            }
        }
        return total;
    }

    public int getBonusPower(){
        int total = 0;
        if(getEquipment().getWeapon() != null) total += getEquipment().getWeapon().getPower();
        if(getEquipment().getArmor() != null) total += getEquipment().getArmor().getPower();
        for(Status status : charClass.getStatuses()){
            if(status.getStatusStat() == StatusStat.POWER){
                if(status instanceof Buff) total += (int) (status.getChangeAmount() * charClass.getPower());
                else total -= (int) (status.getChangeAmount() * charClass.getPower());
            }
        }
        return total;
    }

    public int getBonusSpeed(){
        int total = 0;
        if(getEquipment().getWeapon() != null) total += getEquipment().getWeapon().getSpeed();
        if(getEquipment().getArmor() != null) total += getEquipment().getArmor().getSpeed();
        for(Status status : charClass.getStatuses()){
            if(status.getStatusStat() == StatusStat.SPEED){
                if(status instanceof Buff) total += (int) (status.getChangeAmount() * charClass.getSpeed());
                else total -= (int) (status.getChangeAmount() * charClass.getSpeed());
            }
        }
        return total;
    }

    public int getBonusDefense(){
        int total = 0;
        if(getEquipment().getWeapon() != null) total += getEquipment().getWeapon().getDefense();
        if(getEquipment().getArmor() != null) total += getEquipment().getArmor().getDefense();
        for(Status status : charClass.getStatuses()){
            if(status.getStatusStat() == StatusStat.DEFENSE){
                if(status instanceof Buff) total += (int) (status.getChangeAmount() * charClass.getDefense());
                else total -= (int) (status.getChangeAmount() * charClass.getDefense());
            }
        }
        return total;
    }

    public int getBonusMagicPower(){
        int total = 0;
        if(getEquipment().getWeapon() != null) total += getEquipment().getWeapon().getMagicPower();
        if(getEquipment().getArmor() != null) total += getEquipment().getArmor().getMagicPower();
        for(Status status : charClass.getStatuses()){
            if(status.getStatusStat() == StatusStat.MAGIC_POWER){
                if(status instanceof Buff) total += (int) (status.getChangeAmount() * charClass.getMagicPower());
                else total -= (int) (status.getChangeAmount() * charClass.getMagicPower());
            }
        }
        return total;
    }
    public float getBonusEvasion(){
        float total = 0;
        if(getEquipment().getWeapon() != null) total += getEquipment().getWeapon().getEvasion();
        if(getEquipment().getArmor() != null) total += getEquipment().getArmor().getEvasion();
        for(Status status : charClass.getStatuses()){
            if(status.getStatusStat() == StatusStat.EVASION){
                if(status instanceof Buff) total += status.getChangeAmount();
                else total -= status.getChangeAmount();
            }
        }
        return total;
    }
    public boolean decreaseMana(int amount){        //returns boolean for spell usage checking
        if((charClass.getCurrMana() - amount) < 0){
            return false;
        }
        charClass.decreaseMana(amount);
        return true;
    }
    public void addStatus(Status status){
        charClass.addStatus(status);
    }
    public void decrementStatusDuration(){
        charClass.decrementStatusDuration();
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
