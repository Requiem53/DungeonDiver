package States;

import Characters.Character;
import GameSystems.BattleSystem;

public class ChoiceTurn extends State {
    boolean sameTurn;
    public ChoiceTurn(BattleSystem bs) {
        super(bs);
        sameTurn = false;
    }
    public ChoiceTurn(BattleSystem bs, boolean sameTurn){
        super(bs);
        this.sameTurn = sameTurn;
    }

    @Override
    public void Start() {
        if(!sameTurn){
            bs.incrementTurn();
            State.queueChoice.remove();

            if (allCharactersHaveChosenActions()) {
                bs.sortActions();
                bs.setState(new ActionTurn(bs));
            }
        }

        if(State.queueChoice.peek() instanceof Character.Ally){
            bs.setState(new PlayerChoiceTurn(bs));
        }
        else {
            bs.setState(new EnemyChoiceTurn(bs));
        }
    }

    private boolean allCharactersHaveChosenActions(){
        return State.queueChoice.isEmpty();
    }
}
