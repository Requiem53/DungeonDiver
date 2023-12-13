package States;

import Attacks.*;
import Characters.Character;
import GUI.BottomPanel;
import GameSystems.BattleSystem;
import Interfaces.Action;
import Interfaces.Actionable;
import Items.Item;
import Spells.Spell;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        bs.removeAllNotBPSP();
        bs.panelRevalRepaint(bs.gameWindow.bottomPanel);
        JLabel lblActionMaker = new JLabel("What will " + getCurrChar() + " do?");
        lblActionMaker.setMaximumSize(new Dimension(100, 30));

        JPanel firstTwoBtnPanel = new JPanel();
        firstTwoBtnPanel.setLayout(new BoxLayout(firstTwoBtnPanel, BoxLayout.LINE_AXIS));
        firstTwoBtnPanel.setMaximumSize(new Dimension(230, 30));

        JButton btnAttack = new JButton("Attack");
        btnAttack.setFocusable(false);
        btnAttack.setMaximumSize(new Dimension(100, 30));
        btnAttack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                attackSequence();
            }
        });
        firstTwoBtnPanel.add(btnAttack);
        firstTwoBtnPanel.add(Box.createRigidArea(new Dimension(30, 0)));

        JButton btnSpell = new JButton("Spell");
        btnSpell.setFocusable(false);
        btnSpell.setMaximumSize(new Dimension(100, 30));
        btnSpell.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                spellSequence();
            }
        });
        firstTwoBtnPanel.add(btnSpell);

        JPanel secondTwoBtnPanel = new JPanel();
        secondTwoBtnPanel.setLayout(new BoxLayout(secondTwoBtnPanel, BoxLayout.LINE_AXIS));
        secondTwoBtnPanel.setMaximumSize(new Dimension(230, 30));


        JButton btnItem = new JButton("Item");
        btnItem.setFocusable(false);
        btnItem.setMaximumSize(new Dimension(100, 30));
        btnItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                itemSequence();
            }
        });
        secondTwoBtnPanel.add(btnItem);
        secondTwoBtnPanel.add(Box.createRigidArea(new Dimension(30, 0)));

        JButton btnEquip = new JButton("Item");
        btnEquip.setFocusable(false);
        btnEquip.setMaximumSize(new Dimension(100, 30));
        btnEquip.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                equipmentSequence();
            }
        });
        secondTwoBtnPanel.add(btnEquip);

        bs.gameWindow.setBackgroundBlack(new Component[]{lblActionMaker, btnAttack, btnSpell, btnItem, btnEquip,
            firstTwoBtnPanel, secondTwoBtnPanel});
        bs.gameWindow.setForegroundWhite(new Component[]{lblActionMaker, btnAttack, btnSpell, btnItem, btnEquip});

        BottomPanel bp = bs.gameWindow.bottomPanel;
        bp.add(Box.createRigidArea(new Dimension(0, bs.gameWindow.WINDOW_H/6)));
        lblActionMaker.setAlignmentX(Component.CENTER_ALIGNMENT);
        bp.add(lblActionMaker);
        bp.add(Box.createRigidArea(new Dimension(0, bs.gameWindow.WINDOW_H/6)));
        firstTwoBtnPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        bp.add(firstTwoBtnPanel);
        bp.add(Box.createRigidArea(new Dimension(0, bs.gameWindow.WINDOW_H/6)));
        secondTwoBtnPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        bp.add(secondTwoBtnPanel);
        bs.panelRevalRepaint(bp);

//        newChoiceTurn();
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