package ru.geekbrains.lesson8.impl.core;

import ru.geekbrains.lesson8.enums.DataType;

import java.util.ArrayList;

public class Player {

    protected boolean isWin;
    protected boolean turn;
    protected DataType playerCell;

    protected ArrayList<Integer> computerRowTactics;
    protected int chooseOneRowTactic;
    protected boolean isOneRowTacticChosen;

    public void setChooseOneRowTactic(int chooseOneRowTactic) {
        this.chooseOneRowTactic = chooseOneRowTactic;
    }

    public ArrayList<Integer> getComputerRowTactics() {
        return computerRowTactics;
    }

    public void setComputerRowTactics(ArrayList<Integer> computerRowTactics) {
        this.computerRowTactics = computerRowTactics;
    }

    public DataType getPlayerCell() {
        return playerCell;
    }

    public void setWin(boolean win) {
        isWin = win;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    public void setPlayerCell(DataType playerCell) {
        this.playerCell = playerCell;
    }

    @Override
    public String toString() {
        return "Player{" +
                "turn=" + turn +
                ", playerCell=" + playerCell +
                '}';
    }
}