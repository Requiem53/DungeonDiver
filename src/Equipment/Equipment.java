package Equipment;

public class Equipment {

    private Weapon weapon;
    private Armor armor;

    public void equipWeapon(Weapon weapon){
        this.weapon = weapon;
    }

    public void equipArmor(Armor armor){
        this.armor = armor;
    }

    public void unequipWeapon(){
        weapon = null;
    }

    public void unequipArmor(){
        armor = null;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Armor getArmor() {
        return armor;
    }
}