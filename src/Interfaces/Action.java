package Interfaces;

import Characters.Character;

public class Action implements Comparable<Action>{
    Actionable actionable;
    Character actor;
    Character target;
    int actionSpeed;

    public Action(Actionable actionable, Character actor, Character target){
        this.actionable = actionable;
        this.actor = actor;
        this.target = target;
        actionSpeed = getActor().getSpeed() + getActionable().getSpeed();
    }
    public void execute(){
        if(actionable != null)actionable.doAction(actor, target);
        else System.out.println("Null action"); //not work. try catch soon
    }
    public Actionable getActionable(){
        return actionable;
    }
    public Character getActor() {
        return actor;
    }
    public Character getTarget() {
        return target;
    }

    @Override
    public int compareTo(Action o) {
        return Integer.compare(o.actionSpeed, this.actionSpeed);
    }
}
