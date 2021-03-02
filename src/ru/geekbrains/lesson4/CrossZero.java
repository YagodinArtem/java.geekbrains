package ru.geekbrains.lesson4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CrossZero {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static GameField field;
    private static Player gamer;
    private static Player computer;
    private static boolean isWinnerFind = false;
    private static boolean nextGame = true;


    public static void main(String[] args) throws IOException {
        try {
            while (nextGame) {
                newGame();
                isUserContinue();
            }
        } catch (StackOverflowError e) {
            e.printStackTrace();
        }

        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void newGame() {
        fieldInitialize();
        gamersInitialize();

        while (!isWinnerFind) {
            if (gamer.turn) {
                gamerMove();
                if (findWinner(gamer.playerCell)) {
                    gamer.setWin(true);
                    break;
                }
            } else {
                computerMove();
                if (findWinner(computer.playerCell)) {
                    computer.setWin(true);
                    break;
                }
            }
            field.print();
        }

        if (gamer.isWin) System.out.print("Вы победили! Желаете продолжить? Введите yes || no Ввод: \n");
        if (computer.isWin) System.out.print("Компьютер одержал победу! Желаете продолжить? Введите yes || no Ввод: \n");
        field.print();
    }

    private static void isUserContinue() throws IOException {
        String choice = reader.readLine();
        if (choice.equals("yes")) {
            nextGame = true;
        } else if (choice.equals("no")) {
            nextGame = false;
        } else {
            System.out.print("Введите yes || no Ввод: ");
            isUserContinue();
        }
    }

    private static void fieldInitialize() {
        field = new GameField();
        try {
            field.initializeField();
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

        if (tossCoin()) {
            gamer.setTurn(true);
            gamer.setPlayerCell(field.getCELL_X());
            gamer.setTurn(true);
            computer.setTurn(false);
            computer.setTurn(false);
            computer.setPlayerCell(field.getCELL_O());
        } else {
            gamer.setTurn(false);
            gamer.setPlayerCell(field.getCELL_O());
            gamer.setTurn(false);
            computer.setTurn(true);
            computer.setTurn(true);
            computer.setPlayerCell(field.getCELL_X());
        }
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

    private static void gamerMove() {
        System.out.print("\nВведите коориднаты в формате Y X (YпробелX) Ввод: ");
        try {
            String[] coordinates = reader.readLine().split(" ");
            int X = Integer.parseInt(coordinates[0]);
            int Y = Integer.parseInt(coordinates[1]);
            if (isCellValidAndEmpty(X, Y)) {
                field.getGameField()[X - 1][Y - 1] = gamer.getPlayerCell();
            } else {
                System.out.println("Введите валидные координаты!");
                gamerMove();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Введите координаты в формате YпробелX");
            gamerMove();
        } catch (NumberFormatException e) {
            System.out.println("Введите координаты в формате YпробелX, только числа!");
            gamerMove();
        }
        gamer.setTurn(false);
        computer.setTurn(true);
    }

    private static void computerMove() {
        if (computer.isOneRowTacticChosen) {
            computerMoveInRow();

        } else {
            findEmptyRows();
            if (computer.getComputerRowTactics().size() > 0) {
                chooseOneRandomRowTactic();
                computer.isOneRowTacticChosen = true;
                System.out.println((computer.chooseOneRowTactic) + " тактика выбрана");
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

    private static boolean findWinner(char playerCell) {
        return findWinnerHorizontal(playerCell) || findWinnerVertical(playerCell) || findWinnerDiagonale(playerCell);

    }

    private static boolean findWinnerHorizontal(char playerCell) {
        for (int i = 0; i < field.getGameFieldSize(); i++) {
            int cellsQuantityInRow = 1;
            for (int j = 0; j < field.getGameFieldSize() - 1; j++) {
                if (field.getGameField()[i][j] == playerCell
                        && field.getGameField()[i][j] == field.getGameField()[i][j + 1]) {
                    cellsQuantityInRow++;
                }
            }
            if (cellsQuantityInRow >= field.getCellsToWin()) {
                return true;
            }
        }
        return false;
    }

    private static boolean findWinnerVertical(char playerCell) {
        for (int i = 0; i < field.getGameFieldSize(); i++) {
            int cellsQuantityInRow = 1;
            for (int j = 0; j < field.getGameFieldSize() - 1; j++)
                if (field.getGameField()[j][i] == playerCell
                        && field.getGameField()[j][i] == field.getGameField()[j + 1][i]) {
                    cellsQuantityInRow++;
                }
            if (cellsQuantityInRow >= field.getCellsToWin()) {
                return true;
            }

        }
        return false;
    }

    private static boolean findWinnerDiagonale(char playerCell) {
        //TODO find winner by diagonale, improve computer ii blocking gamer tactics, newGame if all cells are locked,
        // realise ii tactic change if win is not possible in such row or column
        return false;
    }

    private static void computerRandomStrike() {
        int Y = (int) (Math.random() * field.getGameFieldSize());
        int X = (int) (Math.random() * field.getGameFieldSize());
        if (field.getGameField()[Y][X] == field.getEMPTY_CELL()) {
            field.getGameField()[Y][X] = computer.playerCell;
        } else computerRandomStrike();
    }

    private static void computerMoveInRow() {
        if (isCurrentTacticPossible()) {
            try {
                field.getGameField()[computer.chooseOneRowTactic][findEmptyCellInRow()] = computer.playerCell;
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

    private static boolean isCurrentTacticPossible() {
        int emptyCells = 0;
        for (int i = 0; i < field.getGameFieldSize(); i++) {
            if (field.getGameField()[computer.chooseOneRowTactic][i] == field.getEMPTY_CELL()
                    || field.getGameField()[computer.chooseOneRowTactic][i] == computer.playerCell) {
                emptyCells++;
            }
        }
        return emptyCells == field.getGameFieldSize();
    }

    private static int findEmptyCellInRow() {
        int random = (int) (Math.random() * field.getGameFieldSize());
        if (field.getGameField()[computer.chooseOneRowTactic][random] == field.getEMPTY_CELL()) {
            return random;
        } else return findEmptyCellInRow();
    }

    private static boolean isCellValidAndEmpty(int X, int Y) {
        if (X < 0 || X > field.getGameFieldSize() || Y < 0 || Y > field.getGameFieldSize()) return false;
        return field.getGameField()[X - 1][Y - 1] == field.getEMPTY_CELL();
    }

    private static void findEmptyRows() {
        ArrayList<Integer> emptyRows = new ArrayList<>();
        for (int i = 0; i < field.getGameFieldSize(); i++) {
            int rowSize = 0;
            for (int j = 0; j < field.getGameFieldSize(); j++) {
                if (field.getGameField()[i][j] == field.getEMPTY_CELL()) {
                    rowSize++;
                }
            }
            if (rowSize == field.getGameFieldSize()) {
                emptyRows.add(i);
            }
        }

        for (int i : emptyRows) {
            System.out.println(i + " это номер пустой строки");
        }
        computer.setComputerRowTactics(emptyRows);
    }

    private static void chooseOneRandomRowTactic() {
        int random = (int) (Math.random() * computer.getComputerRowTactics().size());
        try {
            computer.setChooseOneRowTactic(computer.getComputerRowTactics().get(random));
            computer.isOneRowTacticChosen = true;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Не осталось пустых строк!");
        }
    }
}