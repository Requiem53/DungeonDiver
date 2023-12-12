package States;

import Characters.Character;
import Equipment.Armor;
import Equipment.Weapon;
import GameSystems.BattleSystem;

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
        System.out.println("1. ");          //add items and their stats


        System.out.println("n. Go back");
        int weaponChoice = sc.nextInt();
        Character recipient = chooseRecipient();
        if(recipient == null) return weaponsShop(); //they chose to go back so recusively let them
        Weapon chosenWeapon = null;                        //choose the weapon
        switch(weaponChoice){
            case 1:
                chosenWeapon = new Weapon.Dagger(); //add better items;

            case 10:                                //they chose to go back
                return false;
        }
        recipient.equipWeapon(chosenWeapon);
        return true;
    }

    private boolean armorsShop(){
        System.out.println("What weapon do you want to buy?");
        System.out.println("1. ");          //add items and their stats


        System.out.println("n. Go back");
        int armorChoice = sc.nextInt();
        Character recipient = chooseRecipient();
        if(recipient == null) return weaponsShop(); //they chose to go back so recusively let them
        Armor chosenArmor = null;                        //choose the weapon
        switch(armorChoice){
            case 1:
                chosenArmor = new Armor.ClothArmor(); //add better items;

            case 10:                                //they chose to go back
                return false;
        }
        recipient.equipArmor(chosenArmor);
        return true;
    }
    private boolean itemsShop(){
        return false;
    }
    private boolean spellsShop(){
        return false;
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
}
