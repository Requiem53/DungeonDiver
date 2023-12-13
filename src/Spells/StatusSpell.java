package Spells;

import Characters.Character;
import Interfaces.StatusInflicting;
import Statuses.Buff;
import Statuses.Debuff;
import Statuses.Status;

public abstract class StatusSpell extends Spell implements StatusInflicting {

    final Status status;
    public StatusSpell(SpellBuilder builder) {
        super(builder);
        this.status = builder.getStatus();
    }

    public String doAction(Character actor, Character target){
        inflictStatus(actor, target);
        StringBuilder string = new StringBuilder();
        if(actor == target){
            string.append(actor.getName()).append(" used ").append(name).append("onto himself").append("\n");
        }else{
            string.append(actor.getName()).append(" used ").append(name).append("onto ").append(target.getName()).append("\n");
        }

        if(status instanceof Buff){
            string.append(target.getName()).append(" was blessed with ").append(status);
        }else{
            string.append(target.getName()).append(" was inflicted with ").append(status);
        }

        return string.toString();
    }

    @Override
    public void inflictStatus(Character actor, Character target) {
        target.addStatus(status.clone());
    }

    @Override
    public String toString() {
        return super.toString() + "[Status: " + status + "]";
    }

    public boolean isBuff(){
        return this.status instanceof Buff;
    }

    public static class LoyaltyHymn extends StatusSpell{
        public LoyaltyHymn() {
            super(new SpellBuilder().setManaCost(3).setName("Loyalty Hymn").setStatus(new Buff.Loyalty()));
        }

        @Override
        public String flavorText(Character actor, Character target) {
            return actor + " used " + name + " as the loyal protector of their party";
        }
    }
    public static class Shroud_Mist extends StatusSpell{
        public Shroud_Mist(){
            super(new SpellBuilder().setManaCost(5).setName("Shroud Mist").setStatus(new Buff.Shrouded()));
        }

        @Override
        public String flavorText(Character actor, Character target) {
            return actor + " produced a " + name + " to lurk away from the enemies";
        }
    }
    public static class Strength extends StatusSpell{
        public Strength() {
            super(new SpellBuilder().setManaCost(5).setName("Strength").setStatus(new Buff.Brute_Force()));
        }
        @Override
        public String flavorText(Character actor, Character target) {
            return actor + " will now strengthen their teammate's power";
        }
    }
    public static class Wisdom extends StatusSpell{
        public Wisdom(){
            super(new SpellBuilder().setManaCost(5).setName("Wisdom").setStatus(new Buff.Wise()));
        }
        @Override
        public String flavorText(Character actor, Character target) {
            return actor + " will now share knowledge to their teammate";
        }
    }
    public static class Momentum extends StatusSpell{
        public Momentum() {
            super(new SpellBuilder().setManaCost(5).setName("Momentum").setStatus(new Buff.Haste()));
        }
        @Override
        public String flavorText(Character actor, Character target) {
            return actor + " used the forbidden person-bound time magic to cast " + name;
        }
    }
    public static class Armor_Shred extends StatusSpell{
        public Armor_Shred(){
            super(new SpellBuilder().setManaCost(10).setName("Armor Shred").setStatus(new Debuff.Shred()));
        }
        @Override
        public String flavorText(Character actor, Character target) {
            return actor + " will now shred the enemy's defense";
        }
    }
    public static class Leisure extends StatusSpell{
        public Leisure() {
            super(new SpellBuilder().setManaCost(5).setName("Leisure").setStatus(new Debuff.Slow()));
        }
        @Override
        public String flavorText(Character actor, Character target) {
            return actor + " will now use time magic " + name + " against the enemy ";
        }
    }
    public static class Truce extends StatusSpell{
        public Truce() {
            super(new SpellBuilder().setManaCost(10).setName("Truce").setStatus(new Debuff.Disarm()));
        }
        @Override
        public String flavorText(Character actor, Character target) {
            return "A (fake) truce called by " + actor + " will weaken the enemy";
        }
    }
    public static class Mental_Block extends StatusSpell{
        public Mental_Block() {
            super(new SpellBuilder().setManaCost(10).setName("Mental Block").setStatus(new Debuff.Amnesia()));
        }
        @Override
        public String flavorText(Character actor, Character target) {
            return "The enemy will now forget their arcane knowledge";
        }
    }
}
