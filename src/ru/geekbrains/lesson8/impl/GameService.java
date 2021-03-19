package ru.geekbrains.lesson8.impl;

import ru.geekbrains.lesson8.impl.core.Coordinates;

/**
 * Интерфейс связывающий бэкенд класс CrossZero и GUI интерфейс
 */

public interface GameService {

    void humanTurn(int rowIndex, int colIndex);

    Coordinates getAiTurnCoordinates();

    void gameInit();
}
