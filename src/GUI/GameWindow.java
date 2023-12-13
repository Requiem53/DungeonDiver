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

        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        SCREEN_H = (int) size.getHeight();
        SCREEN_W = SCREEN_H;

        display = new Display();
        JPanel displayBG = new JPanel(new BorderLayout());
        displayBG.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        displayBG.setBackground(Color.WHITE);
        displayBG.add(display, BorderLayout.CENTER);

        bottomPanel = new BottomPanel(SCREEN_W, SCREEN_H);

        statPanel = new StatPanel(SCREEN_W, SCREEN_H);

        //Self Default
        setSize(SCREEN_W,SCREEN_H);
        setResizable(false);
        setLocationRelativeTo(null);
        setBackground(Color.gray);
        add(statPanel, BorderLayout.NORTH);
        add(displayBG, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
