package Attacks;

import Statuses.Status;

public class AttackBuilder {
    private String name;
    private float basePower;
    private int flatAttackBonus;
    private int speed;
    private Status status;

    public AttackBuilder(){
        name = "MissingAttack";
        basePower = 1f;
        flatAttackBonus = 0;
        speed = 0;
        status = null;
    }

    public String getName() {
        return name;
    }
    public float getBasePower() {
        return basePower;
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
    public AttackBuilder setBasePower(float basePower){
        this.basePower = basePower;
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
