package Equipment;

public abstract class Equippable {
    protected String name;
    protected int maxHealth;
    protected int power;
    protected int speed;
    protected int defense;
    protected int magicPower;
    protected float evasion;

    private boolean isEquipped;

    Equippable(EquippableBuilder builder){
        name = builder.getName();
        maxHealth = builder.getMaxHealth();
        power = builder.getPower();
        speed = builder.getSpeed();
        defense = builder.getDefense();
        magicPower = builder.getMagicPower();
        evasion = builder.getEvasion();
    }
    public String toString(){
        return getName() + " (HP: " + getMaxHealth() +
                "; POW: " + getPower() +
                "; SPD: " + getSpeed() +
                "; DEF: " + getDefense() +
                "; MP: " + getMagicPower() +
                "; EVA: " + getEvasion() + ")";
    }
    public String toStringHTML(){
        return "<html>" + getName() + " (Max Health: " + getMaxHealth() +
                "; Power: " + getPower() +
                "; </br>Speed: " + getSpeed() +
                "; Defense: " + getDefense() +
                "; </br>Magic Power: " + getMagicPower() +
                "; Evasion: " + getEvasion() + ")</html>";
    }

    public String getName() {
        return name;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getPower() {
        return power;
    }

    public int getSpeed() {
        return speed;
    }

    public int getDefense() {
        return defense;
    }

    public int getMagicPower() {
        return magicPower;
    }

    public float getEvasion() {
        return evasion;
    }

    public boolean isEquipped() {
        return isEquipped;
    }

    public void setEquipped(boolean equipped) {
        isEquipped = equipped;
    }
}
