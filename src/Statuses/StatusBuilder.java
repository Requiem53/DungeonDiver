package Statuses;

public class StatusBuilder {
    String name;
    StatusStat statusStat;
    float changeAmount;
    int duration;
    StatusBuilder(){
        name = "Unknown Status";
        statusStat = null;
        changeAmount = 1;
        duration = 3;       //standard duration 3 turns
    }

    public StatusBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public StatusBuilder setStatusStat(StatusStat statusStat) {
        this.statusStat = statusStat;
        return this;
    }

    public StatusBuilder setChangeAmount(float changeAmount) {
        this.changeAmount = changeAmount;
        return this;
    }

    public StatusBuilder setDuration(int duration) {
        this.duration = duration;
        return this;
    }
    public String getName() {
        return name;
    }
    public StatusStat getStatusStat() {
        return statusStat;
    }
    public float getChangeAmount() {
        return changeAmount;
    }
    public int getDuration() {
        return duration;
    }
}
