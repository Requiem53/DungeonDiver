package Interfaces;

import Characters.Character;

import java.util.List;

public class Action implements Comparable<Action>{
    Actionable actionable;
    Character actor;
    Character target;
    int actionSpeed;

    public Action(Actionable action, Character actor, Character target){
        this.actionable = action;
        this.actor = actor;
        this.target = target;
        actionSpeed = getActor().getSpeed() + getActionable().getSpeed();
    }

    public String execute(){
        if(actionable != null){
            if(!actor.isAlive())
                return actor + " cannot make a move because they are already dead!";
            if(!target.isAlive())
                return actor + " tried to do something, but " + target + " is already dead!";
            return actionable.doAction(actor, target);
        }
        else return "Null action"; //not work. try catch soon
    }

    public void removeFromList(List<Character> characters, Character chara){
        characters.remove(chara);
    }

    @Override
    public int compareTo(Action o) {
        return Integer.compare(o.actionSpeed, this.actionSpeed);
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
    public String toString() {
        return actionable.name + "; actor: " + actor + "; target: " + target;
    }
}
