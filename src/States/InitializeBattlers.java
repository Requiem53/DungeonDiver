package States;

import GameSystems.BattleSystem;

public class InitializeBattlers extends State{
    //extends State
    //Generates random enemies and descends party member down a level
    public InitializeBattlers(BattleSystem bs) {
        super(bs);
    }

    @Override
    public void Start() {
        initializeAllies();
        initializeEnemies();

        bs.setState(new BattleStart(bs));
    }
}
