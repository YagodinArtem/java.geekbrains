package ru.geekbrains.lesson8.impl.core;

import ru.geekbrains.lesson8.enums.DataType;
import ru.geekbrains.lesson8.impl.GameService;
import ru.geekbrains.lesson8.settings.GameSettings;

import java.io.IOException;
import java.util.ArrayList;

public class CrossZero implements GameService {

    private static GameField field;
    private static Player gamer;
    private static Player computer;
    private static GameSettings gameSettings;
    private static Coordinates coordinatesAI;

    /**
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

    private static void computerMove() {
        if (computer.isOneRowTacticChosen) {
            computerMoveInRow();
        } else {
            findEmptyRows();
            if (computer.getComputerRowTactics().size() > 0) {
                chooseOneRandomRowTactic();
                computer.isOneRowTacticChosen = true;
            } else {
                try {
                    computerRandomStrike();
                    computer.setTurn(false);
                    gamer.setTurn(true);
                } catch (StackOverflowError e) {
                    System.out.println("computerRandomStrike");
                    e.printStackTrace();
                }
            }
        }
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
        int Y = (int) (Math.random() * field.getGameFieldSize());
        int X = (int) (Math.random() * field.getGameFieldSize());
        if (field.getGameField()[Y][X] == DataType.E) {
            field.getGameField()[Y][X] = computer.playerCell;
            coordinatesAI.setRowIndex(X);
            coordinatesAI.setColumnIndex(Y);
        } else computerRandomStrike();
    }

    private static void computerMoveInRow() {
        if (isCurrentTacticPossible()) {
            try {
                int emptyCellInRow = findEmptyCellInRow();
                field.getGameField()[computer.chooseOneRowTactic][emptyCellInRow] = computer.playerCell;
                coordinatesAI.setRowIndex(computer.chooseOneRowTactic);
                coordinatesAI.setColumnIndex(emptyCellInRow);
            } catch (StackOverflowError e) {
                System.out.println("computerMoveInRow");
                e.printStackTrace();
            }
            computer.setTurn(false);
            gamer.setTurn(true);
        } else {
            computer.isOneRowTacticChosen = false;
            computer.setTurn(true);
            gamer.setTurn(false);

        }
    }

    private static int findEmptyCellInRow() {
        int random = (int) (Math.random() * field.getGameFieldSize());
        if (field.getGameField()[computer.chooseOneRowTactic][random] == DataType.E) {
            return random;
        } else return findEmptyCellInRow();
    }

    private static boolean isCellValidAndEmpty(int X, int Y) {
        if (X < 0 || X > field.getGameFieldSize() || Y < 0 || Y > field.getGameFieldSize()) return false;
        return field.getGameField()[X - 1][Y - 1] == DataType.E;
    }

    private static void findEmptyRows() {
        ArrayList<Integer> emptyRows = new ArrayList<>();
        for (int i = 0; i < field.getGameFieldSize(); i++) {
            int rowSize = 0;
            for (int j = 0; j < field.getGameFieldSize(); j++) {
                if (field.getGameField()[i][j] == DataType.E) {
                    rowSize++;
                }
            }
            if (rowSize == field.getGameFieldSize()) {
                emptyRows.add(i);
            }
        }
        computer.setComputerRowTactics(emptyRows);
    }

    /**
     * Проверят есть ли на поле пустая ячейка
     * @return false or true
     */
    private static boolean isFieldHasEmpty() {
        for (int i = 0; i < field.getGameFieldSize(); i++) {
            for (int j = 0; j < field.getGameFieldSize(); j++) {
                if (field.getGameField()[i][j] == DataType.E) return true;
            }
        }
        return false;
    }

    /**
     * Выбирает одну из возможных тактик игры, а именно
     * строку в которой AI будет пытаться закрыть необохдимое
     * количество ячеек
     */
    private static void chooseOneRandomRowTactic() {
        int random = (int) (Math.random() * computer.getComputerRowTactics().size());
        try {
            computer.setChooseOneRowTactic(computer.getComputerRowTactics().get(random));
            computer.isOneRowTacticChosen = true;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Не осталось пустых строк!");
        }
    }

    /**
     * Проверяет логично ли следовать выбранной тактике
     * (хавтит ли пустых ячеек для победы)
     */
    private static boolean isCurrentTacticPossible() {
        int emptyCells = 0;
        for (int i = 0; i < field.getGameFieldSize(); i++) {
            if (field.getGameField()[computer.chooseOneRowTactic][i] == DataType.E
                    || field.getGameField()[computer.chooseOneRowTactic][i] == computer.playerCell) {
                emptyCells++;
            }
        }
        return emptyCells == field.getGameFieldSize();
    }

    @Override
    public void humanTurn(int rowIndex, int colIndex) {
        computerMove();
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