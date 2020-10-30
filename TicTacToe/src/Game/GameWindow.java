package Game;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JPanel {
    GameField gameField;
    public final int CELL_SIZE = 100;
    ImageIcon img0 = new ImageIcon("res/1pl.png");
    ImageIcon img1 = new ImageIcon("res/2pl.png");
    ImageIcon img3 = new ImageIcon("res/whb.png");
    ImageIcon img4 = new ImageIcon("res/draw.png");


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int status = gameField.getGameStatus();
        if (status == gameField.IN_PROGRESS) {
            for (int i = 0; i < gameField.SIZE; i++) {
                for (int j = 0; j < gameField.SIZE; j++) {
                    if (gameField.getCell(i, j) == gameField.EMPTY) {
                        g.drawImage(img3.getImage(), i * CELL_SIZE, j * CELL_SIZE, this);
                    }
                    if (gameField.getCell(i, j) == gameField.PLAYER0_SIGN) {
                        g.drawImage(img0.getImage(), i * CELL_SIZE, j * CELL_SIZE, this);
                    }
                    if (gameField.getCell(i, j) == gameField.PLAYER1_SIGN) {
                        g.drawImage(img1.getImage(), i * CELL_SIZE, j * CELL_SIZE, this);
                    }
                }
            }
        }
        if (status == gameField.PLAYER0) {
            g.drawImage(img0.getImage(), ((gameField.SIZE - 1) * CELL_SIZE) / 2, ((gameField.SIZE - 2) * CELL_SIZE) / 2, this);
            g.drawString("VICTORY!", gameField.SIZE * CELL_SIZE / 2 - 20, gameField.SIZE * CELL_SIZE - 50);
        }
        if (status == gameField.PLAYER1) {
            g.drawImage(img1.getImage(), ((gameField.SIZE - 1) * CELL_SIZE) / 2, ((gameField.SIZE - 1) * CELL_SIZE) / 2, this);
            g.drawString("VICTORY!", gameField.SIZE * CELL_SIZE / 2 - 20, gameField.SIZE * CELL_SIZE - 50);
        }
        if (status == gameField.DRAW) {
            g.drawImage(img4.getImage(), ((gameField.SIZE - 1) * CELL_SIZE) / 2, ((gameField.SIZE - 1) * CELL_SIZE) / 2, this);
            g.drawString("It's a draw!", gameField.SIZE * CELL_SIZE / 2 - 40, gameField.SIZE * CELL_SIZE - 50);
        }

        }
        public GameWindow(GameField gameField) {
            this.gameField = gameField;

        }
}
