package States;

import Characters.Character;
import GameSystems.BattleSystem;
import Interfaces.*;
import States.ChoiceTurn;

import java.util.*;

public abstract class State {
     protected BattleSystem bs;
     protected Scanner sc;
     protected Random random;
     protected int loopBreaker;

     protected static List<Character> allies = new ArrayList<>();
     protected static List<Character> enemies = new ArrayList<>();

     public State(BattleSystem bs){
          this.bs = bs;

          sc = new Scanner(System.in);
          random = new Random();

          loopBreaker = 1;
     }

     protected void newChoiceTurn(){
          bs.setState(new ChoiceTurn(bs));
     }

     public abstract void Start();

     public void initializeAllies(){
          State.allies = bs.getAllies();
     }

     public void initializeEnemies(){
          State.enemies = bs.getEnemies();
     }

     public static List<Character> getAllies() {
          return allies;
     }

     public static List<Character> getEnemies() {
          return enemies;
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
          for(Character enemy : enemies){
               if(enemy.isAlive()){
                    System.out.println(list + ". " + enemy);
                    list++;
               }
          }
     }

     protected void listEnemies(){
          for(Character enemy : enemies){
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
