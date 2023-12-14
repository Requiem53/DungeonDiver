package States;

import GameSystems.BattleSystem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import Characters.Character;

public class Victory extends State {
    public Victory(BattleSystem bs) {
        super(bs);
    }
    @Override
    public void Start(){
        System.out.println("You win boy");
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("../HallOfLegends.txt", true));
            StringBuilder string = new StringBuilder();
            int index = 0;
            string.append("\n\n").append(bs.getUser()).append("'s party: ");
            for(Character chara : bs.getPartyMembers()){
                index++;
                string.append(index).append(". ").append(chara).append("\n");
            }
            bw.write(string.toString());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
