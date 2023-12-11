package States;

import GameSystems.BattleSystem;

public class Defeat extends State{

    public Defeat(BattleSystem bs) {
        super(bs);
    }

    @Override
    public void Start() {
        System.out.println("You lost");
    }
}
