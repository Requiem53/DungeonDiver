package CharacterComponents;

import java.util.ArrayList;

import Attacks.Attack;
import Items.Item;
import Spells.Spell;

public class DoableActions {
    private ArrayList<Attack> attacks;
    private ArrayList<Spell> spells;
    private ArrayList<Item> items;

    public DoableActions(ArrayList<Attack> attacks, ArrayList<Spell> spells, ArrayList<Item> items) {
        this.attacks = attacks;
        this.spells = spells;
        this.items = items;
    }

    public void addSpell(Spell spell) {
        spells.add(spell);
    }
    public void addItem(Item item){
        items.add(item);
    }

    public ArrayList<Attack> getAttacks() {
        return attacks;
    }

    public ArrayList<Spell> getSpells() {
        return spells;
    }


    public ArrayList<Item> getItems() {
        return items;
    }

}
