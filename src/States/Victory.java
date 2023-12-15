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
            FileWriter fw = new FileWriter("C:\\Users\\User\\IdeaProjects\\DungeonDiver\\src\\HallOfLegends.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            StringBuilder string = new StringBuilder();
            int index = 0;
            string.append("\n\n").append(bs.getUser().getName()).append("'s party: ");
            for(Character chara : bs.getPartyMembers()){
                index++;
                string.append(index).append(". ").append(chara).append("\n");
            }
            bw.write(string.toString());
            bw.newLine();
            bw.close();
            fw.close();
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
