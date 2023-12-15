package States;

import GameSystems.BattleSystem;

import javax.swing.*;
import java.awt.*;

public class DescendLevel extends State{
    public DescendLevel(BattleSystem bs) {
        super(bs);
    }

    @Override
    public void Start() {
        descendLevel();
        System.out.println("You have descended a level");
        System.out.println(State.dungeonLevel);

        updateScoreAndDungeonLvl();

        if(State.dungeonLevel == 1){
            bs.setState(new InitializeBattlers(bs));
        }else if(State.dungeonLevel == 2){
            bs.setState(new Shop(bs));
        }else if(State.dungeonLevel == 3){
            bs.setState(new InitializeBoss(bs));
        }else if(State.dungeonLevel > 3){
            bs.setState(new Victory(bs));
        }

    }
    private void updateScoreAndDungeonLvl(){
        JPanel topPart = bs.bottomPanel_topPart;
        JPanel scorePanel = bs.scorePanel;
        JPanel dungeonLevelPanel = bs.dungeonLevelPanel;

        scorePanel.removeAll();
        dungeonLevelPanel.removeAll();

        JLabel lblScore = new JLabel("Score: " + bs.user.getScore());
        lblScore.setHorizontalAlignment(SwingConstants.CENTER);
        bs.gameWindow.setBiggerFont(lblScore);
        scorePanel.add(lblScore);

        JLabel lblDungeonLvl = new JLabel("Dungeon Level: " + State.dungeonLevel);
        lblDungeonLvl.setHorizontalAlignment(SwingConstants.RIGHT);
        bs.gameWindow.setBiggerFont(lblDungeonLvl);
        dungeonLevelPanel.add(lblDungeonLvl);

        bs.gameWindow.setBackgroundBlack(new Component[]{lblScore, scorePanel, lblDungeonLvl, dungeonLevelPanel});
        bs.gameWindow.setForegroundWhite(new Component[]{lblScore, lblDungeonLvl});

        topPart.add(scorePanel);
        topPart.add(dungeonLevelPanel);
        bs.removeAllNotBPSP();
        bs.panelRevalRepaint(bs.gameWindow.bottomPanel);
    }
}
