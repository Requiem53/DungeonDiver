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
import java.util.List;

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
        JLabel lblActionMaker = new JLabel("What will " + getCurrChar() + " do?", SwingConstants.CENTER);
        lblActionMaker.setMaximumSize(new Dimension(400, 30));

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

        JButton btnEquip = new JButton("Equip");
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
        bs.gameWindow.setBiggerFonts(new Component[]{lblActionMaker, btnAttack, btnSpell, btnItem, btnEquip});

        BottomPanel bp = bs.gameWindow.bottomPanel;
        bp.add(Box.createRigidArea(new Dimension(5, bs.gameWindow.WINDOW_H/36)));
        lblActionMaker.setAlignmentX(Component.CENTER_ALIGNMENT);
        bp.add(lblActionMaker);
        bp.add(Box.createRigidArea(new Dimension(5, bs.gameWindow.WINDOW_H/18)));
        firstTwoBtnPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        bp.add(firstTwoBtnPanel);
        bp.add(Box.createRigidArea(new Dimension(5, bs.gameWindow.WINDOW_H/18)));
        secondTwoBtnPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        bp.add(secondTwoBtnPanel);
        bs.panelRevalRepaint(bp);

//        newChoiceTurn();
    }


    private void attackSequence(){
        JLabel lblWhatAttack = new JLabel("What attack does " + getCurrChar() + " want to use?", SwingConstants.CENTER);
        lblWhatAttack.setMaximumSize(new Dimension(400, 30));

        JPanel firstTwoBtnPanel = new JPanel();
        firstTwoBtnPanel.setLayout(new BoxLayout(firstTwoBtnPanel, BoxLayout.LINE_AXIS));
        firstTwoBtnPanel.setMaximumSize(new Dimension(300, 30));

        JPanel secondTwoBtnPanel = new JPanel();
        secondTwoBtnPanel.setLayout(new BoxLayout(secondTwoBtnPanel, BoxLayout.LINE_AXIS));
        secondTwoBtnPanel.setMaximumSize(new Dimension(300, 30));

        for(int i=0; i<getCurrChar().getAttacks().size(); i++){
            Attack attack = getCurrChar().getAttacks().get(i);
            JButton button = new JButton(attack.getName());
            button.setFocusable(false);
            button.setMaximumSize(new Dimension(135, 30));
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JLabel lblAttackWho = new JLabel("Attack who?", SwingConstants.CENTER);
                    lblAttackWho.setMaximumSize(new Dimension(200, 30));
                    bs.gameWindow.setBGBlackFGWhite(lblAttackWho);
                    bs.gameWindow.setBiggerFont(lblAttackWho);
                    bs.removeAllNotBPSP();
                    BottomPanel bp = bs.gameWindow.bottomPanel;
                    bp.add(Box.createRigidArea(new Dimension(0, bs.gameWindow.WINDOW_H/36)));
                    lblAttackWho.setAlignmentX(Component.CENTER_ALIGNMENT);
                    bp.add(lblAttackWho);

                    chooseCharacter(attack);
                }
            });
            bs.gameWindow.setBGBlackFGWhite(button);
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
        bs.gameWindow.setBiggerFont(lblWhatAttack);

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
    }

    private void spellSequence(){
        JLabel lblWhatSpell = new JLabel("What spell does " + getCurrChar() + " want to use?", SwingConstants.CENTER);
        lblWhatSpell.setMaximumSize(new Dimension(400, 30));

        JPanel firstTwoBtnPanel = new JPanel();
        firstTwoBtnPanel.setLayout(new BoxLayout(firstTwoBtnPanel, BoxLayout.LINE_AXIS));
        firstTwoBtnPanel.setMaximumSize(new Dimension(300, 30));

        JPanel secondTwoBtnPanel = new JPanel();
        secondTwoBtnPanel.setLayout(new BoxLayout(secondTwoBtnPanel, BoxLayout.LINE_AXIS));
        secondTwoBtnPanel.setMaximumSize(new Dimension(300, 30));

        for(int i=0; i<getCurrChar().getSpells().size(); i++) {
            Spell spell = getCurrChar().getSpells().get(i);
            JButton button = new JButton(spell.getName());
            button.setFocusable(false);
            button.setMaximumSize(new Dimension(135, 30));
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JLabel lblSpellWho = new JLabel("Use spell on who?", SwingConstants.CENTER);
                    lblSpellWho.setMaximumSize(new Dimension(200, 30));
                    bs.gameWindow.setBGBlackFGWhite(lblSpellWho);
                    bs.gameWindow.setBiggerFont(lblSpellWho);
                    bs.removeAllNotBPSP();
                    BottomPanel bp = bs.gameWindow.bottomPanel;
                    bp.add(Box.createRigidArea(new Dimension(0, bs.gameWindow.WINDOW_H / 36)));
                    lblSpellWho.setAlignmentX(Component.CENTER_ALIGNMENT);
                    bp.add(lblSpellWho);

                    chooseCharacter(spell);
                }
            });
            bs.gameWindow.setBGBlackFGWhite(button);
            bs.gameWindow.setBiggerFont(button);
            if (i < 2) {
                firstTwoBtnPanel.add(button);
                if (i == 0) firstTwoBtnPanel.add(Box.createRigidArea(new Dimension(30, 0)));
            } else {
                secondTwoBtnPanel.add(button);
                if (i == 2) secondTwoBtnPanel.add(Box.createRigidArea(new Dimension(30, 0)));
            }
        }
        bs.gameWindow.setBackgroundBlack(new Component[]{lblWhatSpell, firstTwoBtnPanel, secondTwoBtnPanel});
        lblWhatSpell.setForeground(Color.WHITE);
        bs.gameWindow.setBiggerFont(lblWhatSpell);

        BottomPanel bp = bs.gameWindow.bottomPanel;
        bs.removeAllNotBPSP();
        bp.add(Box.createRigidArea(new Dimension(5, bs.gameWindow.WINDOW_H/36)));
        lblWhatSpell.setAlignmentX(Component.CENTER_ALIGNMENT);
        bp.add(lblWhatSpell);
        bp.add(Box.createRigidArea(new Dimension(5, bs.gameWindow.WINDOW_H/18)));
        firstTwoBtnPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        bp.add(firstTwoBtnPanel);
        bp.add(Box.createRigidArea(new Dimension(5, bs.gameWindow.WINDOW_H/18)));
        secondTwoBtnPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        bp.add(secondTwoBtnPanel);
        bs.panelRevalRepaint(bp);
    }

    private void itemSequence(){
        JLabel lblWhatItem = new JLabel("What item does " + getCurrChar() + " want to use?", SwingConstants.CENTER);
        lblWhatItem.setMaximumSize(new Dimension(400, 30));

        JPanel firstTwoBtnPanel = new JPanel();
        firstTwoBtnPanel.setLayout(new BoxLayout(firstTwoBtnPanel, BoxLayout.LINE_AXIS));
        firstTwoBtnPanel.setMaximumSize(new Dimension(300, 30));

        JPanel secondTwoBtnPanel = new JPanel();
        secondTwoBtnPanel.setLayout(new BoxLayout(secondTwoBtnPanel, BoxLayout.LINE_AXIS));
        secondTwoBtnPanel.setMaximumSize(new Dimension(300, 30));

        for(int i=0; i<getCurrChar().getItems().size(); i++) {
            Item item = getCurrChar().getItems().get(i);
            JButton button = new JButton(item.getName());
            button.setFocusable(false);
            button.setMaximumSize(new Dimension(135, 30));
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JLabel lblItemWho = new JLabel("Use item on who?", SwingConstants.CENTER);
                    lblItemWho.setMaximumSize(new Dimension(200, 30));
                    bs.gameWindow.setBGBlackFGWhite(lblItemWho);
                    bs.gameWindow.setBiggerFont(lblItemWho);
                    bs.removeAllNotBPSP();
                    BottomPanel bp = bs.gameWindow.bottomPanel;
                    bp.add(Box.createRigidArea(new Dimension(0, bs.gameWindow.WINDOW_H / 36)));
                    lblItemWho.setAlignmentX(Component.CENTER_ALIGNMENT);
                    bp.add(lblItemWho);

                    chooseCharacter(item);
                }
            });
            bs.gameWindow.setBGBlackFGWhite(button);
            bs.gameWindow.setBiggerFont(button);
            if (i < 2) {
                firstTwoBtnPanel.add(button);
                if (i == 0) firstTwoBtnPanel.add(Box.createRigidArea(new Dimension(30, 0)));
            } else {
                secondTwoBtnPanel.add(button);
                if (i == 2) secondTwoBtnPanel.add(Box.createRigidArea(new Dimension(30, 0)));
            }
        }
        bs.gameWindow.setBackgroundBlack(new Component[]{lblWhatItem, firstTwoBtnPanel, secondTwoBtnPanel});
        lblWhatItem.setForeground(Color.WHITE);
        bs.gameWindow.setBiggerFont(lblWhatItem);

        BottomPanel bp = bs.gameWindow.bottomPanel;
        bs.removeAllNotBPSP();
        bp.add(Box.createRigidArea(new Dimension(5, bs.gameWindow.WINDOW_H/36)));
        lblWhatItem.setAlignmentX(Component.CENTER_ALIGNMENT);
        bp.add(lblWhatItem);
        bp.add(Box.createRigidArea(new Dimension(5, bs.gameWindow.WINDOW_H/18)));
        firstTwoBtnPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        bp.add(firstTwoBtnPanel);
        bp.add(Box.createRigidArea(new Dimension(5, bs.gameWindow.WINDOW_H/18)));
        secondTwoBtnPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        bp.add(secondTwoBtnPanel);
        bs.panelRevalRepaint(bp);
    }

    private void equipmentSequence(){
        System.out.println("What equipment would you like to interact with?");
        System.out.println(getCurrChar().getEquipment().viewEquipment());
        actionChoice = sc.nextInt();
        getCurrChar().getEquipment().processEquipment(actionChoice);
    }

    private void chooseCharacter(Actionable actionable){
        List<Character> characters = actionable.chooseTargets();

        JPanel firstTwoBtnPanel = new JPanel();
        firstTwoBtnPanel.setLayout(new BoxLayout(firstTwoBtnPanel, BoxLayout.LINE_AXIS));
        firstTwoBtnPanel.setMaximumSize(new Dimension(280, 30));

        JPanel secondTwoBtnPanel = new JPanel();
        secondTwoBtnPanel.setLayout(new BoxLayout(secondTwoBtnPanel, BoxLayout.LINE_AXIS));
        secondTwoBtnPanel.setMaximumSize(new Dimension(280, 30));

        for(int i=0; i<characters.size(); i++){
            Character chara = characters.get(i);
            JButton button = new JButton(chara.getName());
            button.setFocusable(false);
            button.setMaximumSize(new Dimension(125, 30));
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    bs.addAction(new Action(actionable, getCurrChar(), chara));
                    newChoiceTurn();
                }
            });
            bs.gameWindow.setBGBlackFGWhite(button);
            bs.gameWindow.setBiggerFont(button);
            if(i < 2) {
                firstTwoBtnPanel.add(button);
                if(i == 0) firstTwoBtnPanel.add(Box.createRigidArea(new Dimension(30, 0)));
            }
            else {
                secondTwoBtnPanel.add(button);
                if(i == 2) secondTwoBtnPanel.add(Box.createRigidArea(new Dimension(30, 0)));
            }
        }

        bs.gameWindow.setBackgroundBlack(new Component[]{firstTwoBtnPanel, secondTwoBtnPanel});

        BottomPanel bp = bs.gameWindow.bottomPanel;
        bs.removeAllNotBPSP();
        bp.add(Box.createRigidArea(new Dimension(5, bs.gameWindow.WINDOW_H/18)));
        firstTwoBtnPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        bp.add(firstTwoBtnPanel);
        bp.add(Box.createRigidArea(new Dimension(5, bs.gameWindow.WINDOW_H/18)));
        secondTwoBtnPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        bp.add(secondTwoBtnPanel);
        bs.panelRevalRepaint(bp);
    }

}