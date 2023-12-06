import Characters.Character;
import Characters.CharacterClass;
import Weapons.Weapon;
import Weapons.WeaponBuilder;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Add character creator
        Character.Ally char1 = new Character.Ally("Maurice", new CharacterClass.Warrior());

        String input;

        //test

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
                    char1.equipWeapon(new Weapon.Sword(new WeaponBuilder()));
                    break;
                case "Unequip Weapon":
                    char1.unequipWeapon();
                    break;
                default:
                    System.out.println("Try again.");
                    break;
            }
        } while (!input.equals("DONE"));
    }
}