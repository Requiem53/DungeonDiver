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

        queueChoice.add(null);
        queueChoice.addAll(livingAllies);
        queueChoice.addAll(randomEnemies);

        bs.setState(new BattleStart(bs));
    }
}
