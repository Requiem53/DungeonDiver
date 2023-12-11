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
        if(currentAction == null){
            bs.actionListsReset();
            for(Character character : bs.getPartyMembers()){
                character.decrementStatusDuration();
            }
            newChoiceTurn();
        }

        assert currentAction != null;
        currentAction.execute();
        boolean victory = false;
        boolean defeat = false;

        for(Character enemy : randomEnemies){
            if(enemy.isAlive()){
                victory = false;
                break;
            }
            victory = true;
        }

        for(Character ally : allies){
            if(ally.isAlive()){
                defeat = false;
                break;
            }
            defeat = true;
        }

        if(victory){
            System.out.println("You have won the battle!");
            //Add new battle diri ug file handling para record sa number of battles won niya sa
            //characters gigamit
            bs.setState(new DescendLevel(bs));
            return;
        }

        if(defeat){
            System.out.println("You have lost the battle!");
            //Add new battle diri ug file handling para record sa number of battles won niya sa
            //characters gigamit
            return;
        }
        System.out.println("-----------------------------");
        bs.setState(new ActionTurn(bs));
    }
}