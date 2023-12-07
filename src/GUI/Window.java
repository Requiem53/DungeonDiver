package GUI;

import javax.swing.*;
import java.awt.*;
import GameSystems.*;

public class Window extends JFrame {
    BattleSystem bs;
    Window(BattleSystem bs){
        super("Slumm RPG");
        this.bs = bs;
        JPanel display = new JPanel();
        display.setBackground(Color.BLACK);
        display.setPreferredSize(new Dimension(100, 100));

        JPanel bottomPanel = new JPanel(null);
        bottomPanel.setPreferredSize(new Dimension(600, 160));
        bottomPanel.setBackground(Color.WHITE);


        ActionPanel actionPanel = new ActionPanel(bs, 575, 150);
        bottomPanel.add(actionPanel);

        //Self Default
        setSize(600,600);
        setResizable(false);
        setBackground(Color.gray);
        add(display, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
