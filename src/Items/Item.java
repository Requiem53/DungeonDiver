package Items;

import Interfaces.*;

public abstract class Item extends Actionable{
    public Item(ItemBuilder builder){
        this.name = builder.getName();
    }
}