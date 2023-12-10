package CharacterComponents;

import java.util.ArrayList;
import java.util.List;

import Attacks.Attack;
import Interfaces.Actionable;
import Items.Item;
import Spells.Spell;

public class DoableActions {
    private ArrayList<Attack> attacks;
    private ArrayList<Spell> spells;
    private ArrayList<Item> inventory;

    public DoableActions(ArrayList<Attack> attacks, ArrayList<Spell> spells, ArrayList<Item> inventory) {
        this.attacks = attacks;
        this.spells = spells;
        this.inventory = inventory;
    }

    public void addSpell(Spell spell) {
        spells.add(spell);
    }
    public void addItem(Item item){
        inventory.add(item);
    }

    public void listActions(ArrayList<Actionable> actionables){
        StringBuilder string = new StringBuilder();
        for(int i=0; i < actionables.size(); i++){
            string.append("[").append(i + 1).append("] ").append(actionables.get(i)).append(" ");
        }
        System.out.println(string);
    }

    public ArrayList<Attack> getAttacks() {
        return attacks;
    }
    public ArrayList<Spell> getSpells() {
        return spells;
    }
    public ArrayList<Item> getInventory() {
        return inventory;
    }

}
