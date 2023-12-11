package States;

import GameSystems.BattleSystem;

public class Shop extends State{

    public Shop(BattleSystem bs) {
        super(bs);
    }

    @Override
    public void Start() {
        System.out.println("This the shop yeah");
        //Add small shop that sells weapons and armor
        //Add option to learn new spells, attacks
        //Add sell items
        //Add revive allies option
        bs.setState(new DescendLevel(bs));
    }
}
