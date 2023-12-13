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

    public static class Shred extends Debuff{
        public Shred() {
            super(new StatusBuilder().setName("Shred").setStatusStat(StatusStat.DEFENSE)
                    .setChangeAmount(0.3f));
        }
    }
    public static class Slow extends Debuff{
        public Slow() {
            super(new StatusBuilder().setName("Slow").setStatusStat(StatusStat.SPEED)
                    .setChangeAmount(0.3f));
        }
    }
    public static class Disarm extends Debuff{
        public Disarm() {
            super(new StatusBuilder().setName("Disarm").setStatusStat(StatusStat.POWER)
                    .setChangeAmount(0.2f));
        }
    }
    public static class Amnesia extends Debuff{
        public Amnesia() {
            super(new StatusBuilder().setName("Amnesia").setStatusStat(StatusStat.MAGIC_POWER)
                    .setChangeAmount(0.3f));
        }
    }
}