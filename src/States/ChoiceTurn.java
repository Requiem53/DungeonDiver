package States;

import Characters.Character;
import GameSystems.BattleSystem;

public class ChoiceTurn extends State {
    public ChoiceTurn(BattleSystem bs) {
        super(bs);
    }

    @Override
    public void Start() {
        bs.incrementTurn();
        queueChoice.remove();

        if(allCharactersHaveChosenActions()){
            bs.sortActions();
            bs.setState(new ActionTurn(bs));
        }

        if(queueChoice.peek() instanceof Character.Ally){
            bs.setState(new PlayerChoiceTurn(bs));
        }
        else {
            bs.setState(new EnemyChoiceTurn(bs));
        }
    }

    private boolean allCharactersHaveChosenActions(){
        return queueChoice.isEmpty();
    }
}
