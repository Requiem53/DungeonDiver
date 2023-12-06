package Equipment;

public abstract class Armor extends Equippable{
    private Armor(EquippableBuilder builder) {
        super(builder);
    }

    public static class ClothArmor extends Armor{
        public ClothArmor(EquippableBuilder builder) {
            super(builder.setName("Cloth Armor").setDefense(10));
        }
    }
}
