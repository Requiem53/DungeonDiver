package States;

import GameSystems.BattleSystem;

public class Victory extends State {
    public Victory(BattleSystem bs) {
        super(bs);
    }
    @Override
    public void Start(){
        System.out.println("You win boy");
    }
}
