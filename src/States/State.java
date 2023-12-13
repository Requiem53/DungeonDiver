package States;

import Characters.Character;
import Characters.EnemyClass;
import GameSystems.BattleSystem;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public abstract class State {
     public static int dungeonLevel = 0;

     protected BattleSystem bs;
     protected Scanner sc;
     protected Random random;

     public static List<Character> livingAllies = new ArrayList<>();
     public static List<Character> randomEnemies = new ArrayList<>();

     public static Queue<Character> queueChoice = new LinkedList<>();
     public State(BattleSystem bs){
          this.bs = bs;

          sc = new Scanner(System.in);
          random = new Random();

          System.out.println();
     }

     public abstract void Start();

     protected void descendLevel(){
          State.dungeonLevel++;
     }

     protected void newChoiceTurn(){
          bs.setState(new ChoiceTurn(bs));
     }


     public void initializeAllies(){
          State.livingAllies = bs.getLivingAllies();
     }
     public void initializeEnemies(){
          //temporary
          //Add random enemy generator soon depending on dungeon level
          State.randomEnemies.add(new Character.Enemy("Roden", new EnemyClass.Goblin()));
          State.randomEnemies.add(new Character.Enemy("Bernus", new EnemyClass.EvilMage()));
     }
     public void initializeBoss(){
          State.randomEnemies.add(new Character.Enemy("Yuujin of Sico", new EnemyClass.FinalBoss()));
     }

     protected Character getCurrChar(){
          return bs.getCurrChar();
     }

     public void showAlliesStats() {

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

               container.revalidate();
               container.repaint();

               statPanel.add(container);
          }

          statPanel.revalidate();
          statPanel.repaint();
     }

     public void showEnemiesStats() {
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

               container.revalidate();
               container.repaint();

               statPanel.add(container);
          }

          statPanel.revalidate();
          statPanel.repaint();
     }

     public void updateEntitiesStats() {
          JPanel statPanel = bs.gameWindow.statPanel;

          statPanel.removeAll();

          showAlliesStats();
          showEnemiesStats();
     }
}
