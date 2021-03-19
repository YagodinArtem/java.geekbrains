package ru.geekbrains.lesson8.gui;

import ru.geekbrains.lesson8.impl.GameService;
import ru.geekbrains.lesson8.settings.GameSettings;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    public MainWindow(GameService gameService, GameSettings gameSettings) {
        setLocationRelativeTo(null);
        setSize(800,800);
        setTitle("Крестики нолики 2.0");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setVisible(true);
    }

    public JPanel getGameFieldPanel() {
        //TODO 19/03 realise that
        //TODO 19/03 remake lssn7 HW
        return new JPanel();
    }




}
