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
        System.out.println(currentAction.execute());

        removeDeadCharacters(currentAction);

        boolean victory = false;
        boolean defeat = false;

        if(State.randomEnemies.isEmpty()){
            victory = true;
        }

        if(State.livingAllies.isEmpty()){
            defeat = true;
        }

        if(victory){
            System.out.println("You have won the battle!");
            System.out.println("You received 1000 gold from the skirmish!");
            bs.getParty().addGold(1000);
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
}