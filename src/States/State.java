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
     protected int loopBreaker;

     protected static List<Character> allies = new ArrayList<>();
     protected static List<Character> randomEnemies = new ArrayList<>();

     public State(BattleSystem bs){
          this.bs = bs;

          sc = new Scanner(System.in);
          random = new Random();

          dungeonLevel = 1;

          loopBreaker = 1;

          System.out.println();
     }

     protected void newChoiceTurn(){
          bs.setState(new ChoiceTurn(bs));
     }

     public abstract void Start();

     public void initializeAllies(){
          State.allies = bs.getPartyMembers();
     }

     public void initializeEnemies(){
//          State.randomEnemies = bs.getEnemies();
          //temporary
          randomEnemies.add(new Character.Enemy("Roden", new EnemyClass.Goblin()));
          randomEnemies.add(new Character.Enemy("Bernus", new EnemyClass.EvilMage()));
     }

     public static List<Character> getAllies() {
          return allies;
     }

     public static List<Character> getRandomEnemies() {
          return randomEnemies;
     }

     protected void loopStart(){
          loopBreaker = 1;
     }

     protected void redoLoop(){
          loopBreaker = 0;
     }

     protected boolean invalidChoice(){
          return loopBreaker == 0;
     }

     protected void listAllies(){
          int list = 1;
          for(Character enemy : randomEnemies){
               if(enemy.isAlive()){
                    System.out.println(list + ". " + enemy);
                    list++;
               }
          }
     }

     protected void listEnemies(){
          for(Character enemy : randomEnemies){
               int list = 1;
               if(enemy.isAlive()){
                    System.out.println(list + ". " + enemy);
                    list++;
               }
          }
     }

     //Potential Useless
     protected Character getCurrChar(){
//          return bs.getCharacters().get(bs.getCurrentTurn());
          return bs.getCurrChar();
     }

     protected void deadValidate(){
          if(!getCurrChar().isAlive()){
               System.out.println(getCurrChar() + " is already dead!");
               newChoiceTurn();
          }
     }

     public BattleSystem getBs() {
          return bs;
     }
}
