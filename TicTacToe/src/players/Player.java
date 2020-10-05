package players;

import Game.Game;
import Game.GameField;

public abstract class Player{
    protected String name;
    public int turn;
    public GameField gameField;
    public int x;
    public int y;
    abstract public void chooseCell();
    public void setTurn(int turn){
        this.turn = turn;
    }
    public void setGameField(GameField gameField){
        this.gameField = gameField;
    }
    public String getName(){
        return name;
    }
    public Player(){};


}
