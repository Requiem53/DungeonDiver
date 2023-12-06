package Actions;

import Characters.Character;

public class CastSpellAction implements I_Action{

    Character target;
    Character caster;

    public CastSpellAction(Character target, Character caster) {
        this.target = target;
        this.caster = caster;
    }

    @Override
    public void execute() {

    }
}
