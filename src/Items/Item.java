package Items;

import Characters.Character;
import Interfaces.*;
import Statuses.*;

public class Item{
    String name;
    Item(String name){
        this.name = name;
    }

    public String toString(){
        return name;
    }
}