package Characters;

import java.util.ArrayList;

public class Party {
    ArrayList<Character> party;
    private int gold;

    public Party(){
        party = new ArrayList<>();
    }

    public Party(ArrayList<Character> party){
        if(party.size() > 4) {
            System.out.println("Party is invalid");
            return; //throw exception maybe
        }
        this.party = party;
        gold = 500;
    }

    public ArrayList<Character> getParty() {
        return party;
    }

    public void addMember(Character character){
        if(party.size() < 4) party.add(character);
        else System.out.println("Party is already full!");
    }

    public void addGold(int gold){
        this.gold += gold;
    }

    public void spendGold(int amount){
        this.gold -= amount;
    }

    public int getGold() {
        return gold;
    }

}
