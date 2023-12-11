package Equipment;

public abstract class Armor extends Equippable{
    private Armor(EquippableBuilder builder) {
        super(builder);
    }

    public static class ClothArmor extends Armor{
        public ClothArmor() {
            super(new EquippableBuilder().setName("Cloth Armor").setDefense(10));
        }
    }

    public static class KnightsAmor extends Armor{
        public KnightsAmor() {
            super(new EquippableBuilder().setName("Knight's Armor").setDefense(20));
        }
    }
}
