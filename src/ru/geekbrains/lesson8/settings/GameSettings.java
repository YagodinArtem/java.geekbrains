package ru.geekbrains.lesson8.settings;

import lombok.Data;
import ru.geekbrains.lesson8.enums.DataType;


/**
 * Класс сохраняющий игровые настройки
 */
@Data
public final class GameSettings {
    private DataType playerCell;
    private DataType aiCell;
    private int fieldSize;
    private int cellsToWin;

    @Override
    public String toString() {
        return "GameSettings{" +
                "playerCell=" + playerCell +
                ", aiCell=" + aiCell +
                ", fieldSize=" + fieldSize +
                ", cellsToWin=" + cellsToWin +
                '}';
    }
}
