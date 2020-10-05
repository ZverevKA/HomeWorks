package players;

import Game.GameField;

import java.util.Random;

public class WinTurnBot extends Player{


    public int[][] field;
    public void chooseCell() {
        if (findWinTurn()){
            return;
        }
        do {
            x = new Random().nextInt(gameField.SIZE);
            y = new Random().nextInt(gameField.SIZE);
        } while (gameField.getCell(x, y) != gameField.EMPTY);
        return;
    }


    public boolean findWinTurn(){
        updateField();
        for (int i = 0; i < gameField.SIZE; i++){
            for (int j = 0; j < gameField.SIZE; j++){
                if (field[i][j] == gameField.EMPTY){
                    field[i][j] = this.turn;
                    if (checkForWin()) {
                        x = i;
                        y = j;
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public WinTurnBot(){name = "WinTurnBot";
    }

    @Override
    public void setGameField(GameField gameField) {
        super.setGameField(gameField);
        field = new int[gameField.SIZE][gameField.SIZE];
    }

    public void updateField(){
        for (int i = 0; i < gameField.SIZE; i++){
            for (int j = 0; j < gameField.SIZE; j++){
                field[i][j] = gameField.getCell(i, j);
            }
        }
    }
    public boolean checkRow(int x, int y, int difX, int difY){
        if ((x + difX * (gameField.ROW_TO_WIN - 1)) >= gameField.SIZE){
            return false;
        }
        if ((y + difY * (gameField.ROW_TO_WIN - 1)) >= gameField.SIZE){
            return false;
        }
        if ((y + difY * (gameField.ROW_TO_WIN - 1)) < 0){
            return false;
        }
        for (int i = 0; i < gameField.ROW_TO_WIN; i++) {
            if (field[x + i * difX][y + i * difY] != this.turn) {
                return false;
            }
        }
        return true;
    }

    public boolean checkForWin(){
        for (int i = 0; i < gameField.SIZE; i++) {
            for (int j = 0; j < gameField.SIZE; j++) {
                if (checkRow(i, j, 1, 0)){
                    return true;
                }
                if (checkRow(i, j, 0, 1)){
                    return true;
                }
                if (checkRow(i, j, 1, 1)){
                    return true;
                }
                if (checkRow(i, j, 1, -1)){
                    return true;
                }

            }
        }
        return false;
    }



}
