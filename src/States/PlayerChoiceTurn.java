package States;

import Attacks.*;
import Characters.Character;
import GameSystems.BattleSystem;
import Interfaces.Action;
import Interfaces.Actionable;
import Items.Item;
import Spells.DamagingSpell;
import Spells.Spell;

import java.util.ArrayList;
import java.util.InputMismatchException;

public class PlayerChoiceTurn extends State {
    public PlayerChoiceTurn(BattleSystem bs) {
        super(bs);
    }

    int targetIndex;
    Character target;

    int actionChoice;

    @Override
    public void Start() {
        chooseOptionSequnce();
    }
    private void chooseOptionSequnce(){
        System.out.println("What will " + getCurrChar() + " do?");
        System.out.println(
                "1. Do Attack" + "\n" +
                "2. Cast Spell" + "\n" +
                "3. Use Item" + "\n" +
                "4. Change Equipment"
        );

        System.out.println("Type number: ");
        actionChoice = sc.nextInt();

        switch (actionChoice) {
            case 1 -> attackSequence();
            case 2 -> spellSequence();
            case 3 -> itemSequence();
            case 4 -> equipmentSequence();
            default -> {
                System.out.println("NOT A VALID OPTION");
                chooseOptionSequnce();
            }
        }

        newChoiceTurn();
    }


    private void attackSequence(){
        System.out.println("What attack does " + getCurrChar().getName() + " want to use? Choose: ");
        getCurrChar().listAttacks();
        System.out.println("Enter number: ");
        Attack attackUsed = (Attack) chooseAction(new ArrayList<>(getCurrChar().getAttacks()));

        System.out.println("Attack who?");
        target = attackUsed.chooseTarget();

        bs.addAction(new Action(attackUsed, getCurrChar(), target));

        newChoiceTurn();
    }

    private void spellSequence(){
        System.out.println("What spell does " + getCurrChar().getName() + " want to use? Choose: ");
        getCurrChar().listSpells();
        Spell spellUsed = (Spell) chooseAction(new ArrayList<>(getCurrChar().getSpells()));

        System.out.println("Use on who?");
        target = spellUsed.chooseTarget();

        bs.addAction(new Action(spellUsed, getCurrChar(), target));

        newChoiceTurn();
    }

    private void itemSequence(){
        System.out.println("What item does " + getCurrChar().getName() + " want to use? Choose: ");
        getCurrChar().listItems();
        Item itemUsed = (Item) chooseAction(new ArrayList<>(getCurrChar().getItems()));

        System.out.println("Use on who?");
        target = itemUsed.chooseTarget();

        bs.addAction(new Action(itemUsed, getCurrChar(), target));

        newChoiceTurn();
    }

    private void equipmentSequence(){
        System.out.println("What equipment would you like to interact with?");
        getCurrChar().getEquipment().viewEquipment();
        actionChoice = sc.nextInt();
        getCurrChar().getEquipment().processEquipment(actionChoice);
    }

    public Actionable chooseAction(ArrayList<Actionable> actionables){
        try{
            while(true){
                actionChoice = sc.nextInt();
                sc.nextLine();
                if(actionChoice > actionables.size()){
                    System.out.println("Choice is out of bounds");
                }else break;
            }
        }catch(InputMismatchException e){
            System.out.println("Since you didn't enter a number, we will use the first choice >:)");
            actionChoice = 0;
        }
        return actionables.get(actionChoice - 1);
    }
}

//package States;
//
//        import Attacks.*;
//        import Characters.Character;
//        import GameSystems.BattleSystem;
//        import States.State;
//        import Interfaces.Action;
//        import Interfaces.Actionable;
//        import Spells.Spell;
//
//        import java.util.InputMismatchException;
//        import java.util.Scanner;
//
//public class PlayerChoiceTurn extends State {
//    public PlayerChoiceTurn(BattleSystem bs) {
//        super(bs);
//    }
//
//    @Override
//    public void Start() {
//        while(true){
//            System.out.println("What will " + getCurrChar() + " do?");
//            option = sc.nextLine();
//            if(option.equalsIgnoreCase("Exit") ||
//                    option.equalsIgnoreCase("List Allies") ||
//                    option.equalsIgnoreCase("Attack") ||
//                    option.equalsIgnoreCase("Strong Attack") ||
//                    option.equalsIgnoreCase("Spell")) break;
//        }
//        option = option.toLowerCase();
//
//        int list = 1;
//        int target;
//        Character attackTarget;
//
//        switch (option){
//            case "exit":
//                break;
//            case "list allies":
//                System.out.println("Allies: ");
//                for(Character chara : allies){
//                    System.out.println(chara);
//                }
//
//                System.out.println("Enemies: ");
//                for(Character chara : enemies){
//                    System.out.println(chara);
//                }
//                newChoiceTurn();
//                break;
//            case "details":
//                for(Character chara : bs.getCharacters()){
//                    chara.currentDetails();
//                }
//                newChoiceTurn();
//                break;
//            case "attack":
//                System.out.println("What attack?");
//                for(int i=0; i<getCurrChar().getAttacks().size(); i++){
//                    System.out.println(i+1 + ". " + getCurrChar().getAttacks().get(i).getName());
//                }
//                int attackChoice = sc.nextInt();
//                Attack attackUsed = getCurrChar().getAttacks().get(attackChoice - 1);
//                System.out.println("Attack who?");
//                for(Character enemy : enemies){
//                    if(enemy.isAlive()){
//                        System.out.println(list + ". " + enemy);
//                        list++;
//                    }
//                }
//                System.out.println("Enter number: ");
//                target = sc.nextInt();
//
//                attackTarget = enemies.get(target-1);
//                bs.addAction(new Action(attackUsed, getCurrChar(), attackTarget));
//                newChoiceTurn();
//                break;
//            case "strong attack":
//                System.out.println("Attack who?");
//                for(Character enemy : enemies){
//                    if(enemy.isAlive()){
//                        System.out.println(list + ". " + enemy);
//                        list++;
//                    }
//                }
//                System.out.println("Enter number: ");
//                target = sc.nextInt();
//
//                attackTarget = enemies.get(target-1);
//                bs.addAction(new Action(new StrongAttack(), getCurrChar(), attackTarget));
//                newChoiceTurn();
//                break;
//            case "spell":
//                int spellChoice = 0;
//                Scanner sc = new Scanner(System.in);
//                System.out.println("What spells do " + getCurrChar().getName() + " want to use? Choose: ");
//                System.out.println(getCurrChar().toStringSpells());
//                try{
//                    while(true){
//                        spellChoice = sc.nextInt();
//                        sc.nextLine();
//                        if(spellChoice > getCurrChar().getSpells().size()){
//                            System.out.println("Choice is out of bounds");
//                        }else break;
//                    }
//                }catch(InputMismatchException e){
//                    System.out.println("Since you didn't enter a number, we will use the first choice >:)");
//                    spellChoice = 0;
//                }
//                Spell spellUsed = getCurrChar().getSpells().get(spellChoice - 1);
//                System.out.println("Use on who?");
//                int spellTargetInd = 0;
//                Character spellTarget;
//                if(spellUsed instanceof Spell.DamagingSpell){
//                    for(int i=0; i< enemies.size(); i++){
//                        if(enemies.get(i).isAlive()){
//                            System.out.println(i+1 + ". " + enemies.get(i));
//                        }
//                    }
//                    System.out.println("Enter number: ");
//                    spellTargetInd = sc.nextInt();
//                    spellTarget = enemies.get(spellTargetInd - 1);
//                }else{
//                    for(int i=0; i< allies.size(); i++){
//                        if(allies.get(i).isAlive()){
//                            System.out.println(i+1 + ". " + allies.get(i));
//                        }
//                    }
//                    System.out.println("Enter number: ");
//                    spellTargetInd = sc.nextInt();
//                    spellTarget = allies.get(spellTargetInd - 1);
//                }
//                bs.addAction(new Action((Actionable)spellUsed, getCurrChar(), spellTarget));
//                newChoiceTurn();
//            default:
//                newChoiceTurn();
//                break;
//        }
//    }
//}

