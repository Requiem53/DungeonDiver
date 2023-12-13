package States;

import Characters.Character;
import Equipment.Armor;
import Equipment.Equippable;
import Equipment.Weapon;
import GameSystems.BattleSystem;
import Interfaces.Actionable;
import Items.HealingItem;
import Items.Item;
import Items.StatusItem;
import Spells.DamagingSpell;
import Spells.StatusSpell;

import java.util.List;
import java.util.Scanner;

public class Shop extends State{
    Scanner sc;

    public Shop(BattleSystem bs) {
        super(bs);
        sc = new Scanner(System.in);
    }

    @Override
    public void Start() {
        //Add small shop that sells weapons and armor
        //Add option to learn new spells, attacks
        //Add sell items
        //Add revive allies option
        System.out.println("Welcome to the Dungeon Shop! What do you want to buy?");
        System.out.println("1. Weapons\n2. Armors\n3. Items\n4. Spell Scrolls\n5. Nothing");
        int shopChoice = sc.nextInt();
        boolean doneShopping;
        switch (shopChoice) {
            case 1 -> doneShopping = weaponsShop();
            case 2 -> doneShopping = armorsShop();
            case 3 -> doneShopping = itemsShop();
            case 4 -> doneShopping = spellsShop();
            case 5 -> doneShopping = true;
            default -> doneShopping = false;
        }
        if(!doneShopping) bs.setState(new Shop(bs));

        bs.setState(new DescendLevel(bs));
    }

    private boolean weaponsShop(){          //return true if done shopping, false if switched shop
        System.out.println("What weapon do you want to buy?");
        System.out.println("(200G) 1. "+new Weapon.Steel_Sword());
        System.out.println("(400G) 2. "+new Weapon.Sword_Of_Light());
        System.out.println("(200G) 3. "+new Weapon.Sharp_Dagger());
        System.out.println("(400G) 4. "+new Weapon.Executioner_Blade());
        System.out.println("(200G) 5. "+new Weapon.Advanced_Wand());
        System.out.println("(400G) 6. "+new Weapon.Elven_Wand());
        System.out.println("(200G) 7. "+new Weapon.Springwood_Staff());
        System.out.println("(400G) 8. "+new Weapon.Holy_Staff());
        System.out.println("9. Go back");

        int weaponChoice = sc.nextInt();
        Weapon chosenWeapon = null;                        //choose the weapon
        switch(weaponChoice){
            case 1 -> chosenWeapon = (Weapon) validateMoney(new Weapon.Steel_Sword(), 200);
            case 2 -> chosenWeapon = (Weapon) validateMoney(new Weapon.Sword_Of_Light(), 400);
            case 3 -> chosenWeapon = (Weapon) validateMoney(new Weapon.Sharp_Dagger(), 200);
            case 4 -> chosenWeapon = (Weapon) validateMoney(new Weapon.Executioner_Blade(), 400);
            case 5 -> chosenWeapon = (Weapon) validateMoney(new Weapon.Advanced_Wand(), 200);
            case 6 -> chosenWeapon = (Weapon) validateMoney(new Weapon.Elven_Wand(), 400);
            case 7 -> chosenWeapon = (Weapon) validateMoney(new Weapon.Springwood_Staff(), 200);
            case 8 -> chosenWeapon = (Weapon) validateMoney(new Weapon.Holy_Staff(), 400);
            case 9 -> {
                return false;             //they chose to go back
            }
            default -> {
                return weaponsShop();
            }
        }
        Character recipient = chooseRecipient();
        if(recipient == null) return weaponsShop(); //they chose to go back so recusively let them
        recipient.equipWeapon(chosenWeapon);
        return true;
    }

    private boolean armorsShop(){
        System.out.println("What weapon do you want to buy?");
        System.out.println("(300G) 1. "+new Armor.Steel_Chestplate());
        System.out.println("(300G) 2. "+new Armor.Dark_Cloak());
        System.out.println("(300G) 3. "+new Armor.Elven_Robe());
        System.out.println("(300G) 4. "+new Armor.Elven_Robe());
        System.out.println("5. Go back");

        int armorChoice = sc.nextInt();
        Armor chosenArmor = null;                        //choose the weapon
        switch(armorChoice){
            case 1 -> chosenArmor = (Armor) validateMoney(new Armor.Steel_Chestplate(), 300);
            case 2 -> chosenArmor = (Armor) validateMoney(new Armor.Dark_Cloak(), 300);
            case 3 -> chosenArmor = (Armor) validateMoney(new Armor.Elven_Robe(), 300);
            case 4 -> chosenArmor = (Armor) validateMoney(new Armor.Cleric_Garment(), 300);
            case 5 -> {                         //they chose to go back
                return false;
            }
            default -> {
                return armorsShop();
            }
        }
        Character recipient = chooseRecipient();
        if(recipient == null) return armorsShop(); //they chose to go back so recusively let them
        recipient.equipArmor(chosenArmor);
        return true;
    }
    private boolean itemsShop(){
        System.out.println("What weapon do you want to buy?");
        System.out.println("(50G) 1. "+new HealingItem.HealingPotion());
        System.out.println("(100G) 2. "+new HealingItem.GreaterHealingPotion());
        System.out.println("(50G) 3. "+new StatusItem.SmokeBomb());
        System.out.println("(150G) 4. "+new StatusItem.HealthPlus());
        System.out.println("5. Go back");
        int itemChoice = sc.nextInt();
        Item chosenItem = null;                        //choose the weapon
        switch(itemChoice){
            case 1 -> chosenItem = (Item) validateMoney(new HealingItem.HealingPotion(), 50);
            case 2 -> chosenItem = (Item) validateMoney(new HealingItem.GreaterHealingPotion(), 100);
            case 3 -> chosenItem = (Item) validateMoney(new StatusItem.SmokeBomb(), 50);
            case 4 -> chosenItem = (Item) validateMoney(new StatusItem.HealthPlus(), 150);
            case 5 -> {                         //they chose to go back
                return false;
            }
            default -> {
                return itemsShop();
            }
        }
        Character recipient = chooseRecipient();
        if(recipient == null) return itemsShop(); //they chose to go back so recusively let them
        recipient.addItem(chosenItem);
        return true;
    }
    private boolean spellsShop(){
        System.out.println("What spell do you want to buy?");
        System.out.println("(200G) 1. "+new DamagingSpell.Hyper_Beam());
        System.out.println("(400G) 2. "+new DamagingSpell.Celestial_Ray());
        System.out.println("(150G) 3. "+new StatusSpell.Strength());
        System.out.println("(150G) 4. "+new StatusSpell.Wisdom());  //continue unya wa pa nahuman
        System.out.println("5. Go back");
        int itemChoice = sc.nextInt();
        Item chosenItem = null;                        //choose the weapon
        switch(itemChoice){
            case 1 -> chosenItem = (Item) validateMoney(new HealingItem.HealingPotion(), 50);
            case 2 -> chosenItem = (Item) validateMoney(new HealingItem.GreaterHealingPotion(), 100);
            case 3 -> chosenItem = (Item) validateMoney(new StatusItem.SmokeBomb(), 50);
            case 4 -> chosenItem = (Item) validateMoney(new StatusItem.HealthPlus(), 150);
            case 5 -> {                         //they chose to go back
                return false;
            }
            default -> {
                return itemsShop();
            }
        }
        Character recipient = chooseRecipient();
        if(recipient == null) return itemsShop(); //they chose to go back so recusively let them
        recipient.addItem(chosenItem);
        return true;
    }

    private Character chooseRecipient(){
        List<Character> partyMembers = bs.getPartyMembers();
        for(int i=0 ; i<partyMembers.size(); i++){
            System.out.println((i+1) + ". " + partyMembers.get(i));
        }
        System.out.println((partyMembers.size()+1) + ". Go back");
        int recipientChoice = sc.nextInt();
        if(recipientChoice == partyMembers.size()+1){       //they chose to go back
            return null;
        }
        try{
            return partyMembers.get(recipientChoice);
        }catch (IndexOutOfBoundsException e){
            return chooseRecipient();       //if out of bounds, recursively let them choose again
        }
    }

    private Equippable validateMoney(Equippable item, int price){
        if(bs.getParty().getGold() >= price){
            bs.getParty().spendGold(price);
            return item;
        }
        else return null;
    }
    private Actionable validateMoney(Actionable item, int price){
        if(bs.getParty().getGold() >= price){
            bs.getParty().spendGold(price);
            return item;
        }
        else return null;
    }
}
