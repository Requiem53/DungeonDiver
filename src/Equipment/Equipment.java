package Equipment;

import java.util.ArrayList;
import java.util.List;

public class Equipment {

    private List<Equippable> equipmentList;

    private Weapon weapon;
    private Armor armor;

    public Equipment(){
        equipmentList = new ArrayList<Equippable>();
        weapon = null;
        armor = null;
    }

    public void addEquippable(Equippable equippable){
        equipmentList.add(equippable);
    }

    public void equipEquippable(Equippable equippable){
        if(equippable instanceof Weapon){
            equipWeapon((Weapon) equippable);
        }
        if(equippable instanceof Armor){
            equipArmor((Armor) equippable);
        }
    }

    public void equipWeapon(Weapon weapon){
        this.weapon = weapon;
        weapon.setEquipped(true);
        System.out.println("Equipped weapon");
    }

    public void equipArmor(Armor armor){
        this.armor = armor;
        armor.setEquipped(true);
        System.out.println("Equipped armor");
    }

    public void unequipEquippable(Equippable equippable){
        if(equippable instanceof Weapon){
            unequipWeapon();
        }
        if(equippable instanceof Armor){
            unequipArmor();
        }
    }

    public void unequipWeapon(){
        weapon.setEquipped(false);
        equipmentList.add(weapon);
        this.weapon = null;
        System.out.println("Unequipped weapon");
    }

    public void unequipArmor(){
        armor.setEquipped(false);
        equipmentList.add(armor);
        this.armor = null;
        System.out.println("Unequipped armor");
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public String equipMessage(Equippable equipment){
        if(equipment.isEquipped()){
            return " (EQUIPPED)";
        }
        return "";
    }

    public void viewEquipment(){
        int index = 1;
        for(Equippable equippable : equipmentList){
            System.out.println(index + ". " + equippable + equipMessage(equippable));
            index++;
        }
        System.out.println(index + ". Exit");
    }

    public void processEquipment(int choice){
        int index = choice-1;
        Equippable currEquipment = equipmentList.get(index);
        if(choice < equipmentList.size()){
            if(currEquipment.isEquipped()){
                unequipEquippable(currEquipment);
            }else{
                equipEquippable(currEquipment);
            }
        }

    }
}