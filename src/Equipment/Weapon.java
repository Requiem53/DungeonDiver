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
    public static class Steel_Sword extends Weapon{
        public Steel_Sword(){
            super(new EquippableBuilder().setName("Steel Sword").setPower(20).setSpeed(5).setMaxHealth(10));
        }
    }
    public static class Sword_Of_Light extends Weapon{
        public Sword_Of_Light(){
            super(new EquippableBuilder().setName("Sword of Light").setPower(35).setSpeed(15).setMaxHealth(30).setDefense(10));
        }
    }

    public static class Dagger extends Weapon{
        public Dagger() {
            super(new EquippableBuilder().setName("Dagger").setPower(5).setSpeed(5));
        }
    }
    public static class Sharp_Dagger extends Weapon{
        public Sharp_Dagger() {
            super(new EquippableBuilder().setName("Sharp Dagger").setPower(25).setSpeed(15));
        }
    }
    public static class Executioner_Blade extends Weapon{
        public Executioner_Blade() {
            super(new EquippableBuilder().setName("Executioner Blade").setPower(40).setSpeed(30).setMaxHealth(10).setEvasion(.1f));
        }
    }

    public static class Wand extends Weapon{
        public Wand() {
            super(new EquippableBuilder().setName("Wand").setPower(5).setSpeed(3).setMagicPower(15));
        }
    }
    public static class Advanced_Wand extends Weapon{
        public Advanced_Wand() {
            super(new EquippableBuilder().setName("Advanced Wand").setPower(5).setSpeed(10).setMagicPower(25));
        }
    }
    public static class Elven_Wand extends Weapon{
        public Elven_Wand() {
            super(new EquippableBuilder().setName("Elven Wand").setPower(5).setSpeed(20).setMagicPower(50));
        }
    }
    public static class Staff extends Weapon{
        public Staff() {
            super(new EquippableBuilder().setName("Staff").setPower(5).setSpeed(4).setMagicPower(10));
        }
    }
    public static class Springwood_Staff extends Weapon{
        public Springwood_Staff() {
            super(new EquippableBuilder().setName("Springwood Staff").setPower(5).setSpeed(12).setMagicPower(20).setMaxHealth(10));
        }
    }
    public static class Holy_Staff extends Weapon{
        public Holy_Staff() {
            super(new EquippableBuilder().setName("Holy Staff").setPower(5).setSpeed(25).setMagicPower(30).setMaxHealth(25));
        }
    }
}