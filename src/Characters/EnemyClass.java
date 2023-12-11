package Characters;

public abstract class EnemyClass extends CharacterClass{

    public EnemyClass(String name, int maxHealth, int power, int speed, int defense, int magicPower) {
        super(name, maxHealth, power, speed, defense, magicPower);
    }

    public static class Goblin extends EnemyClass{
        public Goblin() {
            super("Goblin", 20, 5, 5, 5, 2);
        }
    }

    public static class EvilMage extends EnemyClass{
        public EvilMage() {
            super("Evil Mage", 10, 2, 5, 2, 10);
        }
    }
}
