package ru.geekbrains.level1.lesson8.gui;

import ru.geekbrains.level1.lesson8.enums.DataType;

import javax.swing.*;
import java.awt.*;

public class PopupWindow extends JFrame {

    private JLabel announce;

    PopupWindow(DataType playerCell, JFrame frame) {
        setTitle("Желаете продолжить?");
        setAnnounce(playerCell);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setSize(350,100);

        JPanel buttons = new JPanel();
        buttons.setLayout(new GridLayout(1,2));
        JButton yes = new JButton();
        yes.setText("ДА");
        JButton no = new JButton();
        no.setText("НЕТ");


        yes.addActionListener(e -> {
            frame.setVisible(false);
            this.setVisible(false);
            new StartWindow();
        });

        no.addActionListener(e -> System.exit(0));

        buttons.add(no);
        buttons.add(yes);

        add(announce,BorderLayout.NORTH);
        add(buttons, BorderLayout.SOUTH);
        setVisible(true);
    }

    private void setAnnounce(DataType playerCell) {
        if (playerCell == DataType.E) {
            announce = new JLabel("Ничья, не осталось свободных ячеек");
        } else {
            announce = new JLabel("Игрок: " + playerCell.toString() + " одержал победу! Желаете продолжить?");
        }
    }
}
