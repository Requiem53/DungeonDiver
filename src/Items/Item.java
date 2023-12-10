package Items;

import Characters.Character;
import Interfaces.*;
import Statuses.*;

public abstract class Item extends Actionable{
    private int damage;
    private int amount;
    private Status status;

    public Item(ItemBuilder builder){
        this.name = builder.getName();
        this.damage = builder.getDamage();
        this.amount = builder.getAmount();
        this.status = builder.getStatus();
    }
}