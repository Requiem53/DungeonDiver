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
                    .setChangeAmount(.5f));
        }
    }
    public static class Shrouded extends Buff{
        public Shrouded() {
            super(new StatusBuilder().setName("Shrouded").setStatusStat(StatusStat.EVASION)
                    .setChangeAmount(.3f));
        }
    }
    public static class Brute_Force extends Buff{
        public Brute_Force() {
            super(new StatusBuilder().setName("Brute Force").setStatusStat(StatusStat.POWER)
                    .setChangeAmount(.2f));
        }
    }
    public static class Wise extends Buff{
        public Wise() {
            super(new StatusBuilder().setName("Wise").setStatusStat(StatusStat.MAGIC_POWER)
                    .setChangeAmount(.2f));
        }
    }
    public static class Vitality extends Buff{
        public Vitality() {
            super(new StatusBuilder().setName("Vitality").setStatusStat(StatusStat.HEALTH)
                    .setChangeAmount(.5f));
        }
    }
    public static class Haste extends Buff{
        public Haste() {
            super(new StatusBuilder().setName("Haste").setStatusStat(StatusStat.SPEED)
                    .setChangeAmount(0.3f));
        }
    }
}