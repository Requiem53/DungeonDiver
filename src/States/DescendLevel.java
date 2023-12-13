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

        if(getDungeonLevel() == 1){
            bs.setState(new InitializeBattlers(bs));
        }else if(getDungeonLevel()  == 2){
            bs.setState(new Shop(bs));
        }else if(getDungeonLevel()  == 3){
            bs.setState(new InitializeBoss(bs));
        }

    }
}
