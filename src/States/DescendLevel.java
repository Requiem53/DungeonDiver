package States;

import GameSystems.BattleSystem;

public class DescendLevel extends State{
    public DescendLevel(BattleSystem bs) {
        super(bs);
    }

    @Override
    public void Start() {
        dungeonLevel++;
        System.out.println("You have descended a level");

        if(dungeonLevel <= 2){
            bs.setState(new InitializeBattlers(bs));
        }

    }
}
