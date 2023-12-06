import Characters.Character;
import Characters.CharacterClass;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Add character creator

        Character.Ally char1 = new Character.Ally("Maurice", new CharacterClass.Warrior());
        Character.Ally char2 = new Character.Ally("Jorash", new CharacterClass.Warrior());
        Character.Ally char3 = new Character.Ally("Van", new CharacterClass.Warrior());
        Character.Ally char4 = new Character.Ally("Slamm", new CharacterClass.Warrior());

        Character.Enemy enemyTest = new Character.Enemy("Ugang", new CharacterClass.Warrior());
        Character.Enemy enemyTest2 = new Character.Enemy("Big Mom", new CharacterClass.Warrior());
        List<Character> characters = new ArrayList<>();
        characters.add(char1);
        characters.add(char2);
        characters.add(char3);
        characters.add(char4);
        characters.add(enemyTest);
        characters.add(enemyTest2);

        BattleSystem bs = new BattleSystem(characters);
    }
}