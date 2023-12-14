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

        JPanel topPart = bs.bottomPanel_topPart;
        JPanel dungeonLevelPanel = bs.dungeonLevelPanel;

        try{
            dungeonLevelPanel.removeAll();
        }catch (IndexOutOfBoundsException e){
            //nothing
        }

        JLabel lblDungeonLvl = new JLabel("Dungeon Level: " + State.dungeonLevel);
        lblDungeonLvl.setHorizontalAlignment(SwingConstants.RIGHT);
        bs.gameWindow.setBiggerFont(lblDungeonLvl);
        dungeonLevelPanel.add(lblDungeonLvl);

        bs.gameWindow.setBackgroundBlack(new Component[]{lblDungeonLvl, dungeonLevelPanel});
        lblDungeonLvl.setForeground(Color.WHITE);
        topPart.add(dungeonLevelPanel);
        bs.removeAllNotBPSP();
        bs.panelRevalRepaint(bs.gameWindow.bottomPanel);

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
}
