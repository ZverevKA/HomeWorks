package Game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import players.HumanPlayer;
import players.Player;

import static org.junit.jupiter.api.Assertions.*;

class GameFieldTest {

    private GameField gameField1;
    private Player player1, player2;

    @BeforeEach
    public void setUp(){
        player1 = new HumanPlayer();
        player2 = new HumanPlayer();
        gameField1 = new GameField(3);
        player1.setTurn(gameField1.PLAYER0);
        player2.setTurn(gameField1.PLAYER1);
        player1.setGameField(gameField1);
        player2.setGameField(gameField1);
        gameField1 = new GameField(3);
        player1.x = 1;
        player1.y = 1;
        gameField1.playerStep(player1);
        player2.x = 2;
        player2.y = 2;
        gameField1.playerStep(player2);


    }




    @Test
    void getCell() {
        assertEquals(gameField1.getCell(1,1), gameField1.PLAYER0);
        assertEquals(gameField1.getCell(2, 2), gameField1.PLAYER1);
        assertEquals(gameField1.getCell(0, 0), gameField1.EMPTY);

    }
    @Test
    void getGameStatus(){
        assertEquals(gameField1.getGameStatus(), gameField1.EMPTY);
        player1.x = 2;
        player1.y = 1;
        gameField1.playerStep(player1);
        player2.x = 2;
        player2.y = 0;
        gameField1.playerStep(player2);
        player1.x = 0;
        player1.y = 1;
        gameField1.playerStep(player1);
        assertEquals(gameField1.getGameStatus(), gameField1.PLAYER0);
    }
}