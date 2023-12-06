package Spells;

import Characters.Character;
import Statuses.*;

public class SpellBuilder {
    private String name;
    private Character user;
    private int manaCost;
    private int baseDamage;
    private int baseAmount;
    private Status status;

    SpellBuilder(String name){
        user = null;
        manaCost = 0;
        baseDamage = 0;
        baseAmount = 0;
        status = null;
    }

    public String getName() {
        return name;
    }
    public Character getUser() {
        return user;
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

    SpellBuilder setUser(Character user){
        this.user = user;
        return this;
    }
    SpellBuilder setManaCost(int manaCost){
        this.manaCost = manaCost;
        return this;
    }
    SpellBuilder setBaseDamage(int baseDamage){
        this.baseDamage = baseDamage;
        return this;
    }
    SpellBuilder setBaseAmount(int baseAmount){
        this.baseAmount = baseAmount;
        return this;
    }
    SpellBuilder setStatus(Status status){
        this.status = status;
        return this;
    }
}
