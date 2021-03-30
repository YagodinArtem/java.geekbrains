package ru.geekbrains.level1.lesson8.impl.core;

import ru.geekbrains.level1.lesson8.enums.DataType;
import ru.geekbrains.level1.lesson8.impl.GameService;
import ru.geekbrains.level1.lesson8.settings.GameSettings;

import java.io.IOException;

public class CrossZero implements GameService {

    private static GameField field;
    private static Player gamer;
    private static Player computer;
    private static GameSettings gameSettings;
    private static Coordinates coordinatesAI;

    /**
     * Бэкенд игры.
     * При создании объекта класса CrossZero в конструтор
     * передается класс с настройками для игры
     * @param gameSettings - настройки игры
     */
    public CrossZero(GameSettings gameSettings) {
        CrossZero.gameSettings = gameSettings;
    }

    private static void fieldInitialize() {
        field = new GameField();
        try {
            field.initializeField(gameSettings);
            field.print();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void gamersInitialize() {
        gamer = new Player();
        computer = new Player();
        gamer.setWin(false);
        computer.setWin(false);

        gamer.setPlayerCell(gameSettings.getPlayerCell());
        computer.setPlayerCell(gameSettings.getAiCell());

        if (gamer.getPlayerCell().equals(DataType.X)) {
            gamer.setTurn(true);
            computer.setTurn(false);
        } else {
            gamer.setTurn(false);
            computer.setTurn(true);
        }
        System.out.println("Gamer " + gamer.toString());
        System.out.println("AI " + computer.toString());
    }

    private static boolean findWinnerAllDim(DataType playerCell) {
        for (int i = 0; i < field.getGameFieldSize(); i++) {
            int cellsQuantityInRow = 1;
            int cellsQuantityInColumn = 1;
            for (int j = 0; j < field.getGameFieldSize() - 1; j++) {
                if (field.getGameField()[i][j] == playerCell
                        && field.getGameField()[i][j] == field.getGameField()[i][j + 1]) {
                    cellsQuantityInRow++;
                }
                if (field.getGameField()[j][i] == playerCell
                        && field.getGameField()[j][i] == field.getGameField()[j + 1][i]) {
                    cellsQuantityInColumn++;
                }
            }
            if (cellsQuantityInRow >= field.getCellsToWin() || cellsQuantityInColumn >= field.getCellsToWin()) {
                return true;
            }
        }

        if (field.getCellsToWin() < field.getGameFieldSize()) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    if (checkWinnerDiagonals(playerCell, i, j)) return true;
                }
            }
        } else {
            return checkWinnerDiagonals(playerCell);
        }
        return false;
    }

    private static boolean checkWinnerDiagonals(DataType playerCell) {
        boolean res = true;
        for (int i = 1; i < field.getGameFieldSize() && res; i++)
            res = field.getGameField()[i][i]
                    == field.getGameField()[0][0]
                    && field.getGameField()[i][i] == playerCell;
        if (res)
            return true;
        res = true;

        for (int i = 0; i < field.getGameFieldSize() && res; i++)
            res = field.getGameField()[field.getGameFieldSize() - i - 1][i] == playerCell;
        return res;
    }

    private static boolean checkWinnerDiagonals(DataType playerCell, int startY, int startX) {
        boolean resultLeft = true;
        boolean resultRight = true;
        for (int i = 1; i < field.getCellsToWin() && resultLeft; i++) {
            resultLeft = field.getGameField()[startY + i][startX + i] == field.getGameField()[startY][startX]
                    && field.getGameField()[startY + i][startX + i] == playerCell;
        }

        if (resultLeft) return true;

        for (int i = 1; i < field.getCellsToWin() && resultRight; i++) {
            resultRight = field.getGameField()[field.getCellsToWin() + startY - i][startX + i - 1]
                    == field.getGameField()[field.getCellsToWin() + startY - i - 1][startX + i]
                    && field.getGameField()[field.getCellsToWin() + startY - i][startX + i - 1] == playerCell;
        }
        return resultRight;
    }

    private static void computerRandomStrike() {
        if (isFieldHasEmpty()) {
            int Y = (int) (Math.random() * field.getGameFieldSize());
            int X = (int) (Math.random() * field.getGameFieldSize());
            if (field.getGameField()[X][Y] == DataType.E) {
                field.getGameField()[X][Y] = computer.playerCell;
                coordinatesAI = new Coordinates();
                coordinatesAI.setRowIndex(X);
                coordinatesAI.setColumnIndex(Y);
            } else computerRandomStrike();
        }
    }

    private static boolean isFieldHasEmpty() {
        for (int i = 0; i < field.getGameFieldSize(); i++) {
            for (int j = 0; j < field.getGameFieldSize(); j++) {
                if (field.getGameField()[i][j] == DataType.E) return true;
            }
        }
        return false;
    }

    @Override
    public boolean fieldHasEmpty() {
        return isFieldHasEmpty();
    }

    @Override
    public boolean isWinnerFound(DataType playerCell) {
        return !findWinnerAllDim(playerCell);
    }

    @Override
    public void humanTurn(int rowIndex, int colIndex) {
        field.getGameField()[rowIndex][colIndex] = gamer.getPlayerCell();
        computer.setTurn(true);
        gamer.setTurn(false);
        computerRandomStrike();
        field.print();
    }

    @Override
    public Coordinates getAiTurnCoordinates() {
        return coordinatesAI;
    }

    @Override
    public void gameInit() {
        gamersInitialize();
        fieldInitialize();
    }
}