package Game;

import players.Player;

public  class GameField {
    private int [][] field;
    public final int SIZE;
    public final int ROW_TO_WIN;
    public final int PLAYER0 = 0;
    public final int PLAYER1 = 1;
    public final int IN_PROGRESS = 2;
    public final int DRAW = 3;
    public final int PLAYER0_SIGN = 0;
    public final int PLAYER1_SIGN = 1;
    public final int EMPTY = 2;
    private int whoseTurn;
    private int gameStatus = IN_PROGRESS;
    public int numberOfSteps;
    public final int MAX_STEPS;

    public int getWhoseTurn(){
        return whoseTurn;
    }
    public int getCell(int x, int y){
        return field[x][y];
    }

    private boolean setCell(int x, int y, int turn){
        if ((x < SIZE) & (y < SIZE) & (x >= 0) & (y >= 0)){
            if (field[x][y] == EMPTY) {
                field[x][y] = turn;
                numberOfSteps++;
                updateGameStatus();
                whoseTurn = (whoseTurn + 1) % 2;
                return true;
            }
        }
        return false;
    }

    public boolean playerStep(Player player){
        player.chooseCell();
        return setCell(player.x, player.y, player.turn);
    }

    private boolean checkARow(int x, int y, int difX, int difY, int turn){
        if ((x + difX * (ROW_TO_WIN - 1)) >= SIZE){
            return false;
        }
        if ((y + difY * (ROW_TO_WIN - 1)) >= SIZE){
            return false;
        }
        if ((y + difY * (ROW_TO_WIN - 1)) < 0){
            return false;
        }
        for (int i = 0; i < ROW_TO_WIN; i++) {
            if (field[x + i * difX][y + i * difY] != turn) {
                return false;
            }
        }
        return true;
    }

    private boolean checkForWin(int turn){
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (checkARow(i, j, 1, 0, turn)){
                    return true;
                }
                if (checkARow(i, j, 0, 1, turn)){
                    return true;
                }
                if (checkARow(i, j, 1, 1, turn)){
                    return true;
                }
                if (checkARow(i, j, 1, -1, turn)){
                    return true;
                }

            }
        }
        return false;
    }

    private void updateGameStatus(){
        if (checkForWin(PLAYER0)){
            gameStatus = PLAYER0;
            return;
        }
        if (checkForWin(PLAYER1)){
            gameStatus = PLAYER1;
            return;
        }
        if (numberOfSteps == MAX_STEPS){
            gameStatus = DRAW;
            return;
        }
    }
    public int getGameStatus(){
        return gameStatus;
    }

    private void initField(){
        for (int i = 0; i < SIZE; i++){
            for (int j = 0; j < SIZE; j++){
                field[i][j] = EMPTY;
            }
        }
    }

    GameField(int SIZE){
        this.SIZE = SIZE;
        field = new int [SIZE][SIZE];
        numberOfSteps = 0;
        MAX_STEPS = SIZE * SIZE;
        if (SIZE == 3) {
            ROW_TO_WIN = 3;
        }
        else ROW_TO_WIN = 4;
        whoseTurn = PLAYER0;
        initField();
    }

}