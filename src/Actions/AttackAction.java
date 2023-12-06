package Actions;

import Characters.Character;

public class AttackAction implements I_Action{

    private final Character target;
    private final Character attacker;

    public AttackAction(Character target, Character attacker) {
        this.target = target;
        this.attacker = attacker;
    }

    @Override
    public void execute() {
        target.takeDamage(attacker.getPower());
    }
}
