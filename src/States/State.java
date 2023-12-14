package States;

import Characters.Character;
import Characters.CharacterClass;
import Characters.EnemyClass;
import GameSystems.BattleSystem;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
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

     public void displayAllyStats() {

          JPanel statPanel = bs.gameWindow.statPanel;

          for (Characters.Character livingAlly : livingAllies) {
               JPanel container = new JPanel();
               container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));
               container.setPreferredSize(new Dimension(statPanel.getHeight(), 100));

               container.setBorder(new EmptyBorder(10, 10, 10, 10));


               JLabel allyName = new JLabel(livingAlly.getName());
               Font existingFont = allyName.getFont();
               Font newFont = existingFont.deriveFont(15.0f);
               allyName.setFont(newFont);

               String hpText = "H: " + livingAlly.getCurrHealth() + "/" + livingAlly.getMaxHealth();
               JLabel hpLabel = new JLabel(hpText);
               hpLabel.setFont(newFont);

               String manaText = "M: " + livingAlly.getCurrMana();
               JLabel manaLabel = new JLabel(manaText);
               manaLabel.setFont(newFont);

               bs.gameWindow.setBackgroundBlack(new Component[]{container});
               bs.gameWindow.setForegroundWhite(new Component[]{allyName, hpLabel, manaLabel});

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

     public void displayEnemyStats() {
          JPanel statPanel = bs.gameWindow.statPanel;

          for (Characters.Character enemy : randomEnemies) {
               JPanel container = new JPanel();
               container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));
               container.setPreferredSize(new Dimension(statPanel.getHeight(), 100));

               JLabel enemyName = new JLabel(enemy.getName());
               enemyName.setForeground(Color.RED);
               Font existingFont = enemyName.getFont();
               Font newFont = existingFont.deriveFont(15.0f);
               enemyName.setFont(newFont);

               String hpText = "H: " + enemy.getCurrHealth() + "/" + enemy.getMaxHealth();
               JLabel hpLabel = new JLabel(hpText);
               hpLabel.setFont(newFont);

               String manaText = "M: " + enemy.getCurrMana();
               JLabel manaLabel = new JLabel(manaText);
               manaLabel.setFont(newFont);

               bs.gameWindow.setBackgroundBlack(new Component[]{container});
               bs.gameWindow.setForegroundWhite(new Component[]{hpLabel, manaLabel});

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

          displayAllyStats();
          displayEnemyStats();
     }

     public void displayEnemySprites() {
          JPanel display = bs.gameWindow.display;

          for (Characters.Character enemy : randomEnemies) {
               ImageIcon enemySprite = new ImageIcon(enemy.charClass.sprite);
               Image origImg = enemySprite.getImage();
               int NEW_IMG_W = enemySprite.getIconWidth() * 4;
               int NEW_IMG_H = enemySprite.getIconHeight() * 4;
               Image scaledImage = origImg.getScaledInstance(NEW_IMG_W, NEW_IMG_H, Image.SCALE_SMOOTH);
               ImageIcon scaledIcon = new ImageIcon(scaledImage);


               JLabel enemySpriteCont = new JLabel(scaledIcon);
               display.add(enemySpriteCont);
          }

          display.revalidate();
          display.repaint();
     }
}
