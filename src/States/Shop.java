package States;

import GameSystems.BattleSystem;

public class Shop extends State{

    public Shop(BattleSystem bs) {
        super(bs);
    }

    @Override
    public void Start() {
        System.out.println("This the shop yeah");
        bs.setState(new DescendLevel(bs));
    }
}
