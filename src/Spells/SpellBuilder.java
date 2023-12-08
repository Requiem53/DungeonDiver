package Spells;

import Statuses.*;

public class SpellBuilder {
    private String name;
    private int manaCost;
    private int baseDamage;
    private int baseAmount;
    private Status status;

    public SpellBuilder(String name){
        this.name = name;
        manaCost = 0;
        baseDamage = 0;
        baseAmount = 0;
        status = null;
    }

    public String getName() {
        return name;
    }
    public int getManaCost() {
        return manaCost;
    }
    public int getBaseDamage() {
        return baseDamage;
    }
    public int getBaseAmount() {
        return baseAmount;
    }
    public Status getStatus() {
        return status;
    }

    public SpellBuilder setName(String name){
        this.name = name;
        return this;
    }
    public SpellBuilder setManaCost(int manaCost){
        this.manaCost = manaCost;
        return this;
    }
    public SpellBuilder setBaseDamage(int baseDamage){
        this.baseDamage = baseDamage;
        return this;
    }
    public SpellBuilder setBaseAmount(int baseAmount){
        this.baseAmount = baseAmount;
        return this;
    }
    public SpellBuilder setStatus(Status status){
        this.status = status;
        return this;
    }
}
