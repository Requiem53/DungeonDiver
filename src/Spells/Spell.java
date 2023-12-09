package Spells;

import Characters.Character;
import Interfaces.*;
import Statuses.*;

public abstract class Spell{
    public String name;
    int manaCost;
    Spell(String name, int manaCost) {
        this.name = name;
        this.manaCost = manaCost;
    }
}