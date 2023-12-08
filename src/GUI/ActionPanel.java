package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import GameSystems.*;

public class ActionPanel extends JLayeredPane {
    BattleSystem bs;
    int width, height;
    boolean isSignedIn;
    JPanel currPanel;
    JButton[] moveButtons;
    ActionPanel(BattleSystem bs, int width, int height){
        this.bs = bs;
        this.width = width;
        this.height = height;
        this.isSignedIn = false;
        setBounds(5, 5, width, height);
//        JPanel background = new JPanel();
//        background.setBackground(Color.BLACK);
//        background.setBounds(0, 0, this.getWidth(), this.getHeight());
//        add(background, DEFAULT_LAYER);

        JPanel enterNamePanel = new JPanel(null); //first panel to show up
        JPanel mainActionsPanel = new JPanel(null);
        JPanel signOutPanel = new JPanel(null);
        JPanel movePanel = new JPanel(null);

        //Sign Out Panel
        signOutPanel.setBounds(10, 0, 150, height);
        JLabel lblCurrUser = new JLabel("Logged in as: Anon"); //should not be Anon except it is the name used
        JButton btnSignOut = new JButton("Log Out");
        btnSignOut.setMargin(new Insets(0, 0, 0, 0));
        btnSignOut.setFocusable(false);
        btnSignOut.setBounds(0, height-30-5, 60, 30);
        btnSignOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                signOut(signOutPanel, enterNamePanel);
            }
        });
        setBackgroundBlack(new Component[]{signOutPanel, lblCurrUser, btnSignOut});
        setForegroundWhite(new Component[]{lblCurrUser, btnSignOut});
        signOutPanel.add(btnSignOut);
        signOutPanel.add(lblCurrUser);
        add(signOutPanel, JLayeredPane.DEFAULT_LAYER);

        //Enter Name Panel
        enterNamePanel.setBounds(0, 0, width, height);
        JLabel lblName = new JLabel("Enter your name:");
        lblName.setBounds(width/2 - 100/2, ((height / 3) - 30) / 2, 100, 30);
        JTextField tfName = new JTextField();
        tfName.setBounds(width/2 - 300/2, (height/3) - ((height/3)-30)/2, 300, 30);
        tfName.setHorizontalAlignment(JTextField.CENTER);
        JButton btnName = new JButton("Enter");
        btnName.setBounds(width/2 - 100/2, (height/3)*2 - ((height/3)-30)/2, 100, 30);
        btnName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bs.getUser().name = tfName.getText();
                signIn(signOutPanel);
                switchPanel(mainActionsPanel);
            }
        });
        setBackgroundBlack(new Component[]{enterNamePanel, lblName, tfName, btnName});
        setForegroundWhite(new Component[]{lblName, tfName, btnName});
        enterNamePanel.add(lblName);
        enterNamePanel.add(tfName);
        enterNamePanel.add(btnName);
        currPanel = enterNamePanel;
        add(enterNamePanel, JLayeredPane.PALETTE_LAYER);

        //Main Actions Panel
        mainActionsPanel.setBounds(0, 0, width, height);
        JLabel lblActionMaker = new JLabel("What should <Chara> do?");
        lblActionMaker.setHorizontalTextPosition(JLabel.CENTER);
        lblActionMaker.setBounds( width/2 - 150/2, ((height / 3) - 30) / 2, 150, 30);
        JButton btnFight = new JButton("Fight");
        btnFight.setFocusable(false);
        btnFight.setBounds(width/2 - 100 - 50/2, (height/3) - ((height/3)-30)/2, 100, 30);
        btnFight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        JButton btnSpell = new JButton("Spell");
        btnSpell.setFocusable(false);
        btnSpell.setBounds(width/2 + 50/2, (height/3) - ((height/3)-30)/2, 100, 30);
        btnSpell.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        JButton btnParry = new JButton("Parry");
        btnParry.setFocusable(false);
        btnParry.setBounds(width/2 - 100 - 50/2, (height/3)*2 - ((height/3)-30)/2, 100, 30);
        btnParry.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        JButton btnItem = new JButton("Item");
        btnItem.setFocusable(false);
        btnItem.setBounds(width/2 + 50/2, (height/3)*2 - ((height/3)-30)/2, 100, 30);
        btnItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        setBackgroundBlack(new Component[]{mainActionsPanel, lblActionMaker, btnFight, btnSpell, btnParry, btnItem});
        setForegroundWhite(new Component[]{lblActionMaker, btnFight, btnSpell, btnParry, btnItem});
        mainActionsPanel.add(lblActionMaker);
        mainActionsPanel.add(btnFight);
        mainActionsPanel.add(btnSpell);
        mainActionsPanel.add(btnParry);
        mainActionsPanel.add(btnItem);
        add(mainActionsPanel, JLayeredPane.PALETTE_LAYER);


        // Move Panel
        JButton btnMove1 = new JButton();
        JButton btnMove2 = new JButton();
        JButton btnMove3 = new JButton();
        JButton btnMove4 = new JButton();
        JButton[] moveButtons = new JButton[]{btnMove1, btnMove2, btnMove3, btnMove4};
    }

    private void setBackgroundBlack(Component[] comps){
        for(Component comp : comps){
            comp.setBackground(Color.BLACK);
        }
    }
    private void setForegroundWhite(Component[] comps){
        for(Component comp : comps){
            comp.setForeground(Color.WHITE);
        }
    }
    private void switchPanel(JPanel newFront){
        this.setLayer(currPanel, JLayeredPane.DEFAULT_LAYER);
        currPanel = newFront;
        this.setLayer(currPanel, JLayeredPane.PALETTE_LAYER);
    }
    private void signIn(JPanel signOutPanel){
        isSignedIn = true;
        signOutPanel.remove(1);
        JLabel lblCurrUser = new JLabel("<html>Logged in as:<br/>" + bs.getUser().name + "</html>");
        lblCurrUser.setBackground(Color.BLACK);
        lblCurrUser.setForeground(Color.WHITE);
        lblCurrUser.setBounds(0, 0, 150, 60);
        signOutPanel.add(lblCurrUser);
        this.setLayer(signOutPanel, JLayeredPane.DRAG_LAYER);
    }
    private void signOut(JPanel signOutPanel, JPanel enterNamePanel){
        isSignedIn = false;
        switchPanel(enterNamePanel);
        this.setLayer(signOutPanel, JLayeredPane.DEFAULT_LAYER);
    }
    private void changeMovePanel(JPanel movePanel, MoveType moveType){
        int buttonCount, btnX = 0, btnY = 0;
        switch(moveType){
            case FIGHT:
                buttonCount = bs.getCurrChar().getAttacks().size();
                for(int i=0; i<buttonCount; i++){
                    btnX = i % 2 == 0 ? width/2 + 50/2 : width/2 - 100 - 50/2;
                    if(buttonCount > 2){
                        if(i < 2){
                            btnY = (height/3) - ((height/3)-30)/2;
                        }else{
                            btnY = (height/3)*2 - ((height/3)-30)/2;
                        }
                    }else btnY = (height/2) - ((height/2)-30)/2;

                    moveButtons[i].setText(bs.getCurrChar().getAttacks().get(i).getName());
                    moveButtons[i].setBounds(btnX, btnY, 100, 30);
                    moveButtons[i].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                        }
                    });
                }
                break;
            case SPELL:
                buttonCount = bs.getCurrChar().getSpells().size();
            case PARRY:
//                game.currChara.parryState();
            case ITEM:
                buttonCount = bs.getCurrChar().getItems().size();

        }
    }

    private enum MoveType{
        FIGHT,
        SPELL,
        PARRY,
        ITEM
    }
}
