package ru.geekbrains.level1.lesson8.entrance;

import ru.geekbrains.level1.lesson8.gui.StartWindow;
import java.io.IOException;

public class GameStart {

    /**
     * Точка входа в приложение
     *
     * Что реализовано:
     * 1. Реализовано задание 8 урока, а именно окно с вводом настроек пользователя.
     * 2. Добавлена проверка некорректного ввода пользователем.
     * 3. Реализовано игровое окно на базе задания из 4 урока.
     * 4. Логика игры ИИ рандом.
     * 5. Реализовано всплывающее окно после завершения игры, предлагающее начать новую игру.
     * 6. Выполнен отлов багов.
     *
     * Что нереализовано:
     * 1. Интересный ИИ
     * 2. Различные тактики ИИ
     */

    public static void main(String[] args) throws IOException {
        new StartWindow();
    }
}
