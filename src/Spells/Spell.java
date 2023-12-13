package Spells;

import Interfaces.*;

public abstract class Spell extends Actionable{
    private final int manaCost;
    public Spell(SpellBuilder builder) {
        this.name = builder.getName();
        this.manaCost = builder.getManaCost();
    }

    public int getManaCost() {
        return manaCost;
    }

    @Override
    public String toString() {
        return name + "[MC: " + manaCost + "]";
    }
}