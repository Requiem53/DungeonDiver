package States;

import Characters.Character;
import GameSystems.BattleSystem;
import Interfaces.*;
import States.ChoiceTurn;

import java.util.*;

public abstract class State {
     protected BattleSystem bs;
     protected int numOption;
     protected String option;
     protected Scanner sc;
     protected Random random;
     protected int loopBreaker;

     protected static List<Character> allies = new ArrayList<>();
     protected static List<Character> enemies = new ArrayList<>();

     protected ActionExecutor executor;

     public State(BattleSystem bs){
          this.bs = bs;
          executor = new ActionExecutor();

          sc = new Scanner(System.in);
          random = new Random();

          loopBreaker = 1;
     }

     protected void newChoiceTurn(){
          bs.setState(new ChoiceTurn(bs));
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

     public abstract void Start();
}
