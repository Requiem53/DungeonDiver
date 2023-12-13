package States;

import GameSystems.BattleSystem;

import javax.swing.*;
import java.awt.*;

public class InitializeBattlers extends State{
    //extends State
    //Generates random enemies and descends party member down a level
    public InitializeBattlers(BattleSystem bs) {
        super(bs);
    }

    @Override
    public void Start() {
        initializeAllies();
        initializeEnemies();

        queueChoice.add(null);
        queueChoice.addAll(livingAllies);
        queueChoice.addAll(randomEnemies);

        showAlliesStats();
        showEnemiesStats();

        bs.setState(new BattleStart(bs));
    }

    private void showAlliesStats() {
        
        JPanel statPanel = bs.gameWindow.statPanel;

        for (Characters.Character livingAlly : livingAllies) {
            JPanel container = new JPanel();
            container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
            container.setBackground(Color.BLACK);
            container.setPreferredSize(new Dimension(statPanel.getHeight(), 100));

            JLabel allyName = new JLabel(livingAlly.getName());
            allyName.setForeground(Color.WHITE);
            Font existingFont = allyName.getFont();
            Font newFont = existingFont.deriveFont(18.0f);
            allyName.setFont(newFont);

            String hpText = "H: " + livingAlly.getCurrHealth() + "/" + livingAlly.getMaxHealth();
            JLabel hpLabel = new JLabel(hpText);
            hpLabel.setForeground(Color.WHITE);
            hpLabel.setFont(newFont);

            String manaText = "M: " + livingAlly.getCurrMana();
            JLabel manaLabel = new JLabel(manaText);
            manaLabel.setForeground(Color.WHITE);
            manaLabel.setFont(newFont);

            container.add(Box.createVerticalGlue());
            container.add(allyName);
            container.add(hpLabel);
            container.add(manaLabel);
            container.add(Box.createVerticalGlue());

            statPanel.add(container);
        }

        statPanel.revalidate();
        statPanel.repaint();
    }

    private void showEnemiesStats() {
        JPanel statPanel = bs.gameWindow.statPanel;

        for (Characters.Character enemy : randomEnemies) {
            JPanel container = new JPanel();
            container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
            container.setBackground(Color.BLACK);
            container.setPreferredSize(new Dimension(statPanel.getHeight(), 100));

            JLabel enemyName = new JLabel(enemy.getName());
            enemyName.setForeground(Color.RED);
            Font existingFont = enemyName.getFont();
            Font newFont = existingFont.deriveFont(18.0f);
            enemyName.setFont(newFont);

            String hpText = "H: " + enemy.getCurrHealth() + "/" + enemy.getMaxHealth();
            JLabel hpLabel = new JLabel(hpText);
            hpLabel.setForeground(Color.WHITE);
            hpLabel.setFont(newFont);

            String manaText = "M: " + enemy.getCurrMana();
            JLabel manaLabel = new JLabel(manaText);
            manaLabel.setForeground(Color.WHITE);
            manaLabel.setFont(newFont);

            container.add(Box.createVerticalGlue());
            container.add(enemyName);
            container.add(hpLabel);
            container.add(manaLabel);
            container.add(Box.createVerticalGlue());

            statPanel.add(container);
        }

        statPanel.revalidate();
        statPanel.repaint();
    }
}
