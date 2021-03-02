package ru.geekbrains.lesson4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameField {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final int MIN_GAME_FIELD_SIZE = 3;
    private final int MID_GAME_FIELD_SIZE = 4;
    private final int MAX_GAME_FIELD_SIZE = 5;
    private int gameFieldSize;
    private int cellsToWin;
    private final char EMPTY_CELL = '•';
    private final char CELL_X = 'X';
    private final char CELL_O = 'O';
    private char[][] gameField;

    public int getGameFieldSize() {
        return gameFieldSize;
    }

    boolean setGameFieldSize(int gameFieldSize) {
        if (gameFieldSize >= MIN_GAME_FIELD_SIZE && gameFieldSize <= MAX_GAME_FIELD_SIZE) {
            this.gameFieldSize = gameFieldSize;
            return true;
        } else {
            System.out.print("Доступные размеры игрового поля: "
                    + MIN_GAME_FIELD_SIZE + ", " + MID_GAME_FIELD_SIZE + ", " + MAX_GAME_FIELD_SIZE + ", Ввод: ");
            return false;
        }
    }

    public int getCellsToWin() {
        return cellsToWin;
    }

    boolean setCellsToWin(int cellsToWin) {
        if (cellsToWin >= 3 && cellsToWin <= gameFieldSize) {
            this.cellsToWin = cellsToWin;
            return true;
        } else {
            System.out.print("Количество ячеек для победы не может быть меньше "
                    + MIN_GAME_FIELD_SIZE + " и быть больше размера игрового поля. Ввод:");
            return false;
        }
    }

    char getEMPTY_CELL() {
        return EMPTY_CELL;
    }

    char getCELL_X() {
        return CELL_X;
    }

    char getCELL_O() {
        return CELL_O;
    }

    char[][] getGameField() {
        return gameField;
    }

    void fillFieldWithEmpty() {
        gameField = new char[getGameFieldSize()][getGameFieldSize()];
        for (int i = 0; i < getGameFieldSize(); i++) {
            for (int j = 0; j < getGameFieldSize(); j++) {
                gameField[i][j] = getEMPTY_CELL();
            }
        }
    }

    void clear() {
//        try {
//            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
//        } catch (IOException | InterruptedException e) {
//            e.printStackTrace();
//        }
//        This method only works in commandline in windows
    }

    void print() {
        clear();
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

    void initializeField() throws IOException {
        System.out.print("Инициализация игрового поля. Доступные размеры игрового поля: "
                + MIN_GAME_FIELD_SIZE + ", " + MID_GAME_FIELD_SIZE + ", " + MAX_GAME_FIELD_SIZE + ", Ввод: ");
        while (!setGameFieldSize(getInputNumber())) {
        }
        System.out.print("Инициализация игрового поля. Введите количество ячеек для победы, минимум - "
                + MIN_GAME_FIELD_SIZE + " максимум - " + getGameFieldSize() + ", Ввод: ");
        while (!setCellsToWin(getInputNumber())) {
        }
        fillFieldWithEmpty();
    }


    private int getInputNumber() throws IOException {
        String input = reader.readLine();
        if (isNumeric(input)) return Integer.parseInt(input);
        else {
            System.out.print("Введите число! Ввод: ");
            return getInputNumber();
        }
    }

    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}