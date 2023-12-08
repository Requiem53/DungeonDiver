package GameSystems;

import Characters.Character;
import Interfaces.*;
import States.ChoiceTurn;

import java.util.*;

public abstract class State {
     protected BattleSystem bs;
     protected String option;
     protected Scanner sc;
     protected Random random;

     protected static List<Character> allies = new ArrayList<>();
     protected static List<Character> enemies = new ArrayList<>();

     protected ActionExecutor executor;

     public State(BattleSystem bs){
          this.bs = bs;
          executor = new ActionExecutor();

          sc = new Scanner(System.in);
          random = new Random();
     }

     //Potential Useless
     protected Character getCurrChar(){
//          return bs.getCharacters().get(bs.getCurrentTurn());
          return bs.getCurrChar();
     }

     protected void newChoiceTurn(){
          bs.setState(new ChoiceTurn(bs));
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
