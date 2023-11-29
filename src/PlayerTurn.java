import java.util.Scanner;

public class PlayerTurn extends State{
    public PlayerTurn(BattleSystem bs) {
        super(bs);
    }

    @Override
    public void Start() {
        System.out.println("What will " + bs.characters.get(bs.getCurrentTurn()) + " do?");
        option = sc.nextLine();
        switch (option){
            case "Next":
                bs.setState(new Turn(bs));
                break;
            default:
                break;
        }



    }
}
