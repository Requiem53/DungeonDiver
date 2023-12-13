package States;

import Characters.Character;
import Characters.EnemyClass;
import GameSystems.BattleSystem;

import java.util.*;

public abstract class State {
     public static int dungeonLevel = 0;

     protected BattleSystem bs;
     protected Scanner sc;
     protected Random random;

     public static List<Character> livingAllies = new ArrayList<>();
     public static List<Character> randomEnemies = new ArrayList<>();

     public static Queue<Character> queueChoice = new LinkedList<>();
     public State(BattleSystem bs){
          this.bs = bs;

          sc = new Scanner(System.in);
          random = new Random();

          System.out.println();
     }

     public abstract void Start();

     protected void descendLevel(){
          State.dungeonLevel++;
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
          randomEnemies.add(new Character.Enemy("Roden", new EnemyClass.Goblin()));
          randomEnemies.add(new Character.Enemy("Bernus", new EnemyClass.EvilMage()));
     }
     public void initializeBoss(){
          randomEnemies.add(new Character.Enemy("Roden", new EnemyClass.Goblin()));
     }

     protected Character getCurrChar(){
          return bs.getCurrChar();
     }
}
