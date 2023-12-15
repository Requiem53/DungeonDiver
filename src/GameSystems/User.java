package GameSystems;

public class User {
    private String name;
    private int score;
    public User(){
        this.name = "Anon";
        score = 0;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void addScore(int add){
        score += add;
    }
    public String getName() {
        return name;
    }
    public int getScore(){
        return score;
    }
}
