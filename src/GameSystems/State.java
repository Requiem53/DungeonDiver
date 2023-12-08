package GameSystems;

import Actions.ActionsManager;
import Actions.AttackAction;
import Actions.CastSpellAction;
import Characters.Character;
import GameSystems.BattleSystem;
import Spells.Spell;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public abstract class State {
     protected BattleSystem bs;
     protected String option;
     protected Scanner sc;
     protected static List<Character> allies = new ArrayList<>();
     protected static List<Character> enemies = new ArrayList<>();

     ActionsManager actionsMgr;

     public State(BattleSystem bs){
          this.bs = bs;
          sc = new Scanner(System.in);

          actionsMgr = new ActionsManager();
     }

     protected Character getCurrChar(){
          return bs.getCharacters().get(bs.getCurrentTurn());
     }

     protected void newTurn(){
          bs.setState(new Turn(bs));
     }

     protected void deadValidate(){
          if(!getCurrChar().isAlive()){
               System.out.println(getCurrChar() + " is already dead!");
               newTurn();
          }
     }


     public BattleSystem getBs() {
          return bs;
     }

     public abstract void Start();

     //States
     public static class EnterName extends State{
          public EnterName(BattleSystem bs) {
               super(bs);
          }

          @Override
          public void Start() {
               String name = null;
               while(true){
                    System.out.print("Enter your name: ");
                    name = sc.nextLine();
                    if(name.equals("")){
                         System.out.println("You did not enter anything...");
                    }else break;
               }
               bs.user = new User(name);
               bs.setState(new BattleStart(bs));

          }
     }
     public static class BattleStart extends State{
          public BattleStart(BattleSystem bs) {
               super(bs);
          }

          @Override
          public void Start() {
               System.out.println("The battle is starting....");
               bs.turnOrder();
               for(Character chara : bs.getCharacters()){
                    if(chara instanceof Character.Enemy){
                         enemies.add(chara);
                    }else{
                         allies.add(chara);
                    }
               }
               newTurn();
          }
     }


     public static class Turn extends State{
          public Turn(BattleSystem bs) {
               super(bs);
          }

          @Override
          public void Start() {
               boolean victory = false;
               boolean defeat = false;

               for(Character enemy : enemies){
                    if(enemy.isAlive()){
                         victory = false;
                         break;
                    }
                    victory = true;
               }

               for(Character ally : allies){
                    if(ally.isAlive()){
                         defeat = false;
                         break;
                    }
                    defeat = true;
               }

               if(victory){
                    System.out.println("You have won the battle!");
                    //Add new battle diri ug file handling para record sa number of battles won niya sa
                    //characters gigamit
                    return;
               }

               if(defeat){
                    System.out.println("You have lost the battle!");
                    //Add new battle diri ug file handling para record sa number of battles won niya sa
                    //characters gigamit
                    return;
               }

               bs.incrementTurn();

               if(!(getCurrChar() instanceof Character.Enemy)){
                    bs.setState(new PlayerTurn(bs));
               } else {
                    bs.setState(new EnemyTurn(bs));
               }

          }
     }

     public static class PlayerTurn extends State{
          public PlayerTurn(BattleSystem bs) {
               super(bs);
          }

          @Override
          public void Start() {
               deadValidate();

               System.out.println("What will " + getCurrChar() + " do?");
               option = sc.nextLine();
               switch (option){
                    case "Exit":
                         break;
                    case "List Allies":
                         System.out.println("Allies: ");
                         for(Character chara : allies){
                              System.out.println(chara);
                         }

                         System.out.println("Enemies: ");
                         for(Character chara : enemies){
                              System.out.println(chara);
                         }
                         newTurn();
                         break;
                    case "Details":
                         for(Character chara : bs.getCharacters()){
                              chara.currentDetails();
                         }
                         newTurn();
                         break;
                    case "Attack":
                         System.out.println("Attack who?");
                         int list = 1;
                         int target;

                         for(Character enemy : enemies){
                              if(enemy.isAlive()){
                                   System.out.println(list + ". " + enemy);
                                   list++;
                              }
                         }
                         System.out.println("Enter number: ");
                         target = sc.nextInt();

                         Character targeted = enemies.get(target-1);

                         System.out.println(getCurrChar() + " dealt " + getCurrChar().attack(targeted) + " damage to "
                                 + targeted + "!");
                         if(!targeted.isAlive()){
                              System.out.println(targeted + " died from the blow!");
                              enemies.remove(targeted);
                         }
                         newTurn();
                         break;
                    case "Spell":
                         int spellChoice = 0;
                         Scanner sc = new Scanner(System.in);
                         System.out.println("What spells do " + getCurrChar().getName() + " want to use? Choose: ");
                         System.out.println(getCurrChar().toStringSpells());
                         try{
                              while(true){
                                   spellChoice = sc.nextInt();
                                   sc.nextLine();
                                   if(spellChoice > getCurrChar().getSpells().size()){
                                        System.out.println("Choice is out of bounds");
                                   }else break;
                              }
                         }catch(InputMismatchException e){
                              System.out.println("Since you didn't enter a number, we will use the first choice >:)");
                              spellChoice = 0;
                         }
                         Spell spellUsed = getCurrChar().getSpells().get(spellChoice);
                         System.out.println("Use on who?");
                         int spellTargetInd = 0;
                         Character spellTarget;
                         if(spellUsed instanceof Spell.DamagingSpell){
                              for(int i=0; i< enemies.size(); i++){
                                   if(enemies.get(i).isAlive()){
                                        System.out.println(i+1 + ". " + enemies.get(i));
                                   }
                              }
                              System.out.println("Enter number: ");
                              spellTargetInd = sc.nextInt();
                              spellTarget = enemies.get(spellTargetInd - 1);
                         }else{
                              for(int i=0; i< allies.size(); i++){
                                   if(allies.get(i).isAlive()){
                                        System.out.println(i+1 + ". " + allies.get(i));
                                   }
                              }
                              System.out.println("Enter number: ");
                              spellTargetInd = sc.nextInt();
                              spellTarget = allies.get(spellTargetInd - 1);
                         }

                         actionsMgr.addAction(new CastSpellAction(spellUsed, spellTarget));
                    default:
                         newTurn();
                         break;
               }
          }
     }

     public static class EnemyTurn extends State{
          public EnemyTurn(BattleSystem bs) {
               super(bs);
          }

          @Override
          public void Start() {
               deadValidate();
               /*
               System.out.println(getCurrChar() + " is wondering about what they " +
                       "will do next....");
                */


               Character target = allies.get(0);
               Character currActor = getCurrChar();

               actionsMgr.addAction(new AttackAction(currActor, target));

               System.out.println(currActor + " attacks " + target +
                       " for " + currActor.getPower() + " damage.");

               newTurn();
          }
     }

}
