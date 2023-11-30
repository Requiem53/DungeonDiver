public abstract class Weapon {
    private int power;
    private int magicPower;

    public Weapon(int power) {
        this.power = power;
        magicPower = 0;
    }

    public Weapon(int power, int magicPower) {
        this.power = power;
        this.magicPower = magicPower;
    }

    public int getPower() {
        return power;
    }

    public int getMagicPower() {
        return magicPower;
    }

    //Weapons
    public static class Club extends Weapon{
        public Club() {
            super(10);
        }
    }

    public static class Sword extends Weapon{
        public Sword() {
            super(20);
        }
    }

    public static class Wand extends Weapon{
        public Wand(){
            super(1,10);
        }
    }

    public static class MagicWand extends Weapon{
        public MagicWand(){
            super(2,20);
        }
    }
}


