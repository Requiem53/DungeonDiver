package States;

import GameSystems.BattleSystem;

public class InitializeBoss extends State{

    public InitializeBoss(BattleSystem bs) {
        super(bs);
    }

    @Override
    public void Start() {
        initializeAllies();
        initializeBoss();

        queueChoice.add(null);
        queueChoice.addAll(livingAllies);
        queueChoice.addAll(randomEnemies);

        bs.setState(new BattleStart(bs));
    }
}
