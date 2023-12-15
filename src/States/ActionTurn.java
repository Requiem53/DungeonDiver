package States;

import Characters.Character;
import GUI.BottomPanel;
import GameSystems.BattleSystem;
import Interfaces.Action;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class ActionTurn extends State {
    public ActionTurn(BattleSystem bs) {
        super(bs);
    }

    @Override
    public void Start() {
        Action currentAction = bs.dequeueActionsSorted();

        if(actionTurnOver(currentAction)){
            newTurn();
        }

        if(currentAction == null){
            return;     //unknown yet why this happen
        }

        assert currentAction != null;

        showActionGUI(currentAction.execute());

        Timer mainTimer = new Timer();
        mainTimer.schedule(new TimerTask() {

            @Override
            public void run() {

                removeDeadCharacters(currentAction);
                updateEntitiesStats();
                updateEntitySprites();

                boolean victory = false;
                boolean defeat = false;

                if(State.randomEnemies.isEmpty()){
                    victory = true;
                }

                if(State.livingAllies.isEmpty()){
                    defeat = true;
                }

                if(victory){
                    showVictoryGUI();

                    Timer victoryTimer = new Timer();
                    victoryTimer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            bs.getParty().addGold(1000);
                            bs.user.addScore(100);
                            bs.setState(new DescendLevel(bs));
                        }
                    }, 3000);
                    return;
                }

                if(defeat){
                    showDefeatGUI();

                    Timer defeatTimer = new Timer();
                    defeatTimer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            bs.setState(new Defeat(bs));
                        }
                    }, 3000);
                    return;
                }
                System.out.println("-----------------------------");
                bs.setState(new ActionTurn(bs));
            }
        }, 3000);
    }

    private void removeDeadCharacters(Action currAction){
        if(!currAction.getActor().isAlive()){
            if(currAction.getActor() instanceof Character.Ally){
                currAction.removeFromList(State.livingAllies, currAction.getActor());
            }else{
                currAction.removeFromList(State.randomEnemies, currAction.getActor());
            }
        }
        if(!currAction.getTarget().isAlive()){
            if(currAction.getTarget() instanceof Character.Ally){
                currAction.removeFromList(State.livingAllies, currAction.getTarget());
            }else{
                currAction.removeFromList(State.randomEnemies, currAction.getTarget());
            }
        }
        for(int i = 0; i < State.livingAllies.size(); i++){
            System.out.println(State.livingAllies.get(i) + " " + State.livingAllies.get(i).getCurrHealth() + " / " + State.livingAllies.get(i).getMaxHealth());
//            if(!State.livingAllies.get(i).isAlive())
//                State.livingAllies.remove(i);
        }

        for(int i = 0; i < State.randomEnemies.size(); i++){
            System.out.println(State.randomEnemies.get(i) + " " + State.randomEnemies.get(i).getCurrHealth() + " / " + State.randomEnemies.get(i).getMaxHealth());
//            if(!State.randomEnemies.get(i).isAlive())
//                State.randomEnemies.remove(i);
        }
    }

    private boolean actionTurnOver(Action currentAction){
        return currentAction == null;
    }

    private void newTurn(){
        bs.actionListsReset();
        for(Character character : bs.getPartyMembers()){
            character.decrementStatusDuration();
        }

        bs.clearActions();
        State.queueChoice.clear();

        State.queueChoice.add(null);
        State.queueChoice.addAll(State.livingAllies);
        State.queueChoice.addAll(State.randomEnemies);
        newChoiceTurn();
    }

    private void showActionGUI(String string){
        String[] lines = string.split("\n");

        BottomPanel bp = bs.gameWindow.bottomPanel;
        bs.removeAllNotBPSP();

        for(int i=0; i<lines.length; i++){
            String line = lines[i];
            JLabel lblLine = new JLabel(line, SwingConstants.CENTER);
            lblLine.setMaximumSize(new Dimension(600, 30));
            bs.gameWindow.setBiggerFont(lblLine);
            bs.gameWindow.setBGBlackFGWhite(lblLine);
            if(i == 0) bp.add(Box.createRigidArea(new Dimension(5, bs.gameWindow.WINDOW_H/18)));
            else bp.add(Box.createRigidArea(new Dimension(5, bs.gameWindow.WINDOW_H/36)));
            lblLine.setAlignmentX(Component.CENTER_ALIGNMENT);
            bp.add(lblLine);
        }
        bs.panelRevalRepaint(bp);
    }

    private void showVictoryGUI(){
        JLabel lblVictory = new JLabel("You have won the battle!", SwingConstants.CENTER);
        lblVictory.setMaximumSize(new Dimension(600, 30));
        bs.gameWindow.setBiggerFont(lblVictory);
        bs.gameWindow.setBGBlackFGWhite(lblVictory);

        JLabel lblRewards = new JLabel("You received 1000 gold and 100 score points from the skirmish!", SwingConstants.CENTER);
        lblRewards.setMaximumSize(new Dimension(800, 30));
        bs.gameWindow.setBiggerFont(lblRewards);
        bs.gameWindow.setBGBlackFGWhite(lblRewards);

        BottomPanel bp = bs.gameWindow.bottomPanel;
        bs.removeAllNotBPSP();
        bp.add(Box.createRigidArea(new Dimension(5, bs.gameWindow.WINDOW_H/18)));
        lblVictory.setAlignmentX(Component.CENTER_ALIGNMENT);
        bp.add(lblVictory);
        bp.add(Box.createRigidArea(new Dimension(5, bs.gameWindow.WINDOW_H/18)));
        lblRewards.setAlignmentX(Component.CENTER_ALIGNMENT);
        bp.add(lblRewards);
        bs.panelRevalRepaint(bp);
    }

    private void showDefeatGUI(){
        JLabel lblVictory = new JLabel("You have lost the battle!", SwingConstants.CENTER);
        lblVictory.setMaximumSize(new Dimension(600, 30));
        bs.gameWindow.setBiggerFont(lblVictory);
        bs.gameWindow.setBGBlackFGWhite(lblVictory);

        BottomPanel bp = bs.gameWindow.bottomPanel;
        bs.removeAllNotBPSP();
        bp.add(Box.createRigidArea(new Dimension(5, bs.gameWindow.WINDOW_H/18)));
        lblVictory.setAlignmentX(Component.CENTER_ALIGNMENT);
        bp.add(lblVictory);
        bs.panelRevalRepaint(bp);
    }
}