import java.util.Scanner;

public class TestState extends State{

    public TestState(BattleSystem bs) {
        super(bs);
    }

    @Override
    public void Start() {
        System.out.println("Test: ");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        bs.setState(new Test2State(bs));

    }
}
