public class BattleStart extends State{

    public BattleStart(BattleSystem bs) {
        super(bs);
    }

    @Override
    public void Start() {
        System.out.println("The battle is starting....");
        bs.turnOrder();
        bs.setState(new Turn(bs));
    }
}
