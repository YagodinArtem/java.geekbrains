package ru.geekbrains.lesson8.settings;

import lombok.Getter;


/**
 * Класс строковых констант для вывода в status bar
 */

@Getter
public final class GameMessage {
    private String winner;
    private final String noEmptyCells = "Ничья, не осталось свободных ячеек!";
    private final String aiMove = "Ход компьютера";
    private final String playerMove = "Ход игрока";
    private final String nextGame = "Желаете продолжить?";

    public String setWinner(String winner) {
        if (winner.equals("E")) return "Не осталось свободных ячеек!";
        this.winner = winner + " одержал победу!";
        return this.winner;
    }
}
