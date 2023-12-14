package States;

import Characters.Character;
import Equipment.Armor;
import Equipment.Equippable;
import Equipment.Weapon;
import GUI.BottomPanel;
import GameSystems.BattleSystem;
import Interfaces.Actionable;
import Items.HealingItem;
import Items.Item;
import Items.StatusItem;
import Spells.DamagingSpell;
import Spells.Spell;
import Spells.StatusSpell;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Shop extends State{
    Scanner sc;

    public Shop(BattleSystem bs) {
        super(bs);
        sc = new Scanner(System.in);
    }

    @Override
    public void Start() {
        //Add small shop that sells weapons and armor
        //Add option to learn new spells, attacks
        //Add sell items
        //Add revive allies option
        fullyRest();

        bs.removeAllNotBPSP();
        JLabel lblShop = new JLabel("Welcome to the Dungeon Shop! What do you want to buy?", SwingConstants.CENTER);
        lblShop.setMaximumSize(new Dimension(400, 30));

        JPanel firstBtnPanel = new JPanel();
        firstBtnPanel.setLayout(new BoxLayout(firstBtnPanel, BoxLayout.LINE_AXIS));
        firstBtnPanel.setMaximumSize(new Dimension(360, 30));

        JButton btnWeapons = new JButton("Weapons");
        btnWeapons.setFocusable(false);
        btnWeapons.setMaximumSize(new Dimension(100, 30));
        btnWeapons.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                weaponsShop();
            }
        });
        firstBtnPanel.add(btnWeapons);
        firstBtnPanel.add(Box.createRigidArea(new Dimension(30, 0)));

        JButton btnArmors = new JButton("Armors");
        btnArmors.setFocusable(false);
        btnArmors.setMaximumSize(new Dimension(100, 30));
        btnArmors.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                armorsShop();
            }
        });
        firstBtnPanel.add(btnArmors);
        firstBtnPanel.add(Box.createRigidArea(new Dimension(30, 0)));

        JButton btnItems = new JButton("Items");
        btnItems.setFocusable(false);
        btnItems.setMaximumSize(new Dimension(100, 30));
        btnItems.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                itemsShop();
            }
        });
        firstBtnPanel.add(btnItems);

        JPanel secondBtnPanel = new JPanel();
        secondBtnPanel.setLayout(new BoxLayout(secondBtnPanel, BoxLayout.LINE_AXIS));
        secondBtnPanel.setMaximumSize(new Dimension(230, 30));

        JButton btnSpells = new JButton("Spells");
        btnSpells.setFocusable(false);
        btnSpells.setMaximumSize(new Dimension(100, 30));
        btnSpells.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                spellsShop();
            }
        });
        secondBtnPanel.add(btnSpells);
        secondBtnPanel.add(Box.createRigidArea(new Dimension(30, 0)));

        JButton btnExit = new JButton("Exit");
        btnExit.setFocusable(false);
        btnExit.setMaximumSize(new Dimension(100, 30));
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bs.setState(new DescendLevel(bs));
            }
        });
        secondBtnPanel.add(btnExit);

        bs.gameWindow.setBackgroundBlack(new Component[]{lblShop, btnWeapons, btnArmors, btnItems, btnSpells,
                firstBtnPanel, secondBtnPanel, btnExit});
        bs.gameWindow.setForegroundWhite(new Component[]{lblShop, btnWeapons, btnArmors, btnItems, btnSpells,
                btnExit});

        BottomPanel bp = bs.gameWindow.bottomPanel;
        bp.add(Box.createRigidArea(new Dimension(5, bs.gameWindow.WINDOW_H/36)));
        lblShop.setAlignmentX(Component.CENTER_ALIGNMENT);
        bp.add(lblShop);
        bp.add(Box.createRigidArea(new Dimension(5, bs.gameWindow.WINDOW_H/18)));
        firstBtnPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        bp.add(firstBtnPanel);
        bp.add(Box.createRigidArea(new Dimension(5, bs.gameWindow.WINDOW_H/18)));
        secondBtnPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        bp.add(secondBtnPanel);
        bs.panelRevalRepaint(bp);


//        System.out.println("Welcome to the Dungeon Shop! What do you want to buy? Or would you like to rest?");
//        System.out.println("1. Weapons\n2. Armors\n3. Items\n4. Spell Scrolls\n5. Rest\n6. Nothing");
//        int shopChoice = sc.nextInt();
//        boolean doneShopping;
//        switch (shopChoice) {
//            case 1 -> doneShopping = weaponsShop();
//            case 2 -> doneShopping = armorsShop();
//            case 3 -> doneShopping = itemsShop();
//            case 4 -> doneShopping = spellsShop();
//            case 5 -> doneShopping = fullyRest();
//            case 6 -> doneShopping = false;
//            default -> doneShopping = true;
//        }
//        if(doneShopping) bs.setState(new Shop(bs));
//
//        bs.setState(new DescendLevel(bs));
    }

    private void fullyRest(){
        System.out.println(bs.restParty());
        State.livingAllies.clear();
        initializeAllies();
    }

    private void weaponsShop(){          //return true if done shopping, false if switched shop
        List<Weapon> weapons = new ArrayList<>(){{add(new Weapon.Steel_Sword());
        add(new Weapon.Sword_Of_Light()); add(new Weapon.Sharp_Dagger()); add(new Weapon.Executioner_Blade());
        add(new Weapon.Advanced_Wand()); add(new Weapon.Elven_Wand()); add(new Weapon.Springwood_Staff());
        add(new Weapon.Holy_Staff());}};

        int[] prices = new int[]{200, 400, 200, 400, 200, 400, 200, 400};

        JLabel lblWhatWeapon = new JLabel("What weapon do you want to buy?", SwingConstants.CENTER);
        lblWhatWeapon.setMaximumSize(new Dimension(200, 30));

        JPanel firstBtnPanel = new JPanel();
        firstBtnPanel.setLayout(new BoxLayout(firstBtnPanel, BoxLayout.LINE_AXIS));
        firstBtnPanel.setMaximumSize(new Dimension(660, 30));

        JPanel secondBtnPanel = new JPanel();
        secondBtnPanel.setLayout(new BoxLayout(secondBtnPanel, BoxLayout.LINE_AXIS));
        secondBtnPanel.setMaximumSize(new Dimension(660, 30));

        JPanel thirdBtnPanel = new JPanel();
        thirdBtnPanel.setLayout(new BoxLayout(thirdBtnPanel, BoxLayout.LINE_AXIS));
        thirdBtnPanel.setMaximumSize(new Dimension(660, 30));

        for(int i=0; i<weapons.size(); i++){
            Weapon weapon = weapons.get(i);
            int price = prices[i];
            JButton button = new JButton(weapon.getName() + "(" + prices[i] + ")");
//            button.setFont(new Font("Arial", Font.PLAIN, 10));
            button.setFocusable(false);
            button.setMaximumSize(new Dimension(200, 30));
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(validateMoney(price)){
                        chooseRecipient(weapon, price);
                    }
                }
            });
            bs.gameWindow.setBGBlackFGWhite(button);
            if(i < 3) {
                firstBtnPanel.add(button);
                if(i != 2) firstBtnPanel.add(Box.createRigidArea(new Dimension(30, 0)));
            }
            else if(i < 6){
                secondBtnPanel.add(button);
                if(i != 5) secondBtnPanel.add(Box.createRigidArea(new Dimension(30, 0)));
            }
            else{
                thirdBtnPanel.add(button);
                thirdBtnPanel.add(Box.createRigidArea(new Dimension(30, 0)));
            }
        }

        JButton btnExit = new JButton("Exit");
        btnExit.setFocusable(false);
        btnExit.setMaximumSize(new Dimension(200, 30));
        bs.gameWindow.setBGBlackFGWhite(btnExit);
        thirdBtnPanel.add(btnExit);
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bs.setState(new Shop(bs));
            }
        });

        bs.gameWindow.setBackgroundBlack(new Component[]{lblWhatWeapon, firstBtnPanel, secondBtnPanel,
            thirdBtnPanel});
        lblWhatWeapon.setForeground(Color.WHITE);

        BottomPanel bp = bs.gameWindow.bottomPanel;
        bs.removeAllNotBPSP();
        bp.add(Box.createRigidArea(new Dimension(5, bs.gameWindow.WINDOW_H/36)));
        lblWhatWeapon.setAlignmentX(Component.CENTER_ALIGNMENT);
        bp.add(lblWhatWeapon);
        bp.add(Box.createRigidArea(new Dimension(5, bs.gameWindow.WINDOW_H/36)));
        firstBtnPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        bp.add(firstBtnPanel);
        bp.add(Box.createRigidArea(new Dimension(5, bs.gameWindow.WINDOW_H/36)));
        secondBtnPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        bp.add(secondBtnPanel);
        bp.add(Box.createRigidArea(new Dimension(5, bs.gameWindow.WINDOW_H/36)));
        thirdBtnPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        bp.add(thirdBtnPanel);
        bs.panelRevalRepaint(bp);
    }

    private void armorsShop(){
        List<Armor> armors = new ArrayList<>() {{add(new Armor.Steel_Chestplate()); add(new Armor.Dark_Cloak());
        add(new Armor.Elven_Robe()); add(new Armor.Cleric_Garment());}};

        int price = 300;

        JLabel lblWhatArmor = new JLabel("What weapon do you want to buy?", SwingConstants.CENTER);
        lblWhatArmor.setMaximumSize(new Dimension(200, 30));

        JPanel firstBtnPanel = new JPanel();
        firstBtnPanel.setLayout(new BoxLayout(firstBtnPanel, BoxLayout.LINE_AXIS));
        firstBtnPanel.setMaximumSize(new Dimension(660, 30));

        JPanel secondBtnPanel = new JPanel();
        secondBtnPanel.setLayout(new BoxLayout(secondBtnPanel, BoxLayout.LINE_AXIS));
        secondBtnPanel.setMaximumSize(new Dimension(430, 30));

        for(int i=0; i<armors.size(); i++){
            Armor armor = armors.get(i);
            JButton button = new JButton(armor.getName() + "(" + price + ")");
//            button.setFont(new Font("Arial", Font.PLAIN, 10));
            button.setFocusable(false);
            button.setMaximumSize(new Dimension(200, 30));
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(validateMoney(price)){
                        chooseRecipient(armor, price);
                    }
                }
            });
            bs.gameWindow.setBGBlackFGWhite(button);
            if(i < 3) {
                firstBtnPanel.add(button);
                if(i != 2) firstBtnPanel.add(Box.createRigidArea(new Dimension(30, 0)));
            }
            else{
                secondBtnPanel.add(button);
                secondBtnPanel.add(Box.createRigidArea(new Dimension(30, 0)));
            }
        }

        JButton btnExit = new JButton("Exit");
        btnExit.setFocusable(false);
        btnExit.setMaximumSize(new Dimension(200, 30));
        bs.gameWindow.setBGBlackFGWhite(btnExit);
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bs.setState(new Shop(bs));
            }
        });
        secondBtnPanel.add(btnExit);

        bs.gameWindow.setBackgroundBlack(new Component[]{lblWhatArmor, firstBtnPanel, secondBtnPanel});
        lblWhatArmor.setForeground(Color.WHITE);

        BottomPanel bp = bs.gameWindow.bottomPanel;
        bs.removeAllNotBPSP();
        bp.add(Box.createRigidArea(new Dimension(5, bs.gameWindow.WINDOW_H/36)));
        lblWhatArmor.setAlignmentX(Component.CENTER_ALIGNMENT);
        bp.add(lblWhatArmor);
        bp.add(Box.createRigidArea(new Dimension(5, bs.gameWindow.WINDOW_H/18)));
        firstBtnPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        bp.add(firstBtnPanel);
        bp.add(Box.createRigidArea(new Dimension(5, bs.gameWindow.WINDOW_H/18)));
        secondBtnPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        bp.add(secondBtnPanel);
        bs.panelRevalRepaint(bp);
    }
    private void itemsShop(){
        List<Item> items = new ArrayList<>() {{add(new HealingItem.HealingPotion());
        add(new HealingItem.GreaterHealingPotion()); add(new StatusItem.SmokeBomb()); add(new StatusItem.HealthPlus());}};

        int[] prices = new int[] {50, 100, 50, 150};

        JLabel lblWhatItem = new JLabel("What item do you want to buy?", SwingConstants.CENTER);
        lblWhatItem.setMaximumSize(new Dimension(200, 30));

        JPanel firstBtnPanel = new JPanel();
        firstBtnPanel.setLayout(new BoxLayout(firstBtnPanel, BoxLayout.LINE_AXIS));
        firstBtnPanel.setMaximumSize(new Dimension(660, 30));

        JPanel secondBtnPanel = new JPanel();
        secondBtnPanel.setLayout(new BoxLayout(secondBtnPanel, BoxLayout.LINE_AXIS));
        secondBtnPanel.setMaximumSize(new Dimension(430, 30));

        for(int i=0; i<items.size(); i++){
            Item item = items.get(i);
            int price = prices[i];
            JButton button = new JButton(item.getName() + "(" + price + ")");
//            button.setFont(new Font("Arial", Font.PLAIN, 10));
            button.setFocusable(false);
            button.setMaximumSize(new Dimension(200, 30));
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(validateMoney(price)){
                        chooseRecipient(item, price);
                    }
                }
            });
            bs.gameWindow.setBGBlackFGWhite(button);
            if(i < 3) {
                firstBtnPanel.add(button);
                if(i != 2) firstBtnPanel.add(Box.createRigidArea(new Dimension(30, 0)));
            }
            else{
                secondBtnPanel.add(button);
                secondBtnPanel.add(Box.createRigidArea(new Dimension(30, 0)));
            }
        }

        JButton btnExit = new JButton("Exit");
        btnExit.setFocusable(false);
        btnExit.setMaximumSize(new Dimension(200, 30));
        bs.gameWindow.setBGBlackFGWhite(btnExit);
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bs.setState(new Shop(bs));
            }
        });
        secondBtnPanel.add(btnExit);

        bs.gameWindow.setBackgroundBlack(new Component[]{lblWhatItem, firstBtnPanel, secondBtnPanel});
        lblWhatItem.setForeground(Color.WHITE);

        BottomPanel bp = bs.gameWindow.bottomPanel;
        bs.removeAllNotBPSP();
        bp.add(Box.createRigidArea(new Dimension(5, bs.gameWindow.WINDOW_H/36)));
        lblWhatItem.setAlignmentX(Component.CENTER_ALIGNMENT);
        bp.add(lblWhatItem);
        bp.add(Box.createRigidArea(new Dimension(5, bs.gameWindow.WINDOW_H/18)));
        firstBtnPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        bp.add(firstBtnPanel);
        bp.add(Box.createRigidArea(new Dimension(5, bs.gameWindow.WINDOW_H/18)));
        secondBtnPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        bp.add(secondBtnPanel);
        bs.panelRevalRepaint(bp);
    }
    private void spellsShop(){
        List<Spell> spells = new ArrayList<>() {{add(new DamagingSpell.Hyper_Beam()); add(new DamagingSpell.Celestial_Ray());
        add(new StatusSpell.Momentum()); add(new StatusSpell.Armor_Shred()); add(new StatusSpell.Lazy());
        add(new StatusSpell.Truce()); add(new StatusSpell.Anti_Magic());}};

        int[] prices = new int[] {200, 400, 150, 250, 150, 150, 150};

        JLabel lblWhatSpell = new JLabel("What spell scroll do you want to buy?", SwingConstants.CENTER);
        lblWhatSpell.setMaximumSize(new Dimension(200, 30));

        JPanel firstBtnPanel = new JPanel();
        firstBtnPanel.setLayout(new BoxLayout(firstBtnPanel, BoxLayout.LINE_AXIS));
        firstBtnPanel.setMaximumSize(new Dimension(660, 30));

        JPanel secondBtnPanel = new JPanel();
        secondBtnPanel.setLayout(new BoxLayout(secondBtnPanel, BoxLayout.LINE_AXIS));
        secondBtnPanel.setMaximumSize(new Dimension(660, 30));

        JPanel thirdBtnPanel = new JPanel();
        thirdBtnPanel.setLayout(new BoxLayout(thirdBtnPanel, BoxLayout.LINE_AXIS));
        thirdBtnPanel.setMaximumSize(new Dimension(660, 30));

        for(int i=0; i<spells.size(); i++){
            Spell spell = spells.get(i);
            int price = prices[i];
            JButton button = new JButton(spell.getName() + "(" + prices[i] + ")");
//            button.setFont(new Font("Arial", Font.PLAIN, 10));
            button.setFocusable(false);
            button.setMaximumSize(new Dimension(200, 30));
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(validateMoney(price)){
                        chooseRecipient(spell, price);
                    }
                }
            });
            bs.gameWindow.setBGBlackFGWhite(button);
            if(i < 3) {
                firstBtnPanel.add(button);
                if(i != 2) firstBtnPanel.add(Box.createRigidArea(new Dimension(30, 0)));
            }
            else if(i < 6){
                secondBtnPanel.add(button);
                if(i != 5) secondBtnPanel.add(Box.createRigidArea(new Dimension(30, 0)));
            }
            else{
                thirdBtnPanel.add(button);
                thirdBtnPanel.add(Box.createRigidArea(new Dimension(30, 0)));
            }
        }

        JButton btnExit = new JButton("Exit");
        btnExit.setFocusable(false);
        btnExit.setMaximumSize(new Dimension(200, 30));
        bs.gameWindow.setBGBlackFGWhite(btnExit);
        thirdBtnPanel.add(btnExit);
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bs.setState(new Shop(bs));
            }
        });

        bs.gameWindow.setBackgroundBlack(new Component[]{lblWhatSpell, firstBtnPanel, secondBtnPanel,
                thirdBtnPanel});
        lblWhatSpell.setForeground(Color.WHITE);

        BottomPanel bp = bs.gameWindow.bottomPanel;
        bs.removeAllNotBPSP();
        bp.add(Box.createRigidArea(new Dimension(5, bs.gameWindow.WINDOW_H/36)));
        lblWhatSpell.setAlignmentX(Component.CENTER_ALIGNMENT);
        bp.add(lblWhatSpell);
        bp.add(Box.createRigidArea(new Dimension(5, bs.gameWindow.WINDOW_H/36)));
        firstBtnPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        bp.add(firstBtnPanel);
        bp.add(Box.createRigidArea(new Dimension(5, bs.gameWindow.WINDOW_H/36)));
        secondBtnPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        bp.add(secondBtnPanel);
        bp.add(Box.createRigidArea(new Dimension(5, bs.gameWindow.WINDOW_H/36)));
        thirdBtnPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        bp.add(thirdBtnPanel);
        bs.panelRevalRepaint(bp);
    }
    private void chooseRecipient(Actionable actionable, int price){
        List<Character> partyMembers = bs.getPartyMembers();
        JLabel lblBindActionbleWho = new JLabel("Bind " + actionable.getName() + " on who?", SwingConstants.CENTER);
        lblBindActionbleWho.setMaximumSize(new Dimension(250, 30));

        JPanel firstBtnPanel = new JPanel();
        firstBtnPanel.setLayout(new BoxLayout(firstBtnPanel, BoxLayout.LINE_AXIS));
        firstBtnPanel.setMaximumSize(new Dimension(280, 30));

        JPanel secondBtnPanel = new JPanel();
        secondBtnPanel.setLayout(new BoxLayout(secondBtnPanel, BoxLayout.LINE_AXIS));
        secondBtnPanel.setMaximumSize(new Dimension(280, 30));

        for(int i=0; i<partyMembers.size(); i++){
            Character chara = partyMembers.get(i);
            JButton button = new JButton(chara.getName());
            button.setFocusable(false);
            button.setMaximumSize(new Dimension(125, 30));
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(actionable instanceof Item) chara.addItem((Item) actionable);
                    else chara.addSpell((Spell) actionable);
                    bs.getParty().spendGold(price);
                    bs.setState(new Shop(bs));
                }
            });
            bs.gameWindow.setBGBlackFGWhite(button);
            if(i < 2) {
                firstBtnPanel.add(button);
                if(i == 0) firstBtnPanel.add(Box.createRigidArea(new Dimension(30, 0)));
            }
            else {
                secondBtnPanel.add(button);
                if(i == 2) secondBtnPanel.add(Box.createRigidArea(new Dimension(30, 0)));
            }
        }
        bs.gameWindow.setBackgroundBlack(new Component[]{lblBindActionbleWho, firstBtnPanel, secondBtnPanel});
        lblBindActionbleWho.setForeground(Color.WHITE);

        BottomPanel bp = bs.gameWindow.bottomPanel;
        bs.removeAllNotBPSP();
        bp.add(Box.createRigidArea(new Dimension(5, bs.gameWindow.WINDOW_H/36)));
        lblBindActionbleWho.setAlignmentX(Component.CENTER_ALIGNMENT);
        bp.add(lblBindActionbleWho);
        bp.add(Box.createRigidArea(new Dimension(5, bs.gameWindow.WINDOW_H/18)));
        firstBtnPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        bp.add(firstBtnPanel);
        bp.add(Box.createRigidArea(new Dimension(5, bs.gameWindow.WINDOW_H/18)));
        secondBtnPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        bp.add(secondBtnPanel);
        bs.panelRevalRepaint(bp);
    }
    private void chooseRecipient(Equippable equippable, int price){
        List<Character> partyMembers = bs.getPartyMembers();
        JLabel lblEquipWho = new JLabel("Equip " + equippable.getName() + " on who?", SwingConstants.CENTER);
        lblEquipWho.setMaximumSize(new Dimension(250, 30));

        JPanel firstBtnPanel = new JPanel();
        firstBtnPanel.setLayout(new BoxLayout(firstBtnPanel, BoxLayout.LINE_AXIS));
        firstBtnPanel.setMaximumSize(new Dimension(280, 30));

        JPanel secondBtnPanel = new JPanel();
        secondBtnPanel.setLayout(new BoxLayout(secondBtnPanel, BoxLayout.LINE_AXIS));
        secondBtnPanel.setMaximumSize(new Dimension(280, 30));

        for(int i=0; i<partyMembers.size(); i++){
            Character chara = partyMembers.get(i);
            JButton button = new JButton(chara.getName());
            button.setFocusable(false);
            button.setMaximumSize(new Dimension(125, 30));
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(equippable instanceof Weapon) chara.equipWeapon((Weapon) equippable);
                    else chara.equipArmor((Armor) equippable);
                    bs.getParty().spendGold(price);
                    bs.setState(new Shop(bs));
                }
            });
            bs.gameWindow.setBGBlackFGWhite(button);
            if(i < 2) {
                firstBtnPanel.add(button);
                if(i == 0) firstBtnPanel.add(Box.createRigidArea(new Dimension(30, 0)));
            }
            else {
                secondBtnPanel.add(button);
                if(i == 2) secondBtnPanel.add(Box.createRigidArea(new Dimension(30, 0)));
            }
        }
        bs.gameWindow.setBackgroundBlack(new Component[]{lblEquipWho ,firstBtnPanel, secondBtnPanel});
        lblEquipWho.setForeground(Color.WHITE);

        BottomPanel bp = bs.gameWindow.bottomPanel;
        bs.removeAllNotBPSP();
        bp.add(Box.createRigidArea(new Dimension(5, bs.gameWindow.WINDOW_H/36)));
        lblEquipWho.setAlignmentX(Component.CENTER_ALIGNMENT);
        bp.add(lblEquipWho);
        bp.add(Box.createRigidArea(new Dimension(5, bs.gameWindow.WINDOW_H/18)));
        firstBtnPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        bp.add(firstBtnPanel);
        bp.add(Box.createRigidArea(new Dimension(5, bs.gameWindow.WINDOW_H/18)));
        secondBtnPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        bp.add(secondBtnPanel);
        bs.panelRevalRepaint(bp);
    }
    private boolean validateMoney(int price){
        if(bs.getParty().getGold() >= price){
            return true;
        }
        else{
            System.out.println("You can't afford this item");
            return false;
        }
    }
}
