package GUI;

import javax.swing.*;
import java.awt.*;

public class BottomPanel extends JPanel {
    public BottomPanel(int WINDOW_W, int WINDOW_H) {
        super();
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setBackground(Color.BLACK);
//        setPreferredSize(new Dimension(WINDOW_W, WINDOW_H / 3));
    }
}
