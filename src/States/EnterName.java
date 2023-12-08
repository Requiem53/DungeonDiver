package States;

import GameSystems.BattleSystem;
import GameSystems.State;
import GameSystems.User;

public class EnterName extends State {
    public EnterName(BattleSystem bs) {
        super(bs);
    }

    @Override
    public void Start() {
        String name = null;
        while(true){
            System.out.print("Enter your name: ");
            name = sc.nextLine();
            if(name.equals("")){
                System.out.println("You did not enter anything...");
            }else break;
        }
        bs.user = new User(name);
        bs.setState(new BattleStart(bs));
    }
}
