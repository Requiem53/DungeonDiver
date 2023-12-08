package Attacks;

import Statuses.Status;

public class AttackBuilder {
    private String name;
    private int baseDamage;
    private float baseMultiDamage; //for multiplying amplifier for attack
    private int speed;
    private Status status;

    public AttackBuilder(){
        name = "MissingAttack";
        baseDamage = 0;
        baseMultiDamage = 1;
        speed = 0;
        status = null;
    }

    public String getName() {
        return name;
    }
    public int getBaseDamage() {
        return baseDamage;
    }
    public float getBaseMultiDamage() {
        return baseMultiDamage;
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
    public AttackBuilder setBaseMultiDamage(float baseMultiDamage){
        this.baseMultiDamage = baseMultiDamage;
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
