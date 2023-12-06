public abstract class Character implements Comparable<Character> {
    //pun an guro spells pero I guess sakto na ang weapons
    //simple only
    //Add AI to enemy too
    //simply only as well


    //Wa pa ni equipment shit
    private String name;
    private CharacterClass charClass;

    public Character(String name, CharacterClass charClass) {
        this.name = name;
        this.charClass = charClass;
    }

    public void currentDetails(){
        System.out.println(name + "\n"
        + "Health: " + " (" + getCurrHealth() + "/" + getMaxHealth() + ") \n"
        + "Mana: "  + " (" + getCurrMana() + "/" + getMagicPower() + ") \n"
        + "Power: " + getPower() + "\n"
        + "Speed: " + getSpeed() + "\n"
        + "Defense: " + getDefense() + "\n"
        );
    }

    public int attack(Character character){
        return charClass.attack(character);
    }

    public void takeDamage(int damage){
        charClass.takeDamage(damage);
    }

    public String toString(){
        return name;
    }

    public boolean isAlive(){
        return getCurrHealth() > 0;
    }

    public int getMaxHealth() {
        return charClass.getMaxHealth();
    }

    public int getPower() {
        return charClass.getPower();
    }

    public int getSpeed() {
        return charClass.getSpeed();
    }

    public int getDefense() {
        return charClass.getDefense();
    }

    public int getMagicPower() {
        return charClass.getMagicPower();
    }

    public int getCurrHealth() {
        return charClass.getCurrHealth();
    }

    public int getCurrMana(){
        return charClass.getCurrMana();
    }

    @Override
    public int compareTo(Character o){
        return Integer.compare(o.getSpeed(), this.getSpeed());
    }

    public static class Ally extends Character{
        public Ally(String name, CharacterClass charClass) {
            super(name, charClass);
        }
    }

    public static class Enemy extends Character{
        public Enemy(String name, CharacterClass charClass) {
            super(name, charClass);
        }
    }
}
