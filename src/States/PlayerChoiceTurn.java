package States;

import Attacks.*;
import Characters.Character;
import GameSystems.BattleSystem;
import Interfaces.Action;
import Interfaces.Actionable;
import Items.Item;
import Spells.Spell;

import java.util.ArrayList;
import java.util.InputMismatchException;

public class PlayerChoiceTurn extends State {
    public PlayerChoiceTurn(BattleSystem bs) {
        super(bs);
    }

    Character target;

    int actionChoice;

    @Override
    public void Start() {
        chooseOptionSequence();
    }
    private void chooseOptionSequence(){
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
                chooseOptionSequence();
            }
        }

        newChoiceTurn();
    }


    private void attackSequence(){
        System.out.println("What attack does " + getCurrChar().getName() + " want to use? Choose: ");
        System.out.println(getCurrChar().listAttacks());
        System.out.println("Enter number: ");
        Attack attackUsed = (Attack) chooseAction(new ArrayList<>(getCurrChar().getAttacks())); //naa nis pinaka ubos

        System.out.println("Attack who?");
        System.out.println(target = attackUsed.chooseTarget());

        bs.addAction(new Action(attackUsed, getCurrChar(), target));

        newChoiceTurn();
    }

    private void spellSequence(){
        System.out.println("What spell does " + getCurrChar().getName() + " want to use? Choose: ");
        System.out.println(getCurrChar().listSpells());
        Spell spellUsed = (Spell) chooseAction(new ArrayList<>(getCurrChar().getSpells()));

        System.out.println("Use on who?");
        System.out.println(target = spellUsed.chooseTarget());

        bs.addAction(new Action(spellUsed, getCurrChar(), target));

        newChoiceTurn();
    }

    private void itemSequence(){
        System.out.println("What item does " + getCurrChar().getName() + " want to use? Choose: ");
        System.out.println(getCurrChar().listItems());
        Item itemUsed = (Item) chooseAction(new ArrayList<>(getCurrChar().getItems()));

        System.out.println("Use on who?");
        System.out.println(target = itemUsed.chooseTarget());

        bs.addAction(new Action(itemUsed, getCurrChar(), target));

        newChoiceTurn();
    }

    private void equipmentSequence(){
        System.out.println("What equipment would you like to interact with?");
        System.out.println(getCurrChar().getEquipment().viewEquipment());
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