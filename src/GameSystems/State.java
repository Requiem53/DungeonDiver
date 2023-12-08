package GameSystems;

import Characters.Character;
import Spells.Spell;
import Interfaces.*;
import Attacks.*;

import java.util.*;

public abstract class State {
     protected BattleSystem bs;
     protected String option;
     protected Scanner sc;
     protected Random random;
     protected static List<Character> allies = new ArrayList<>();
     protected static List<Character> enemies = new ArrayList<>();

     public State(BattleSystem bs){
          this.bs = bs;
          sc = new Scanner(System.in);
          random = new Random();
     }

     protected Character getCurrChar(){
          return bs.getCharacters().get(bs.getCurrentTurn());
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
               for(Character chara : bs.getCharacters()){
                    if(chara instanceof Character.Enemy){
                         enemies.add(chara);
                    }else{
                         allies.add(chara);
                    }
               }
               newChoiceTurn();
          }
     }


     public static class ChoiceTurn extends State{
          public ChoiceTurn(BattleSystem bs) {
               super(bs);
          }

          @Override
          public void Start() {
               bs.incrementTurn();
               if(bs.getCurrentTurn() >= bs.getCharacters().size()){  //currentTurn becomes currentChoiceTurn
                    bs.resetTurn();                                   //just didn't change the names
                    bs.sortActions();
                    bs.setState(new ActionTurn(bs));
               }

               if(!(getCurrChar() instanceof Character.Enemy)){
                    bs.setState(new PlayerChoiceTurn(bs));
               } else {
                    bs.setState(new EnemyTurn(bs));
               }

          }
     }

     public static class PlayerChoiceTurn extends State{
          public PlayerChoiceTurn(BattleSystem bs) {
               super(bs);
          }

          @Override
          public void Start() {
               while(true){
                    System.out.println("What will " + getCurrChar() + " do?");
                    option = sc.nextLine();
                    if(option.equalsIgnoreCase("Exit") ||
                         option.equalsIgnoreCase("List Allies") ||
                         option.equalsIgnoreCase("Attack") ||
                         option.equalsIgnoreCase("Spell")) break;
               }
               option = option.toLowerCase();
               switch (option){
                    case "exit":
                         break;
                    case "list allies":
                         System.out.println("Allies: ");
                         for(Character chara : allies){
                              System.out.println(chara);
                         }

                         System.out.println("Enemies: ");
                         for(Character chara : enemies){
                              System.out.println(chara);
                         }
                         newChoiceTurn();
                         break;
                    case "details":
                         for(Character chara : bs.getCharacters()){
                              chara.currentDetails();
                         }
                         newChoiceTurn();
                         break;
                    case "attack":
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

                         Character attackTarget = enemies.get(target-1);
                         bs.addAction(new Action(new Attack(), getCurrChar(), attackTarget));
                         newChoiceTurn();
                         break;
                    case "spell":
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
                         bs.addAction(new Action((Actionable)spellUsed, getCurrChar(), spellTarget));
                         newChoiceTurn();
                    default:
                         newChoiceTurn();
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
               Character allyTarget = allies.get(random.nextInt(allies.size()));
               Character currEnemy = getCurrChar();

               bs.addAction(new Action(new Attack(), currEnemy, allyTarget));
               newChoiceTurn();
          }
     }

     public static class ActionTurn extends State{
          public ActionTurn(BattleSystem bs) {
               super(bs);
          }

          @Override
          public void Start() {
               Action currentAction = bs.dequeueActionsSorted();
               if(currentAction == null){
                    newChoiceTurn();
               }
               currentAction.execute();
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
               System.out.println("-----------------------------");
               bs.setState(new ActionTurn(bs));
          }
     }
}
