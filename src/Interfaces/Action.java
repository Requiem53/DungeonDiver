package Interfaces;

import Characters.Character;

public class Action implements Comparable<Action>{
    ActionType actionType;
    Character actor;
    Character target;
    int actionSpeed;

    public Action(ActionType actionType, Character actor, Character target){
        this.actionType = actionType;
        this.actor = actor;
        this.target = target;
        actionSpeed = getActor().getSpeed() + getActionable().getSpeed();
    }
    public void execute(){
        if(actionType != null) actionType.doAction(actor, target);
        else System.out.println("Null action"); //not work. try catch soon
    }
    public ActionType getActionable(){
        return actionType;
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
