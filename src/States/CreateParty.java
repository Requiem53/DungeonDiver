package States;

import GameSystems.BattleSystem;

public class CreateParty extends State{

    public CreateParty(BattleSystem bs) {
        super(bs);
    }

    @Override
    public void Start() {

        bs.setState(new InitializeBattlers(bs));
    }
}
