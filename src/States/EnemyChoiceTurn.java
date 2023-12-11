package States;

import Attacks.Attack;
import Characters.Character;
import GameSystems.BattleSystem;
import Interfaces.Action;

public class EnemyChoiceTurn extends State{
    public EnemyChoiceTurn(BattleSystem bs) {
        super(bs);
    }

    @Override
    public void Start() {
        Character allyTarget = livingAllies.get(random.nextInt(livingAllies.size()));
        Character currEnemy = getCurrChar();

        //No random yet bruh
        //add timer in Strong attacks so enemies can use it but utilize random
        bs.addAction(new Action(new Attack.NormalAttack(), currEnemy, allyTarget));
        newChoiceTurn();
    }
}
