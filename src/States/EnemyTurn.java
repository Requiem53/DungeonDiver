package States;

import Attacks.AttackBuilder;
import Attacks.NormalAttack;
import Characters.Character;
import GameSystems.BattleSystem;
import GameSystems.State;
import Interfaces.Action;

public class EnemyTurn extends State {
    public EnemyTurn(BattleSystem bs) {
        super(bs);
    }

    @Override
    public void Start() {
        Character allyTarget = allies.get(random.nextInt(allies.size()));
        Character currEnemy = getCurrChar();

        bs.addAction(new Action(new NormalAttack(new AttackBuilder()), currEnemy, allyTarget));
        newChoiceTurn();
    }
}
