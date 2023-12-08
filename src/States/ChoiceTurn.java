package States;

import Characters.Character;
import GameSystems.BattleSystem;
import GameSystems.State;

public class ChoiceTurn extends State {
    public ChoiceTurn(BattleSystem bs) {
        super(bs);
    }

    @Override
    public void Start() {
        bs.incrementTurn();
        if(bs.getCurrentTurn() >= bs.getCharacters().size()){  //currentTurn becomes currentChoiceTurn
            bs.resetTurn();                                   //just didn't change the names
            bs.sortActions();
            bs.setState(new ActionTurn(bs));
        }

        if(!(getCurrChar() instanceof Character.Enemy)){
            bs.setState(new PlayerChoiceTurn(bs));
        } else {
            bs.setState(new EnemyTurn(bs));
        }

    }
}
