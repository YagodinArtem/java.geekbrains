package ru.geekbrains.lesson8.gui;

import ru.geekbrains.lesson8.enums.DataType;
import ru.geekbrains.lesson8.impl.GameService;
import ru.geekbrains.lesson8.impl.core.CrossZero;
import ru.geekbrains.lesson8.settings.FieldConst;
import ru.geekbrains.lesson8.settings.GameSettings;

import javax.swing.*;
import java.awt.*;

public class StartWindow extends JFrame {

    /**
     * Класс начального окна GUI для ввода настроек пользователя.
     * Для сохранения настроек используется класс GameSettings.
     * В качестве ядра игры создается объект класса GameService
     * методами которого будет пользоваться GUI.
     */

    private static GameSettings gameSettings;

    public StartWindow() {
        setLocationRelativeTo(null);
        setSize(400,120);
        setTitle("Крестики нолики 2.0");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        add(getUserInputPanel());
        setVisible(true);
    }

    public JPanel getUserInputPanel() {
        gameSettings = new GameSettings();
        JPanel userInput = new JPanel();
        userInput.setLayout(new BorderLayout());

        int USER_INPUT_GRID = 2;
        JPanel gridPanel = new JPanel(new GridLayout(USER_INPUT_GRID, USER_INPUT_GRID));

        JLabel chooseSide = new JLabel();
        chooseSide.setText("Выберите сторону");

        JTextField fieldSizeInput = new JTextField();
        fieldSizeInput.setText("Введите число от " +
                FieldConst.MIN_FIELD_SIZE + " до " + FieldConst.MAX_FIELD_SIZE);
        JLabel enterFieldSize = new JLabel();
        enterFieldSize.setText("Выберите размер игрового поля");

        gridPanel.add(chooseSide);
        gridPanel.add(getRadioBtnPanel());
        gridPanel.add(enterFieldSize);
        gridPanel.add(fieldSizeInput);
        userInput.add(gridPanel, BorderLayout.NORTH);
        userInput.add(getEnterButton(fieldSizeInput), BorderLayout.SOUTH);

        return userInput;
    }

    public JPanel getRadioBtnPanel() {
        JPanel radioBtnPanel = new JPanel();
        radioBtnPanel.setLayout(new GridLayout(1, 2));

        JRadioButton rbX = getRadioButton(DataType.X.toString());
        JRadioButton rbO = getRadioButton(DataType.O.toString());

        ButtonGroup radioButtons = new ButtonGroup();
        radioButtons.add(rbX);
        radioButtons.add(rbO);

        radioBtnPanel.add(rbX);
        radioBtnPanel.add(rbO);

        return radioBtnPanel;
    }

    public JRadioButton getRadioButton(String text) {
        JRadioButton btn = new JRadioButton();
        btn.setText(text);
        if (text.equals(DataType.X.toString())) {
            btn.setSelected(true);
            setGamersCells(DataType.X, DataType.O);
        }
        btn.addActionListener(e -> {
            if (btn.isSelected() && text.equals(DataType.O.toString())) setGamersCells(DataType.O, DataType.X);
            else if (btn.isSelected() && text.equals(DataType.X.toString())) setGamersCells(DataType.X, DataType.O);
        });
        return btn;
    }

    public void setGamersCells(DataType playerCell, DataType aiCell) {
        gameSettings.setPlayerCell(playerCell);
        gameSettings.setAiCell(aiCell);
        System.out.println(gameSettings.toString());
    }

    /**
     * Возвращает кнопку Enter, в слушателе которой при вводе валидных данных
     * создается объект класса CrossZero (бэкенд игры), которому в конструкторе
     * передаются введенные настройки, также создается основное окно игры, которому
     * тоже передаются настройки для построения игрового экрана.
     */
    public JButton getEnterButton(JTextField textField) {
        JButton enterBtn = new JButton("Принять");
        enterBtn.addActionListener(e -> {
            String text = textField.getText();
            if (text != null && !text.equals("") && isGameFieldSizeValid(text)) {
                gameSettings.setFieldSize(Integer.parseInt(textField.getText()));
                gameSettings.setCellsToWin(Integer.parseInt(textField.getText()));
                System.out.println(gameSettings.toString());

                GameService coreEngine = new CrossZero(gameSettings);
                coreEngine.gameInit();
                new MainWindow(coreEngine, gameSettings);
                this.setVisible(false);
            } else {
                textField.setText("Введите число от " +
                        FieldConst.MIN_FIELD_SIZE + " до " + FieldConst.MAX_FIELD_SIZE);
            }
        });
        return enterBtn;
    }

    /**
     * Метод необходим для проверки корректности ввода размера игрового поля
     */
    private boolean isNumber(String text) {
        if (text == null || text.isEmpty()) return false;
        for (int i = 0; i < text.length(); i++) if (!Character.isDigit(text.charAt(i))) return false;
        return true;
    }

    /**
     * Метод необходим для проверки корректности ввода размера игрового поля
     */
    private boolean isGameFieldSizeValid(String text) {
        return (isNumber(text)
                && Integer.parseInt(text)
                >= FieldConst.MIN_FIELD_SIZE
                && Integer.parseInt(text)
                <= FieldConst.MAX_FIELD_SIZE);
    }
}
