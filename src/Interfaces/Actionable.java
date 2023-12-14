package Interfaces;

import Attacks.Attack;
import Characters.Character;
import GUI.BottomPanel;
import GameSystems.BattleSystem;
import States.State;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Scanner;

public abstract class Actionable {
    protected String name;

    public abstract String doAction(Character actor, Character target);

    public int getSpeed(){
        return 0;
    }

    public Character chooseTarget(){
        if(this instanceof Damaging) return chooseCharacter(State.randomEnemies);
        else if(this instanceof Healing) return chooseCharacter(State.livingAllies);
        else if(this instanceof StatusInflicting)
            if (((StatusInflicting) this).isBuff()) return chooseCharacter(State.livingAllies);
            else return chooseCharacter(State.randomEnemies);
        return null;
    }

    private Character chooseCharacter(List<Character> characters){
        JPanel firstTwoBtnPanel = new JPanel();
        firstTwoBtnPanel.setLayout(new BoxLayout(firstTwoBtnPanel, BoxLayout.LINE_AXIS));
        firstTwoBtnPanel.setMaximumSize(new Dimension(230, 30));

        JPanel secondTwoBtnPanel = new JPanel();
        secondTwoBtnPanel.setLayout(new BoxLayout(firstTwoBtnPanel, BoxLayout.LINE_AXIS));
        secondTwoBtnPanel.setMaximumSize(new Dimension(230, 30));

        for(int i=0; i<characters.size(); i++){
            Character chara = characters.get(i);
            JButton button = new JButton(chara.getName());
            button.setFocusable(false);
            button.setMaximumSize(new Dimension(100, 30));
            int finalI = i;
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    return characters.get(finalI);
                }
            });
            button.setBackground(Color.BLACK);
            button.setForeground(Color.WHITE);
            if(i < 2) {
                firstTwoBtnPanel.add(button);
                if(i == 0) firstTwoBtnPanel.add(Box.createRigidArea(new Dimension(30, 0)));
            }
            else {
                secondTwoBtnPanel.add(button);
                if(i == 2) secondTwoBtnPanel.add(Box.createRigidArea(new Dimension(30, 0)));
            }
        }

        bs.gameWindow.setBackgroundBlack(new Component[]{lblWhatAttack, firstTwoBtnPanel, secondTwoBtnPanel});
        lblWhatAttack.setForeground(Color.WHITE);

        BottomPanel bp = bs.gameWindow.bottomPanel;
        bs.removeAllNotBPSP();
        bp.add(Box.createRigidArea(new Dimension(5, bs.gameWindow.WINDOW_H/36)));
        lblWhatAttack.setAlignmentX(Component.CENTER_ALIGNMENT);
        bp.add(lblWhatAttack);
        bp.add(Box.createRigidArea(new Dimension(5, bs.gameWindow.WINDOW_H/18)));
        firstTwoBtnPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        bp.add(firstTwoBtnPanel);
        bp.add(Box.createRigidArea(new Dimension(5, bs.gameWindow.WINDOW_H/18)));
        secondTwoBtnPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        bp.add(secondTwoBtnPanel);
        bs.panelRevalRepaint(bp);

        int actionChoice;
        Scanner sc = new Scanner(System.in);
        System.out.println(BattleSystem.outputCharacters(characters));
        System.out.println("Enter number: ");
        actionChoice = sc.nextInt();
        return characters.get(actionChoice - 1);
    }

    public String toString(){
        return name;
    }
    public String getName(){
        return name;
    }
}
