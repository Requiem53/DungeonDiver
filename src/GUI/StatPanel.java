package GUI;

import javax.swing.*;
import java.awt.*;

public class StatPanel extends JPanel {
    public StatPanel(int SCREEN_W, int SCREEN_H) {
        super(null);
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(SCREEN_W, SCREEN_H / 4));

    }
}
