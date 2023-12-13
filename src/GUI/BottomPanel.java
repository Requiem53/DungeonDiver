package GUI;

import javax.swing.*;
import java.awt.*;

public class BottomPanel extends JPanel {
    public BottomPanel(int SCREEN_W, int SCREEN_H) {
        super(null);
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(SCREEN_W, SCREEN_H / 4));
    }
}
