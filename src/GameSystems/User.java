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
    public String getName() {
        return name;
    }
}
