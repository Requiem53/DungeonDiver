package Actions;

import Characters.Character;
import Spells.*;
import Interfaces.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CastSpellAction implements I_Action{

    Character target;
    Character caster;

    public CastSpellAction(Character target, Character caster) {
        this.target = target;
        this.caster = caster;
    }

    @Override
    public void execute() {
        if(caster instanceof Character.Ally){
            int spellChoice = 0;
            Scanner sc = new Scanner(System.in);
            System.out.println("What spells do " + caster.getName() + " want to use? Choose: ");
            System.out.println(caster.toStringSpells());
            try{
                while(true){
                    spellChoice = sc.nextInt();
                    sc.nextLine();
                    if(spellChoice > caster.getSpells().size()){
                        System.out.println("Choice is out of bounds");
                    }else break;
                }
            }catch(InputMismatchException e){
                System.out.println("Since you didn't enter a number, we will use the first choice >:)");
                spellChoice = 0;
            }
            Spell spellUsed = caster.getSpells().get(spellChoice);
            ((Move)spellUsed).doMove(target);
        }else{
            //Enemy AI implementation
        }
    }
}