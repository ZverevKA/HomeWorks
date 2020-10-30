package Game;

import players.HumanPlayer;
import players.Player;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Game extends JFrame {

    Player player0, player1;
    GameField gameField;
    private int gameMode = 0;
    private final int BotVSBot = 0;
    private final int HumanVSBot = 1;
    private final int BotVSHuman = 2;
    private final int HumanVSHuman = 3;
    public void setGameMode(){
        gameMode = 0;
        if (player0 instanceof HumanPlayer){
            gameMode += 1;
        }
        if (player1 instanceof  HumanPlayer){
            gameMode += 2;
        }
    }

    public void start(Player player0, Player player1, GameField gameField){
        this.player0 = player0;
        this.player1 = player1;
        this.gameField = gameField;
        setGameMode();
        GameWindow window = new GameWindow(gameField);
        JFrame frame = new JFrame();
        frame.setBounds(250, 250, window.CELL_SIZE * gameField.SIZE + 15, window.CELL_SIZE * gameField.SIZE + 38);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(window);
        frame.setVisible(true);

        if (gameMode == BotVSBot) {
            while (gameField.getGameStatus() == gameField.IN_PROGRESS) {
                while (!(gameField.playerStep(player0)));
                window.repaint();
                if (gameField.getGameStatus() != gameField.IN_PROGRESS) {
                    break;
                }
                while (true){
                    if (gameField.playerStep(player1)){
                        break;
                    }
                }
                window.repaint();
            }
            System.out.println(gameField.getGameStatus());
        }
        if (gameMode == HumanVSBot){
            window.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    if ((gameField.getWhoseTurn() == gameField.PLAYER0) && (gameField.getGameStatus() == gameField.IN_PROGRESS)){
                        player0.x = e.getX() / window.CELL_SIZE;
                        player0.y = e.getY() / window.CELL_SIZE;
                        gameField.playerStep(player0);
                        window.repaint();
                        if ((gameField.getWhoseTurn() == gameField.PLAYER1) && (gameField.getGameStatus() == gameField.IN_PROGRESS)) {
                            while (!gameField.playerStep(player1));
                            window.repaint();
                        }
                    }

                }
            });

            }
        if (gameMode == BotVSHuman){
            while (!gameField.playerStep(player0));
            window.repaint();
            window.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    if ((gameField.getWhoseTurn() == gameField.PLAYER1) && (gameField.getGameStatus() == gameField.IN_PROGRESS)){
                        player1.x = e.getX() / window.CELL_SIZE;
                        player1.y = e.getY() / window.CELL_SIZE;
                        gameField.playerStep(player1);
                        window.repaint();
                        if ((gameField.getWhoseTurn() == gameField.PLAYER0) && (gameField.getGameStatus() == gameField.IN_PROGRESS)) {
                            while (!gameField.playerStep(player0));
                            window.repaint();
                        }
                    }
                }
            });
        }
        if (gameMode == HumanVSHuman){
            window.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    if ((gameField.getWhoseTurn() == gameField.PLAYER0) && (gameField.getGameStatus() == gameField.IN_PROGRESS)){
                        player0.x = e.getX() / window.CELL_SIZE;
                        player0.y = e.getY() / window.CELL_SIZE;
                        gameField.playerStep(player0);
                        window.repaint();
                    }
                }
            });
            window.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    if ((gameField.getWhoseTurn() == gameField.PLAYER1) && (gameField.getGameStatus() == gameField.IN_PROGRESS)) {
                        player1.x = e.getX() / window.CELL_SIZE;
                        player1.y = e.getY() / window.CELL_SIZE;
                        gameField.playerStep(player1);
                        window.repaint();
                    }
                }

            });
        }

    }


}
