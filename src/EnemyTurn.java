import java.util.Scanner;

public class EnemyTurn extends State{
    public EnemyTurn(BattleSystem bs) {
        super(bs);
    }

    @Override
    public void Start() {
        System.out.println(bs.characters.get(bs.getCurrentTurn()) + " is wondering about what they " +
                "will do next....");
        bs.setState(new Turn(bs));
    }
}
