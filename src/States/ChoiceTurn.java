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
        if(bs.getCurrentTurn() >= bs.getCharacters().size()){
            bs.sortActions();
            bs.setState(new ActionTurn(bs));
        }
        if(!(bs.getCurrChar() instanceof Character.Enemy)){
            bs.setState(new PlayerChoiceTurn(bs));
        } else {
            bs.setState(new EnemyChoiceTurn(bs));
        }

    }
}
