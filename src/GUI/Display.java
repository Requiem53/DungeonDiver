package GUI;

import javax.swing.*;
import java.awt.*;

public class Display extends JPanel {
    public Display() {
        super(new FlowLayout(FlowLayout.CENTER, 50, 50));
        setBackground(Color.BLACK);

        setPreferredSize(new Dimension(100, 100));
    }
}
