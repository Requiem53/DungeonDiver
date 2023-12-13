package States;

import GameSystems.BattleSystem;

public class DescendLevel extends State{
    public DescendLevel(BattleSystem bs) {
        super(bs);
    }

    @Override
    public void Start() {
        descendLevel();
        System.out.println("You have descended a level");
        System.out.println(State.dungeonLevel);

        if(State.dungeonLevel == 1){
            bs.setState(new InitializeBattlers(bs));
        }else if(State.dungeonLevel == 2){
            bs.setState(new Shop(bs));
        }else if(State.dungeonLevel == 3){
            bs.setState(new InitializeBoss(bs));
        }else if(State.dungeonLevel > 3){
            bs.setState(new Victory(bs));
        }

    }
}
