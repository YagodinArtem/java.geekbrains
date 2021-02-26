package ru.geekbrains.lesson3;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GuessTheNumber {

    static int newGame = 1;
    static Scanner scanner;

    public static void main(String[] args) throws IOException {
        while (newGame != 0) {
            newGame();
        }
    }

    private static void newGame() throws IOException {
        System.out.println("Компьютер загадывает число от 0 до 9 вы должны угадать его с 3 попыток!");
        int random = getRandomNumber();
        int gamerChance;
        for (int i = 1; i < 4; i++) {
            System.out.println("\nПопытка номер - " + i + " ведите число:");
            gamerChance = getInputNumber();
            if (gamerChance > random) System.out.println("\nЗагаданное число меньше!");
            else if (gamerChance < random) System.out.println("\nЗагаданное число больше!");
            else {
                System.out.println("\nВы угадали! Желаете сыграть еще раз? 1 - да 0 - нет");
                newGame = getInputNumber();
                return;
            }
        }
        System.out.println("\nВы проиграли! Желаете сыграть еще раз? 1 - да 0 - нет");
        newGame = getInputNumber();
    }

    private static int getRandomNumber() {
        return (int) (Math.random() * 10);
    }

    private static int getInputNumber() {
        scanner = new Scanner(System.in);
        int input = 0;
        try {
           input = scanner.nextInt();
        }
        catch (InputMismatchException e) {
            System.out.println("Введите число, либо для выхода из приложения введите код: 9999");
            getInputNumber();
        }
        if (input == 9999) {
            System.out.println("Введен код выхода из приложения!");
            System.exit(0);
        }
        return input;
    }
}