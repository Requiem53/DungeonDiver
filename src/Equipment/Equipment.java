package Equipment;

import Weapons.Weapon;

public class Equipment {

    private Weapon weapon;

    public void equipWeapon(Weapon weapon){
        this.weapon = weapon;
    }
    public void unequipWeapon(){
        weapon = null;
    }

    public Weapon getWeapon() {
        return weapon;
    }
}
