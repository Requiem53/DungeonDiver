package Actions;

import Characters.Character;
import Spells.*;
import Interfaces.*;

public class CastSpellAction implements I_Action{
    Spell spell;
    Character target;

    public CastSpellAction(Spell spell, Character target) {
        this.spell = spell;
        this.target = target;
    }

    @Override
    public void execute() {
        ((Move)spell).doMove(target);
    }
}