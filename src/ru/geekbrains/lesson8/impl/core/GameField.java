package ru.geekbrains.lesson8.impl.core;

import ru.geekbrains.lesson8.enums.DataType;
import ru.geekbrains.lesson8.settings.GameSettings;

import java.io.IOException;

public class GameField {

    private int gameFieldSize;
    private int cellsToWin;
    private DataType[][] gameField;

    public int getGameFieldSize() {
        return gameFieldSize;
    }

    public int getCellsToWin() {
        return cellsToWin;
    }

    DataType[][] getGameField() {
        return gameField;
    }

    void fillFieldWithEmpty() {
        gameField = new DataType[getGameFieldSize()][getGameFieldSize()];
        for (int i = 0; i < getGameFieldSize(); i++) {
            for (int j = 0; j < getGameFieldSize(); j++) {
                gameField[i][j] = DataType.E;
            }
        }
    }

    void print() {
        System.out.println();
        for (int i = 0; i <= gameFieldSize; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < gameFieldSize; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < gameFieldSize; j++) {
                System.out.print(gameField[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    void initializeField(GameSettings gameSettings) throws IOException {
        gameFieldSize = gameSettings.getFieldSize();
        cellsToWin = gameSettings.getFieldSize();
        fillFieldWithEmpty();
    }
}