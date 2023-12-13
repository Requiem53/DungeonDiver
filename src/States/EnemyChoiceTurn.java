package States;

import Attacks.Attack;
import Characters.Character;
import GameSystems.BattleSystem;
import Interfaces.Action;
import Interfaces.Actionable;

public class EnemyChoiceTurn extends State{
    public EnemyChoiceTurn(BattleSystem bs) {
        super(bs);
    }

    @Override
    public void Start() {
        Character allyTarget = livingAllies.get(random.nextInt(livingAllies.size()));
        Character currEnemy = getCurrChar();

        Actionable enemyAction;

        int randomIndex = random.nextInt(2);

        switch (randomIndex){
            case 0:
                randomIndex = random.nextInt(currEnemy.getAttacks().size());
                enemyAction = currEnemy.getAttacks().get(randomIndex);
                break;
            case 1:
                randomIndex = random.nextInt(currEnemy.getSpells().size());
                enemyAction = currEnemy.getSpells().get(randomIndex);
                break;
            default:
                enemyAction = currEnemy.getAttacks().get(0);
        }

        bs.addAction(new Action(enemyAction, currEnemy, allyTarget));
        newChoiceTurn();
    }
}
