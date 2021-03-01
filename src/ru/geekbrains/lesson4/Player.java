package ru.geekbrains.lesson4;

public class Player {

    protected boolean isWin;
    protected boolean turn;
    protected char playerCell;

    public boolean isWin() {
        return isWin;
    }

    public boolean isTurn() {
        return turn;
    }

    public char getPlayerCell() {
        return playerCell;
    }

    public void setWin(boolean win) {
        isWin = win;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    public void setPlayerCell(char playerCell) {
        this.playerCell = playerCell;
    }
}