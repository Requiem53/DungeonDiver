package States;

import GUI.BottomPanel;
import GameSystems.BattleSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnterName extends State {
    public EnterName(BattleSystem bs) {
        super(bs);
    }

    @Override
    public void Start() {
        int width = bs.gameWindow.WINDOW_W;
        int height = bs.gameWindow.WINDOW_H/3;
        JLabel lblName = new JLabel("Enter your name:");
        lblName.setSize(100, 30);
        JTextField tfName = new JTextField();
        tfName.setMaximumSize(new Dimension(400, 30));
        tfName.setHorizontalAlignment(JTextField.CENTER);
        JButton btnName = new JButton("Enter");
        btnName.setSize(100, 30);
        btnName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bs.getUser().setName(tfName.getText());
                JPanel topPart = new JPanel(new GridLayout(1, 3));
                topPart.setMaximumSize(new Dimension(width, 30));

                JPanel userPanel = new JPanel();

                JLabel lblUser = new JLabel("Logged in as: " + bs.getUser().getName());
                lblUser.setHorizontalAlignment(SwingConstants.LEFT);

                userPanel.add(lblUser);

                topPart.add(userPanel);

                bs.gameWindow.setBackgroundBlack(new Component[]{topPart, userPanel, lblUser});
                lblUser.setForeground(Color.WHITE);
                bs.gameWindow.setBiggerFont(lblUser);

                bs.bottomPanel_topPart = topPart;
                bs.gameWindow.bottomPanel.add(topPart);
                bs.removeAllNotBPSP();
                bs.setState(new CreateParty(bs));
            }
        });
        bs.gameWindow.setBackgroundBlack(new Component[]{lblName, tfName, btnName});
        bs.gameWindow.setForegroundWhite(new Component[]{lblName, tfName, btnName});
        bs.gameWindow.setBiggerFonts(new Component[]{lblName, tfName, btnName});

        BottomPanel bp = bs.gameWindow.bottomPanel;
        bp.add(Box.createRigidArea(new Dimension(0, height/6)));
        lblName.setAlignmentX(Component.CENTER_ALIGNMENT);
        bp.add(lblName);
        bp.add(Box.createRigidArea(new Dimension(0, height/6)));
        tfName.setAlignmentX(Component.CENTER_ALIGNMENT);
        bp.add(tfName);
        bp.add(Box.createRigidArea(new Dimension(0, height/6)));
        btnName.setAlignmentX(Component.CENTER_ALIGNMENT);
        bp.add(btnName);
        bs.panelRevalRepaint(bp);
    }

}