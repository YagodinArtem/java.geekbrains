package ru.geekbrains.lesson4;

import java.io.IOException;

public class CrossZero {

    public static void main(String[] args){
        newGame();
    }

    private static void newGame() {
        GameField field = new GameField();
        try {
            field.initializeField();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        Player gamer = new Player();
        Player computer = new Player();
        gamer.setWin(false);
        computer.setWin(false);

        if (tossCoin()) {
            gamer.setTurn(true);
            computer.setTurn(false);
        } else {
            gamer.setTurn(false);
            computer.setTurn(true);
        }

        field.print();
    }

    private static boolean tossCoin() {
        int gamerChance = getRandomNumber();
        int computerChance = getRandomNumber();
        if (gamerChance > computerChance) {
            return true;
        } else if (gamerChance == computerChance) {
            return tossCoin();
        } else return false;
    }

    private static int getRandomNumber() {
        return (int) (Math.random() * 10);
    }
}