import Characters.Character;
import Characters.CharacterClass;
import Equipment.Armor;
import Equipment.EquippableBuilder;
import Equipment.Weapon;
import GameSystems.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Add character creator
        Character.Ally char1 = new Character.Ally("Maurice", new CharacterClass.Mage());
        Character.Ally char2 = new Character.Ally("Slamm", new CharacterClass.Warrior());
        Character.Enemy en1 = new Character.Enemy("RODEN", new CharacterClass.Warrior());

        List<Character> entities = new ArrayList<>();
        entities.add(char2);
        entities.add(char1);
        entities.add(en1);

        BattleSystem bs = new BattleSystem(entities);

        String input;

        // fixing intellij commit
        /*
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
        */
    }
}