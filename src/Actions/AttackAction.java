package Actions;

import Characters.Character;

public class AttackAction implements I_Action{

    private final Character target;

    // TEST VARIABLES
    // to add parameter sa character nga ni use sa attack (?)
    private final int dmg = 5;

    public AttackAction(Character target) {
        this.target = target;
    }

    @Override
    public void execute() {
        target.takeDamage(dmg);
    }
}
