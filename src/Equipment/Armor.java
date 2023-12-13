package Equipment;

public abstract class Armor extends Equippable{
    private Armor(EquippableBuilder builder) {
        super(builder);
    }

    public static class ClothArmor extends Armor{
        public ClothArmor() {
            super(new EquippableBuilder().setName("Cloth Armor").setDefense(10).setPower(5).setMagicPower(5));
        }
    }
    public static class KnightsArmor extends Armor{
        public KnightsArmor() {
            super(new EquippableBuilder().setName("Knight's Armor").setDefense(20));
        }
    }

    public static class Steel_Chestplate extends Armor{
        public Steel_Chestplate(){
            super(new EquippableBuilder().setName("Steel Chestplate").setMaxHealth(30).setDefense(30));
        }
    }
    public static class Dark_Cloak extends Armor{
        public Dark_Cloak() {
            super(new EquippableBuilder().setName("Dark Cloak").setMaxHealth(20).setDefense(10).setSpeed(10).setEvasion(0.1f));
        }
    }
    public static class Elven_Robe extends Armor{
        public Elven_Robe() {
            super(new EquippableBuilder().setName("Elven Robe").setMaxHealth(20).setDefense(10).setSpeed(5).setMagicPower(20));
        }
    }

    public static class Cleric_Garment extends Armor{
        public Cleric_Garment() {
            super(new EquippableBuilder().setName("Cleric_Garment").setMaxHealth(30).setDefense(15).setSpeed(8).setMagicPower(10));
        }
    }
}
