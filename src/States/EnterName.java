package States;

import GameSystems.BattleSystem;
import GameSystems.User;

public class EnterName extends State {
    public EnterName(BattleSystem bs) {
        super(bs);
    }

    @Override
    public void Start() {
        enterName();
        bs.setState(new CreateParty(bs));
    }

    private void enterName(){
        String name = null;
        while(true){
            System.out.print("Enter your name: ");
            name = sc.nextLine();
            if(name.equals("")){
                System.out.println("You did not enter anything...");
            }else break;
        }
        bs.user = new User(name);
    }
}
