package GameSystems;

import Characters.Character;
import Characters.Party;
import GUI.GameWindow;
import Interfaces.Action;
import States.*;

import javax.swing.*;
import java.util.*;
import java.util.List;

public class BattleSystem extends StateMachine{
    public User user;
    private int currentTurn = -1;

    private final Party party;

    List<Action> actions = new ArrayList<>();
    Queue<Action> actionsSorted = new LinkedList<>();

    public GameWindow gameWindow;
    public JPanel bottomPanel_topPart;
    public JPanel scorePanel;
    public JPanel dungeonLevelPanel;

    public BattleSystem(){
        user = new User();
        party = new Party();
        scorePanel = new JPanel();
        dungeonLevelPanel = new JPanel();
        bottomPanel_topPart = new JPanel();
        gameWindow = new GameWindow();
        setState(new EnterName(this));
    }

    public void clearActions(){
        actions.clear();
        actionsSorted.clear();
    }

    public String restParty(){
        for (Character partyMember : getPartyMembers()){
            System.out.println(partyMember.fullyRest());
        }
        return "The whole party is rejuvenated!";
    }

    public static String outputCharacters(List<Character> characters){
        StringBuilder string = new StringBuilder();
        for(int i=0; i < characters.size(); i++){
            string.append(i + 1).append(". ").append(characters.get(i)).append("\n");
        }
        return string.toString();
    }

    public void addAction(Action action){
        actions.add(action);
    }
    public void sortActions(){
        Collections.sort(actions);
        actionsSorted = new LinkedList<>(actions);
    }
    public Action dequeueActionsSorted(){
        if(actionsSorted.isEmpty()){
            return null;
        }
        return actionsSorted.remove();
    }
    public void actionListsReset(){
        actions.clear();
        actionsSorted.clear();
        currentTurn = -1;
    }
    public void incrementTurn(){
        currentTurn++;
    }
    public void decrementTurn(){
        currentTurn--;
    }
    public int getCurrentTurn(){
        return currentTurn;
    }
    public boolean currCharIsAlly(){
        return getCurrChar() instanceof Character.Ally;
    }
    public ArrayList<Character> getLivingAllies(){
        ArrayList<Character> livingAllies = new ArrayList<>();
        for(Character chara : getPartyMembers()){
            if(chara.isAlive()){
                livingAllies.add(chara);
            }
        }
        return livingAllies;
    }
    public void removeAllNotBPSP(){
        JPanel bp = gameWindow.bottomPanel;
        bp.removeAll();
        if(bottomPanel_topPart == null) return;
        bp.add(bottomPanel_topPart);
    }
    public boolean panelRevalRepaint(JPanel panel){
        panel.revalidate();
        panel.repaint();
        return true;
    }

    //Getters
    public Queue<Action> getActionsSorted() {
        return actionsSorted;
    }
    public Character getCurrChar(){
//        return getPartyMembers().get(getCurrentTurn());
        return State.queueChoice.peek();
    }
    public User getUser(){
        return user;
    }
    public Party getParty() {
        return party;
    }
    public ArrayList<Character> getPartyMembers(){
        return getParty().getParty();
    }
}
