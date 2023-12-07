package GameSystems;

import java.util.HashMap;

public class User {
    public String name;
    public String[] attacks = {"Punch", "Kick", "Poke", "Headbutt"};
    public String[] spells = {"Fireball", "Heal", "Iceball"};
    public HashMap<String, Integer> items = new HashMap<>(){{put("Potion", 2);put("Healing Pot", 4);}};
    public int score;
    public User(String name){
        this.name = name;
        score = 0;
    }
}
