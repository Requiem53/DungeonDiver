public class Turn extends State{
    public Turn(BattleSystem bs) {
        super(bs);
    }

    @Override
    public void Start() {
        bs.incrementTurn();
        if(bs.characters.get(bs.getCurrentTurn()).isPlayable()){
            bs.setState(new PlayerTurn(bs));
        } else {
            bs.setState(new EnemyTurn(bs));
        }

    }
}
