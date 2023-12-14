package States;

import Characters.AllyClass;
import Characters.AllyClassList;
import Characters.Character;
import GUI.BottomPanel;
import GameSystems.BattleSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateParty extends State{

    int doneCharas;
    public CreateParty(BattleSystem bs) {
        super(bs);
        doneCharas = 0;
    }

    @Override
    public void Start() {
        int width = bs.gameWindow.WINDOW_W;
        int height = bs.gameWindow.WINDOW_H/3;
        JLabel lblEnterName = new JLabel("(1/4) Enter your character's name:");
        lblEnterName.setSize(100, 30);
        JTextField tfCharaName = new JTextField();
        tfCharaName.setMaximumSize(new Dimension(400, 30));
        tfCharaName.setHorizontalAlignment(JTextField.CENTER);
        JPanel classButtonArea = new JPanel(new GridLayout(1, 4));
        classButtonArea.setMaximumSize(new Dimension(520, 30));
        JButton btnWarrior = new JButton("Warrior");
        btnWarrior.setSize(100, 30);
        btnWarrior.setFocusable(false);
        btnWarrior.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = tfCharaName.getText();
                if(name.equals("") || name.equals("Enter name!")){
                    tfCharaName.setText("Enter name!");
                }else{
                    tfCharaName.setText("");
                    bs.getParty().addMember(new Character.Ally(name, new AllyClass.Warrior()));
                    doneCharas++;
                    if(doneCharas >= 4){
                        bs.setState(new DescendLevel(bs));
                    }
                    lblEnterName.setText("(" + (doneCharas+1) + "/4) Enter your character's name:");
                    bs.panelRevalRepaint(bs.gameWindow.bottomPanel);
                }
            }
        });
        classButtonArea.add(btnWarrior);
        JButton btnRogue = new JButton("Rogue");
        btnRogue.setSize(100, 30);
        btnRogue.setFocusable(false);
        btnRogue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = tfCharaName.getText();
                if(name.equals("") || name.equals("Enter name!")){
                    tfCharaName.setText("Enter name!");
                }else{
                    tfCharaName.setText("");
                    bs.getParty().addMember(new Character.Ally(name, new AllyClass.Rogue()));
                    doneCharas++;
                    if(doneCharas >= 4){
                        bs.setState(new DescendLevel(bs));
                    }
                    lblEnterName.setText("(" + (doneCharas+1) + "/4) Enter your character's name:");
                    bs.panelRevalRepaint(bs.gameWindow.bottomPanel);
                }
            }
        });
        classButtonArea.add(btnRogue);
        JButton btnMage = new JButton("Mage");
        btnMage.setSize(100, 30);
        btnMage.setFocusable(false);
        btnMage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = tfCharaName.getText();
                if(name.equals("") || name.equals("Enter name!")){
                    tfCharaName.setText("Enter name!");
                }else{
                    tfCharaName.setText("");
                    bs.getParty().addMember(new Character.Ally(name, new AllyClass.Mage()));
                    doneCharas++;
                    if(doneCharas >= 4){
                        bs.setState(new DescendLevel(bs));
                    }
                    lblEnterName.setText("(" + (doneCharas+1) + "/4) Enter your character's name:");
                    bs.panelRevalRepaint(bs.gameWindow.bottomPanel);
                }
            }
        });
        classButtonArea.add(btnMage);
        JButton btnHealer = new JButton("Healer");
        btnHealer.setSize(100, 30);
        btnHealer.setFocusable(false);
        btnHealer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = tfCharaName.getText();
                if(name.equals("") || name.equals("Enter name!")){
                    tfCharaName.setText("Enter name!");
                }else{
                    tfCharaName.setText("");
                    bs.getParty().addMember(new Character.Ally(name, new AllyClass.Healer()));
                    doneCharas++;
                    if(doneCharas >= 4){
                        bs.setState(new DescendLevel(bs));
                    }
                    lblEnterName.setText("(" + (doneCharas+1) + "/4) Enter your character's name:");
                    bs.panelRevalRepaint(bs.gameWindow.bottomPanel);
                }
            }
        });
        classButtonArea.add(btnHealer);
        bs.gameWindow.setBackgroundBlack(new Component[]{lblEnterName, tfCharaName, classButtonArea, btnWarrior,
                btnRogue, btnMage, btnHealer});
        bs.gameWindow.setForegroundWhite(new Component[]{lblEnterName, tfCharaName, btnWarrior, btnRogue,
                btnMage, btnHealer});
        BottomPanel bp = bs.gameWindow.bottomPanel;
        bp.add(Box.createRigidArea(new Dimension(0, height/8)));
        lblEnterName.setAlignmentX(Component.CENTER_ALIGNMENT);
        bp.add(lblEnterName);
        bp.add(Box.createRigidArea(new Dimension(0, height/6)));
        tfCharaName.setAlignmentX(Component.CENTER_ALIGNMENT);
        bp.add(tfCharaName);
        bp.add(Box.createRigidArea(new Dimension(0, height/6)));
        classButtonArea.setAlignmentX(Component.CENTER_ALIGNMENT);
        bp.add(classButtonArea);
        bs.panelRevalRepaint(bp);

        System.out.println("reachable?");

//        String nameInput;
//        AllyClass allyClass;
//
//        System.out.println("Add new party members: ");
//        for (int i = 0; i < 4; i++){
//            System.out.println((i+1) + "/4" +" What is the name of your new party member?");
//            nameInput = sc.nextLine();
//            allyClass = AllyClassList.getInstance().createNewClass();
//            bs.getParty().addMember(new Character.Ally(nameInput, allyClass));
//        }
//
//        System.out.println("Here is your party: ");
//        for(Character ally : bs.getPartyMembers()){
//            System.out.println(ally + " - " + ally.getClassName());
//        }
//
//        bs.setState(new DescendLevel(bs));
    }
}
