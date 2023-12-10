package Items;

import Statuses.*;

public class ItemBuilder {
    private String name;
    private int damage;
    private int amount;
    private Status status;

    public ItemBuilder(){
        name = "MissingItem";
        damage = 0;
        amount = 0;
        status = null;
    }
    public ItemBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ItemBuilder setDamage(int damage) {
        this.damage = damage;
        return this;
    }

    public ItemBuilder setAmount(int amount) {
        this.amount = amount;
        return this;
    }

    public ItemBuilder setStatus(Status status) {
        this.status = status;
        return this;
    }
    public String getName() {
        return name;
    }
    public int getDamage() {
        return damage;
    }
    public int getAmount() {
        return amount;
    }
    public Status getStatus() {
        return status;
    }
}
