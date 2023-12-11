package Equipment;

public abstract class Weapon extends Equippable{
    private Weapon(EquippableBuilder builder) {
        super(builder);
    }

    public static class Sword extends Weapon{
        public Sword() {
            super(new EquippableBuilder().setName("Sword").setPower(10)); //inani style paghimo
        }
    }

    public static class Dagger extends Weapon{
        public Dagger() {
            super(new EquippableBuilder().setName("Dagger").setPower(5).setSpeed(5));
        }
    }
    public static class Wand extends Weapon{
        public Wand() {
            super(new EquippableBuilder().setName("Wand").setPower(1).setSpeed(6).setMagicPower(10));
        }
    }
    public static class Staff extends Weapon{
        public Staff() {
            super(new EquippableBuilder().setName("Wand").setPower(1).setSpeed(6).setMagicPower(15));
        }
    }
}