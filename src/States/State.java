package States;

import Characters.Character;
import Characters.EnemyClass;
import GameSystems.BattleSystem;

import java.util.*;

public abstract class State {
     protected int dungeonLevel;

     protected BattleSystem bs;
     protected Scanner sc;
     protected Random random;

     public static List<Character> livingAllies = new ArrayList<>();
     public static List<Character> randomEnemies = new ArrayList<>();

     public State(BattleSystem bs){
          this.bs = bs;

          sc = new Scanner(System.in);
          random = new Random();

          dungeonLevel = 0;

          System.out.println();
     }

     public abstract void Start();

     protected void descendLevel(){
          dungeonLevel++;
     }

     public int getDungeonLevel() {
          return dungeonLevel;
     }

     protected void newChoiceTurn(){
          bs.setState(new ChoiceTurn(bs));
     }


     public void initializeAllies(){
          livingAllies = bs.getLivingAllies();
     }
     public void initializeEnemies(){
          //temporary
          //Add random enemy generator soon depending on dungeon level
          getRandomEnemies().add(new Character.Enemy("Roden", new EnemyClass.Goblin()));
          getRandomEnemies().add(new Character.Enemy("Bernus", new EnemyClass.EvilMage()));
     }
     public void initializeBoss(){
          getRandomEnemies().add(new Character.Enemy("Roden", new EnemyClass.Goblin()));
     }

     public static List<Character> getLivingAllies() {
          return livingAllies;
     }
     public static List<Character> getRandomEnemies() {
          return randomEnemies;
     }
     protected Character getCurrChar(){
          return bs.getCurrChar();
     }
}
