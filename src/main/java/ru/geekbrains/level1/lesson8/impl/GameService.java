package ru.geekbrains.level1.lesson8.impl;

import ru.geekbrains.level1.lesson8.enums.DataType;
import ru.geekbrains.level1.lesson8.impl.core.Coordinates;

/**
 * Интерфейс связывающий бэкенд класс CrossZero и GUI интерфейс
 */

public interface GameService {

    void humanTurn(int rowIndex, int colIndex);

    Coordinates getAiTurnCoordinates();

    void gameInit();

    boolean isWinnerFound(DataType playerCell);

    boolean fieldHasEmpty();


}
