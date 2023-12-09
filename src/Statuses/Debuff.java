package Statuses;

public class Debuff extends Status{
    public Debuff(StatusBuilder builder) {
        super(builder.getName(), builder.getStatusStat(),
                builder.getChangeAmount(), builder.duration);
    }
//    @Override
//    public Debuff clone() {
//        return (Debuff) super.clone();
//    }

    @Override
    public String toString() {
        return super.toString() + "Debuff)";
    }
}
