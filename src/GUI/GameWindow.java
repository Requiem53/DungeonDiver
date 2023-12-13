package GUI;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    public BottomPanel bottomPanel;
    public Display display;
    public StatPanel statPanel;
    public final int SCREEN_W;
    public final int SCREEN_H;
    public GameWindow(){
        super("Slumm RPG");

        Dimension size
                = Toolkit.getDefaultToolkit().getScreenSize();
        SCREEN_H = (int) size.getHeight();
        SCREEN_W = SCREEN_H;
        System.out.println(SCREEN_W + ", " + SCREEN_H);

        display = new Display();
        JPanel displayBG = new JPanel(null);
        displayBG.setBackground(Color.YELLOW);
        displayBG.add(display);
        bottomPanel = new BottomPanel();

        statPanel = new StatPanel();

        //Self Default
        setSize(SCREEN_W,SCREEN_H);
        setResizable(false);
        setLocationRelativeTo(null);
        setBackground(Color.gray);
        add(displayBG, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
        add(statPanel, BorderLayout.NORTH);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
