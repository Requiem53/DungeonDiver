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
        Character allyTarget = State.livingAllies.get(random.nextInt(State.livingAllies.size()));
        Character currEnemy = State.queueChoice.peek();

        Actionable enemyAction;

        int randomIndex = random.nextInt(2);

        switch (randomIndex){
            case 0:
                assert currEnemy != null;
                randomIndex = random.nextInt(currEnemy.getAttacks().size());
                enemyAction = currEnemy.getAttacks().get(randomIndex);
                break;
            case 1:
                assert currEnemy != null;
                if(currEnemy.getSpells().isEmpty()) {
                    enemyAction = currEnemy.getAttacks().get(0); //if no spell
                    break;
                }

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
