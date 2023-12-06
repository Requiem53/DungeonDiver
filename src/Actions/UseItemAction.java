package Actions;

import Characters.Character;

public class UseItemAction implements I_Action{

    Character target;
    Character user;

    public UseItemAction(Character target, Character user) {
        this.target = target;
        this.user = user;
    }

    @Override
    public void execute() {

    }
}
