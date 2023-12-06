package Equipment;

public abstract class Weapon extends Equippable{
    private Weapon(EquippableBuilder builder) {
        super(builder);
    }

    public static class Sword extends Weapon{
        public Sword(EquippableBuilder builder) {
            super(builder.setName("Sword").setPower(10));
        }
    }

    public static class Dagger extends Weapon{
        public Dagger(EquippableBuilder builder) {
            super(builder);
        }
    }
    public static class Wand extends Weapon{
        public Wand(EquippableBuilder builder) {
            super(builder);
        }
    }
    public static class Staff extends Weapon{
        public Staff(EquippableBuilder builder) {
            super(builder);
        }
    }
}