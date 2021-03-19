package ru.geekbrains.lesson8.gui;

import ru.geekbrains.lesson8.enums.DataType;
import ru.geekbrains.lesson8.impl.GameService;
import ru.geekbrains.lesson8.impl.core.Coordinates;
import ru.geekbrains.lesson8.settings.GameMessage;
import ru.geekbrains.lesson8.settings.GameSettings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {

    private final String DOT_EMPTY = "*";

    private final GameSettings gameSettings;
    private final GameService gameService;
    private JButton[][] buttons;
    private final JLabel statusBar;
    private GameMessage gameMessage = new GameMessage();
    private Coordinates coordinates;
    private boolean isWinnerFind = false;
    private boolean isGameStopped = false;


    public MainWindow(GameService gameService, GameSettings gameSettings) {
        this.gameService = gameService;
        this.gameSettings = gameSettings;
        statusBar = new JLabel();
        statusBar.setPreferredSize(new Dimension(100, 50));

        setLocationRelativeTo(null);
        setSize( 400, 400);
        setTitle("Крестики нолики 2.0");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel gridPanel = getGameFieldPanel();

        add(gridPanel);
        add(statusBar, BorderLayout.SOUTH);
        statusBar.setText(gameMessage.getPlayerMove());

        setVisible(true);
    }

    public JPanel getGameFieldPanel() {
        int mapSize = gameSettings.getFieldSize();
        JPanel gridPanel = new JPanel(new GridLayout(mapSize, mapSize));
        buttons = new JButton[mapSize][mapSize];
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {

                JButton gameCellButton = new JButton(DOT_EMPTY);
                gameCellButton.putClientProperty("INDEX_ROW", i);
                gameCellButton.putClientProperty("INDEX_COLUMN", j);

                gameCellButton.addActionListener(getActionListener());

                buttons[i][j] = gameCellButton;
                gridPanel.add(gameCellButton);
            }
        }

        return gridPanel;
    }


    private ActionListener getActionListener() {
        return e -> {
            JButton sourceBtn = (JButton) (e.getSource());
            int indexRow = (int) sourceBtn.getClientProperty("INDEX_ROW");
            int indexColumn = (int) sourceBtn.getClientProperty("INDEX_COLUMN");
            humanTurn(indexRow, indexColumn, sourceBtn);
            aiTurn();
            noEmptyCellsStop();
        };
    }

    public void humanTurn(int indexRow, int indexColumn, JButton sourceBtn) {
        gameService.humanTurn(indexRow, indexColumn);
        sourceBtn.setEnabled(false);
        sourceBtn.setText(gameSettings.getPlayerCell().toString());
        checkWin(gameSettings.getPlayerCell());
    }

    public void aiTurn() {
        coordinates = gameService.getAiTurnCoordinates();
        if (coordinates != null) {
            statusBar.setText("Компьютер походил в ячейку x:" + (coordinates.getColumnIndex() + 1)
                    + " y:" + (coordinates.getRowIndex() + 1));
        }
        JButton aiTurnButton = buttons[coordinates.getRowIndex()][coordinates.getColumnIndex()];
        aiTurnButton.setEnabled(false);
        aiTurnButton.setText(gameSettings.getAiCell().toString());
        checkWin(gameSettings.getAiCell());
    }

    public void checkWin(DataType playerCell) {
        if (!gameService.isWinnerFound(playerCell) && !isWinnerFind) {
            isWinnerFind = true;
            disableAllButtonsWithMark(playerCell.toString());
            if (playerCell == gameSettings.getAiCell()) statusBar.setText(gameMessage.setWinner("Компьютер"));
            else statusBar.setText(gameMessage.setWinner("Игрок"));
            new PopupWindow(playerCell, this);
        }
    }

    private void noEmptyCellsStop() {
        if (!gameService.fieldHasEmpty() && !isWinnerFind){
            isGameStopped = true;
            disableAllButtonsWithMark(DataType.E.toString());
            statusBar.setText(gameMessage.getNoEmptyCells());
            new PopupWindow(DataType.E,this);
        }
    }

    private void disableAllButtonsWithMark(String text) {
        if (text.equals((DataType.E).toString())) {
            for (JButton[] button : buttons) {
                for (int j = 0; j < buttons.length; j++) {
                    button[j].setEnabled(false);
                    button[j].setText(text);
                }
            }
        } else {
            for (JButton[] button : buttons) {
                for (int j = 0; j < buttons.length; j++) {
                    button[j].setEnabled(false);
                }
            }
        }
    }

}

