package Actions;

import Characters.Character;
import Spells.*;
import Interfaces.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CastSpellAction implements I_Action{
    Spell spell;
    Character target;

    public CastSpellAction(Spell spell, Character target) {
        this.spell = spell;
        this.target = target;
    }

    @Override
    public void execute() {
//        ((Actionable)spell.doMove(target);
    }
}