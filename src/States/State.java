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
     protected void sameChoiceTurn(){
          bs.setState(new ChoiceTurn(bs, true));
     }


     public void initializeAllies(){
          State.livingAllies = bs.getLivingAllies();
     }
     public void initializeEnemies(){
          //temporary
          //Add random enemy generator soon depending on dungeon level
          State.randomEnemies.add(new Character.Enemy("Rude Den", new EnemyClass.Goblin()));
          State.randomEnemies.add(new Character.Enemy("Bear nose", new EnemyClass.EvilMage()));
     }
     public void initializeBoss(){
          State.randomEnemies.add(new Character.Enemy("Yuujin of Sico", new EnemyClass.FinalBoss()));
          displayEnemyStats();
          displayEnemySprites();
     }

     protected Character getCurrChar(){
          return bs.getCurrChar();
     }

     public void displayAllyStats() {
          JPanel statPanel = bs.gameWindow.statPanel;

//          HP
//          Mana
//          POW
//          MP
//          SPD
          for (Characters.Character livingAlly : State.livingAllies) {
               JPanel container = new JPanel();
               container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));

               // name
               JLabel allyName = new JLabel(livingAlly.getName());
               allyName.setForeground(new Color(64, 193, 64)); // RGB values for light green

               // hp
               String hpText = "HP: " + livingAlly.getCurrHealth() + "/" + livingAlly.getMaxHealth();
               JLabel hpLabel = new JLabel(hpText);


               // mana
               String manaText = "M: " + livingAlly.getCurrMana();
               JLabel manaLabel = new JLabel(manaText);

               // power
               String powerText = "POW: " + livingAlly.getPower();
               JLabel powerLabel = new JLabel(powerText);

               // magic power
               String mpText = "MP: " + livingAlly.getMagicPower();
               JLabel mpLabel = new JLabel(mpText);

               // speed
               String speedText = "SPD: " + livingAlly.getSpeed();
               JLabel speedLabel = new JLabel(speedText);


               bs.gameWindow.setBackgroundBlack(new Component[]{container});
               bs.gameWindow.setForegroundWhite(new Component[]{hpLabel, manaLabel, powerLabel, mpLabel, speedLabel});

               container.add(Box.createVerticalGlue());
               container.add(allyName);
               container.add(hpLabel);
               container.add(manaLabel);
               container.add(powerLabel);
               container.add(mpLabel);
               container.add(speedLabel);
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

          for (Characters.Character enemy : State.randomEnemies) {
               JPanel container = new JPanel();
               container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));

               // name
               JLabel enemyName = new JLabel(enemy.getName());
               enemyName.setForeground(Color.RED);

               // hp
               String hpText = "HP: " + enemy.getCurrHealth() + "/" + enemy.getMaxHealth();
               JLabel hpLabel = new JLabel(hpText);

               // mana
               String manaText = "M: " + enemy.getCurrMana();
               JLabel manaLabel = new JLabel(manaText);

               // power
               String powerText = "POW: " + enemy.getPower();
               JLabel powerLabel = new JLabel(powerText);

               // magic power
               String mpText = "MP: " + enemy.getMagicPower();
               JLabel mpLabel = new JLabel(mpText);

               // speed
               String speedText = "SPD: " + enemy.getSpeed();
               JLabel speedLabel = new JLabel(speedText);

               bs.gameWindow.setBackgroundBlack(new Component[]{container});
               bs.gameWindow.setForegroundWhite(new Component[]{hpLabel, manaLabel, powerLabel, mpLabel, speedLabel});

               container.add(Box.createVerticalGlue());
               container.add(enemyName);
               container.add(hpLabel);
               container.add(manaLabel);
               container.add(powerLabel);
               container.add(mpLabel);
               container.add(speedLabel);
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
     public void updateEntitySprites() {
          JPanel display = bs.gameWindow.display;

          display.removeAll();

          displayEnemySprites();
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
