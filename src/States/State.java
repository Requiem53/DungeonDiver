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

     protected static List<Character> livingAllies = new ArrayList<>();
     protected static List<Character> randomEnemies = new ArrayList<>();

     public State(BattleSystem bs){
          this.bs = bs;

          sc = new Scanner(System.in);
          random = new Random();

          dungeonLevel = 1;

          System.out.println();
     }

     public abstract void Start();

     protected void newChoiceTurn(){
          bs.setState(new ChoiceTurn(bs));
     }
     public void initializeAllies(){
          State.livingAllies = bs.getPartyMembers();
     }
     public void initializeEnemies(){
          //temporary
          //Add random enemy generator soon depending on dungeon level
          randomEnemies.add(new Character.Enemy("Roden", new EnemyClass.Goblin()));
          randomEnemies.add(new Character.Enemy("Bernus", new EnemyClass.EvilMage()));
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
