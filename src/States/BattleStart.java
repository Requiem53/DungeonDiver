package States;

import Characters.Character;
import GameSystems.BattleSystem;

public class BattleStart extends State {
    public BattleStart(BattleSystem bs) {
        super(bs);
    }

    @Override
    public void Start() {
        System.out.println("The battle is starting....");
        for(Character chara : bs.getCharacters()){
            if(chara instanceof Character.Enemy){
                enemies.add(chara);
            }else{
                allies.add(chara);
            }
        }
        newChoiceTurn();
    }
}