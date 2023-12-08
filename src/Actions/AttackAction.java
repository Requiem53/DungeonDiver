package Actions;

import Characters.Character;

public class AttackAction implements I_Action{
    private final Character actor;
    private final Character target;

    public AttackAction(Character actor, Character target) {
        this.actor = actor;
        this.target = target;
    }

    @Override
    public void execute() {
        target.takeDamage(actor.getPower());
    }
}
