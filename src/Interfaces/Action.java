package Interfaces;

import Characters.Character;

public class Action implements Comparable<Action>{
    Actionable actionable;
    Character actor;
    Character target;
    public Action(Actionable actionable, Character actor, Character target){
        this.actionable = actionable;
        this.actor = actor;
        this.target = target;
    }
    public void execute(){
        actionable.doAction(actor, target);
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
        return Integer.compare(o.getActor().getSpeed(), this.actor.getSpeed());
    }
}
