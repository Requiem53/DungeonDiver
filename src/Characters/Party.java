package Characters;

import java.util.ArrayList;

public class Party {
    ArrayList<Character> party;

    public Party(){
        party = new ArrayList<>();
    }

    public Party(ArrayList<Character> party){
        if(party.size() > 4) {
            System.out.println("Party is invalid");
            return; //throw exception maybe
        }
        this.party = party;
    }

    public ArrayList<Character> getParty() {
        return party;
    }

    public void addMember(Character character){
        if(party.size() < 4) party.add(character);
        else System.out.println("Party is already full!");
    }
}
