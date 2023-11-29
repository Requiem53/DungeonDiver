import java.util.Scanner;

public class Test2State extends State{
    public Test2State(BattleSystem bs) {
        super(bs);
    }

    @Override
    public void Start() {
        System.out.println("Test2: ");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        bs.setState(new TestState(bs));
    }
}
