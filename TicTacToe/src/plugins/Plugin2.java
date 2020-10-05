package plugins;

import players.Player;
import players.PlugBot;
import players.WinTurnBot;

import java.util.Random;

public class Plugin2 extends WinTurnBot implements PlugBot {
    public void chooseCell() {
        x = new Random().nextInt(gameField.SIZE);
        y = new Random().nextInt(gameField.SIZE);

    }

    @Override
    public String getName() {
        return "Plugin2";
    }
}
