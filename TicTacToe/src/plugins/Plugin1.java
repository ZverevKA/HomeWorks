package plugins;

import Game.GameField;
import players.PlugBot;
import players.Player;
import players.WinTurnBot;

public class Plugin1 extends Player implements PlugBot {

    @Override
    public void chooseCell() {
        t++;
        y = t % gameField.SIZE;
        x = (t - y) / gameField.SIZE;
    }
    public int t = 0;

    @Override
    public String getName() {
        return "Plugin1";
    }
}
