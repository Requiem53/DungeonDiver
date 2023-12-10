package Spells;

import Characters.Character;
import Interfaces.*;
import Statuses.*;

public abstract class Spell extends Actionable{
    private final int manaCost;
    private final float basePower;
    private final int baseAmount;
    private final Status status;

    public Spell(SpellBuilder builder) {
        this.name = builder.getName();
        this.manaCost = builder.getManaCost();
        this.basePower = builder.getBasePower();
        this.baseAmount = builder.getBaseAmount();
        this.status = builder.getStatus();
    }

    public int getManaCost() {
        return manaCost;
    }

    public float getBasePower() {
        return basePower;
    }

    public int getBaseAmount() {
        return baseAmount;
    }

    public Status getStatus() {
        return status;
    }
}