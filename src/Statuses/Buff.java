package Statuses;

public class Buff extends Status{
    public Buff(StatusBuilder builder) {
        super(builder.getName(), builder.getStatusStat(),
                builder.getChangeAmount(), builder.duration);
    }

//    @Override
//    public Buff clone() {
//        return (Buff) super.clone();
//    }


    @Override
    public String toString() {
        return super.toString() + "Buff)";
    }

    public static class Loyalty extends Buff{
        public Loyalty() {
            super(new StatusBuilder().setName("Loyalty").setStatusStat(StatusStat.DEFENSE)
                    .setChangeAmount(.3f));
        }
    }
    public static class Shrouded extends Buff{

        public Shrouded() {
            super(new StatusBuilder().setName("Shrouded").setStatusStat(StatusStat.EVASION)
                    .setChangeAmount(.5f));
        }
    }
}
