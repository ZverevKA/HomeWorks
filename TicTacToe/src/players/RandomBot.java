package players;

import Game.GameField;
import players.Player;

import java.util.Random;

public class RandomBot extends Player{

    public RandomBot() {name = "RandomBot";}

    public void chooseCell() {
        x = new Random().nextInt(gameField.SIZE);
        y = new Random().nextInt(gameField.SIZE);
    }



}
