import Characters.Character;
import Characters.CharacterClass;
import Equipment.Armor;
import Equipment.EquippableBuilder;
import Equipment.Weapon;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Add character creator
        Character.Ally char1 = new Character.Ally("Maurice", new CharacterClass.Warrior());

        String input;

        do{
            System.out.println("What do: ");
            input = sc.nextLine();

            switch (input){
                case "DONE":
                    break;
                case "Print Details":
                    char1.currentDetails();
                    break;
                case "Current Weapon":
                    char1.printCurrWeapon();
                    break;
                case "Equip Weapon":
                    char1.equipWeapon(new Weapon.Sword(new EquippableBuilder()));
                    break;
                case "Unequip Weapon":
                    char1.unequipWeapon();
                    break;
                case "Equip Armor":
                    char1.equipArmor(new Armor.ClothArmor(new EquippableBuilder()));
                    break;
                case "Unequip Armor":
                    char1.unequipArmor();
                    break;
                default:
                    System.out.println("Try again.");
                    break;
            }
        } while (!input.equals("DONE"));
    }
}