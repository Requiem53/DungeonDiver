package States;

import Characters.AllyClass;
import Characters.AllyClassList;
import Characters.Character;
import GameSystems.BattleSystem;

public class CreateParty extends State{

    public CreateParty(BattleSystem bs) {
        super(bs);
    }

    @Override
    public void Start() {
        String nameInput;
        AllyClass allyClass;

        System.out.println("Add new party members: ");
        for (int i = 0; i < 4; i++){
            System.out.println((i+1) + "/4" +" What is the name of your new party member?");
            nameInput = sc.nextLine();
            allyClass = AllyClassList.getInstance().createNewClass();
            bs.getParty().addMember(new Character.Ally(nameInput, allyClass));
        }

        System.out.println("Here is your party: ");
        for(Character ally : bs.getPartyMembers()){
            System.out.println(ally + " - " + ally.getClassName());
        }

        bs.setState(new InitializeBattlers(bs));
    }
}
