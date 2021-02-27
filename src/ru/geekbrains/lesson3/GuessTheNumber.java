package ru.geekbrains.lesson3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GuessTheNumber {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static int gameRangeEndPoint = 10;
    static int gameRangeStartPoint = 0;
    static int nextGame = 1;
    static boolean isUserWin = false;
    static int gamerTry = 3;

    public static void main(String[] args) throws IOException {
        while (nextGame == 1) {
            try {
                game();
                isUserContinue(isUserWin);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        reader.close();
    }

    private static void game() throws IOException {
        System.out.println("\nНовая игра! Вам необходимо угадать число, которое загадал компьютер от "
                + gameRangeStartPoint + " до " + (gameRangeEndPoint-1) + " c " + gamerTry + " попыток");
        gamerTry = 3;
        int randomNumber = getRandomNumber();
        int gamerChance;
        while (gamerTry > 0) {
            gamerTry--;
            System.out.print("Ввод: ");
            gamerChance = getInputNumber();
            if (gamerChance == randomNumber) {
                isUserWin = true;
                break;
            } else if (gamerChance > randomNumber) System.out.print("Загаданное число меньше! ");
            else System.out.print("Загаданное число больше! ");
            if (gamerTry == 0) isUserWin = false;
        }
    }

    private static int getInputNumber() throws IOException {
        String input = reader.readLine();
        if (isNumeric(input) &&
                Integer.parseInt(input) > gameRangeStartPoint &&
                Integer.parseInt(input) < gameRangeEndPoint) return Integer.parseInt(input);
        else {
            System.out.println("Введите число! В диапазоне от 0 до " + (gameRangeEndPoint-1));
            return getInputNumber();
        }
    }

    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static void isUserContinue(boolean isUserWin) throws IOException {
        if (isUserWin) System.out.print("Вы победили :D Желаете сыграть еще раз? 1 - да, 0 - нет, ввод: ");
        else System.out.print("Вы проиграли :( Желаете сыграть еще раз? 1 - да, 0 - нет, ввод: ");
        String choice = reader.readLine();
        if (choice.equals("1")) {
            nextGame = 1;
        } else if (choice.equals("0")) {
            nextGame = 0;
        } else isUserContinue(isUserWin);
    }

    private static int getRandomNumber() {
        return (int) (Math.random() * gameRangeEndPoint);
    }
}