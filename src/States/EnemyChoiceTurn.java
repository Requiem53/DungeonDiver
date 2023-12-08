package States;

import Attacks.NormalAttack;
import Characters.Character;
import GameSystems.BattleSystem;
import GameSystems.State;
import Interfaces.Action;

public class EnemyChoiceTurn extends State{
    public EnemyChoiceTurn(BattleSystem bs) {
        super(bs);
    }

    @Override
    public void Start() {
        Character allyTarget = allies.get(random.nextInt(allies.size()));
        Character currEnemy = getCurrChar();

        //add timer in Strong attacks so enemies can use it but utilize random
        bs.addAction(new Action(new NormalAttack(), currEnemy, allyTarget));
        newChoiceTurn();
    }
}
