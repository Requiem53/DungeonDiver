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
        setBackground(Color.WHITE);

        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        WINDOW_H = (int) (size.getHeight() - (size.getHeight()*0.05));
        WINDOW_W = WINDOW_H;

        display = new Display();
//        JPanel displayBG = new JPanel(new BorderLayout());
//        displayBG.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
//        displayBG.setBackground(Color.WHITE);
//        displayBG.add(display, BorderLayout.CENTER);

        bottomPanel = new BottomPanel(WINDOW_W, WINDOW_H);
        JPanel bottomPanelBG = new JPanel(new BorderLayout());
        bottomPanelBG.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        bottomPanelBG.setBackground(Color.GRAY);
        bottomPanelBG.add(bottomPanel, BorderLayout.CENTER);
        bottomPanelBG.setPreferredSize(new Dimension(WINDOW_W, WINDOW_H / 3));

        statPanel = new StatPanel(WINDOW_W, WINDOW_H);
        JPanel statPanellBG = new JPanel(new BorderLayout());
        statPanellBG.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        statPanellBG.setBackground(Color.GRAY);
        statPanellBG.add(statPanel, BorderLayout.CENTER);
        statPanellBG.setPreferredSize(new Dimension(WINDOW_W, WINDOW_H / 6));

        //Self Default
        setSize(WINDOW_W,WINDOW_H);
        setResizable(false);
        setLocationRelativeTo(null);
        setBackground(Color.gray);
        add(statPanellBG, BorderLayout.NORTH);
        add(display, BorderLayout.CENTER);
        add(bottomPanelBG, BorderLayout.SOUTH);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
