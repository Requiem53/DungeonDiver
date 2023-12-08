package Attacks;

import Statuses.Status;

public class AttackBuilder {
    private String name;
    private int baseDamage;
    private int flatAttackBonus;
    private int speed;
    private Status status;

    public AttackBuilder(){
        name = "MissingAttack";
        baseDamage = 100;
        flatAttackBonus = 0;
        speed = 0;
        status = null;
    }

    public String getName() {
        return name;
    }
    public int getBaseDamage() {
        return baseDamage;
    }
    public int getFlatAttackBonus() {
        return flatAttackBonus;
    }

    public int getSpeed() {
        return speed;
    }

    public Status getStatus() {
        return status;
    }

    public AttackBuilder setName(String name){
        this.name = name;
        return this;
    }
    public AttackBuilder setBaseDamage(int baseDamage){
        this.baseDamage = baseDamage;
        return this;
    }
    public AttackBuilder getFlatAttackBonus(int flatAttackBonus){
        this.flatAttackBonus = flatAttackBonus;
        return this;
    }
    public AttackBuilder setSpeed(int speed){
        this.speed = speed;
        return this;
    }
    public AttackBuilder setStatus(Status status){
        this.status = status;
        return this;
    }
}
