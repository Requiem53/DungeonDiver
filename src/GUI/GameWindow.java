package GUI;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    public BottomPanel bottomPanel;
    public Display display;
    public StatPanel statPanel;
    public final int WINDOW_W;
    public final int WINDOW_H;
    public GameWindow(){
        super("Slumm RPG");

        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        WINDOW_H = (int) size.getHeight();
        WINDOW_W = WINDOW_H;

        display = new Display();
        JPanel displayBG = new JPanel(new BorderLayout());
        displayBG.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        displayBG.setBackground(Color.WHITE);
        displayBG.add(display, BorderLayout.CENTER);

        bottomPanel = new BottomPanel(WINDOW_W, WINDOW_H);

        statPanel = new StatPanel(WINDOW_W, WINDOW_H);

        //Self Default
        setSize(WINDOW_W,WINDOW_H);
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
