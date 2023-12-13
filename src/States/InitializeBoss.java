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

        bs.clearActions();
        State.queueChoice.clear();

        State.queueChoice.add(null);
        State.queueChoice.addAll(State.livingAllies);
        State.queueChoice.addAll(State.randomEnemies);

        bs.setState(new BattleStart(bs));
    }
}
