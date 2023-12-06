import Characters.Character;
import Characters.CharacterClass;

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
            }

        } while (!input.equals("DONE"));

    }
}