package Statuses;

import Characters.Character;

public abstract class Status implements Cloneable{
    String name;
    StatusStat statusStat;
    float changeAmount;
    int duration;

    public Status(String name, StatusStat statusStat, float changeAmount, int duration) {
        this.name = name;
        this.statusStat = statusStat;
        this.changeAmount = changeAmount;
        this.duration = duration;
    }

    public StatusStat getStatusStat(){
        return statusStat;
    }
    public float getChangeAmount(){
        return changeAmount;
    }
    public int getDuration() {
        return duration;
    }
    public void decrementDuration(){
        duration--;
    }
    public void inflictStatus(Character target){
        target.addStatus(this);
    }
    @Override
    public Status clone(){
        try{
            return (Status)super.clone();
        }catch(CloneNotSupportedException e){
            System.out.println("Cloning failed");
            return null;
        }
    }
    @Override
    public String toString() {
        String res = name;
        switch (statusStat){
            case HEALTH -> res += "(Health ";
            case POWER -> res += "(Power ";
            case SPEED -> res += "(Speed ";
            case DEFENSE -> res += "(Defense ";
            case MAGIC_POWER -> res += "(Magic Power ";
            case EVASION -> res += "(Evasion ";
            default -> res += "(Unknown ";
        }
        return res;
    }
}