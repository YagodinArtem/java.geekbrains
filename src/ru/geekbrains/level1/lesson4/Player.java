package ru.geekbrains.level1.lesson4;

import java.util.ArrayList;

public class Player {

    protected boolean isWin;
    protected boolean turn;
    protected char playerCell;

    protected ArrayList<Integer> computerRowTactics;
    protected int chooseOneRowTactic;
    protected boolean isOneRowTacticChosen;

    public void setOneRowTacticChosen(boolean oneRowTacticChosen) {
        isOneRowTacticChosen = oneRowTacticChosen;
    }

    public int getChooseOneRowTactic() {
        return chooseOneRowTactic;
    }

    public void setChooseOneRowTactic(int chooseOneRowTactic) {
        this.chooseOneRowTactic = chooseOneRowTactic;
    }

    public ArrayList<Integer> getComputerRowTactics() {
        return computerRowTactics;
    }

    public void setComputerRowTactics(ArrayList<Integer> computerRowTactics) {
        this.computerRowTactics = computerRowTactics;
    }

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