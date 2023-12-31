package Spells;

import Statuses.*;

public class SpellBuilder {
    private String name;
    private int manaCost;
    private float basePower;
    private float baseAmount;
    private Status status;

    public SpellBuilder(){
        name = "MissingSpell";
        manaCost = 0;
        basePower = 0;
        baseAmount = 0;
        status = null;
    }

    public String getName() {
        return name;
    }
    public int getManaCost() {
        return manaCost;
    }
    public float getBasePower() {
        return basePower;
    }
    public float getBaseAmount() {
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
    public SpellBuilder setBasePower(float basePower){
        this.basePower = basePower;
        return this;
    }
    public SpellBuilder setBaseAmount(float baseAmount){
        this.baseAmount = baseAmount;
        return this;
    }
    public SpellBuilder setStatus(Status status){
        this.status = status;
        return this;
    }
}
