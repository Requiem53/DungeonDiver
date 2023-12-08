package Attacks;

import Statuses.Status;

public class AttackBuilder {
    private String name;
    private int baseDamage;
    private int baseSpeed;
    private Status status;

    public AttackBuilder(String name){
        this.name = name;
        baseDamage = 0;
        baseSpeed = 0;
        status = null;
    }

    public String getName() {
        return name;
    }
    public int getBaseDamage() {
        return baseDamage;
    }
    public int getBaseSpeed() {
        return baseSpeed;
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
    public AttackBuilder setBaseSpeed(int baseSpeed){
        this.baseSpeed = baseSpeed;
        return this;
    }
    public AttackBuilder setStatus(Status status){
        this.status = status;
        return this;
    }
}
