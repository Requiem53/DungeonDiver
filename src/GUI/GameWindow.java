package GUI;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    public BottomPanel bottomPanel;
    public Display display;
    public StatPanel statPanel;
    public GameWindow(){
        super("Slumm RPG");

        display = new Display();
        JPanel displayBG = new JPanel(null);
        displayBG.setBackground(Color.YELLOW);
        displayBG.add(display);


        bottomPanel = new BottomPanel();

        statPanel = new StatPanel();

        //Self Default
        setSize(1920,1080);
        setResizable(false);
        setBackground(Color.gray);
        add(displayBG, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
        add(statPanel, BorderLayout.NORTH);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
