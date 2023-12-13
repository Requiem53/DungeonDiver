package States;

import Characters.Character;
import GameSystems.BattleSystem;
import Interfaces.Action;

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

        assert currentAction != null;
        currentAction.execute();

        removeDeadCharacters();

        boolean victory = false;
        boolean defeat = false;

        if(randomEnemies.isEmpty()){
            victory = true;
        }

        if(livingAllies.isEmpty()){
            defeat = true;
        }

        if(victory){
            System.out.println("You have won the battle!");
            System.out.println("You received 100 gold from the skirmish!");
            bs.getParty().addGold(100);
            bs.setState(new DescendLevel(bs));
            return;
        }

        if(defeat){
            System.out.println("You have lost the battle!");
            bs.setState(new Defeat(bs));
            return;
        }
        System.out.println("-----------------------------");
        bs.setState(new ActionTurn(bs));
    }

    private void removeDeadCharacters(){
        for(int i = 0; i < State.livingAllies.size(); i++){
            System.out.println(State.livingAllies.get(i).getCurrHealth() + " / " + State.livingAllies.get(i).getMaxHealth());
            if(!State.livingAllies.get(i).isAlive())
                State.livingAllies.remove(i);
        }

        for(int i = 0; i < State.randomEnemies.size(); i++){
            System.out.println(State.randomEnemies.get(i).getCurrHealth() + " / " + State.randomEnemies.get(i).getMaxHealth());
            if(!State.randomEnemies.get(i).isAlive())
                State.randomEnemies.remove(i);
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
        queueChoice.add(null);
        queueChoice.addAll(State.livingAllies);
        queueChoice.addAll(State.randomEnemies);
        newChoiceTurn();
    }
}