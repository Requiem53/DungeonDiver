package Spells;

import Characters.Character;
import Interfaces.StatusInflicting;
import Statuses.Status;

public abstract class StatusSpell extends Spell implements StatusInflicting {

    Status status;
    public StatusSpell(SpellBuilder builder) {
        super(builder.getName(), builder.getManaCost());
        this.status = builder.getStatus();
    }

    @Override
    public void inflictStatus(Character actor, Character target) {
        //Implement after Statuses and CharacterClass
    }

}
