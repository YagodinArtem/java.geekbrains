package ru.geekbrains.level1.lesson3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GuessTheWord {


    private static final String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
            "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
            "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static boolean nextGame;

    public static void main(String[] args) throws IOException {
        newGame();
        reader.close();
    }

    private static void newGame() throws IOException {
        System.out.println("Игра началась! Компьютер загадал слово, ваша задача его отгадать.");
        String randomWord = words[getRandomNumber()];
        String gamerTry;
        while (true) {
            gamerTry = reader.readLine();
            if (gamerTry.equals(randomWord)) {
                isUserContinue();
                if (nextGame) newGame();
                else System.exit(0);
            } else {
                showMatches(randomWord, gamerTry);
            }
        }
    }

    private static void isUserContinue() throws IOException {
        System.out.println("Вы угадали слово! Желаете сыграть еще раз? Введите yes или no");
        String choice = reader.readLine();
        if (choice.equals("yes")) {
            nextGame = true;
        } else if (choice.equals("no")) {
            nextGame = false;
        } else isUserContinue();
    }

    private static void showMatches(String randomWord, String gamerTry) {
        String[] gamerTryChars = gamerTry.split("");
        String[] randomWordChars = randomWord.split("");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < Math.min(gamerTryChars.length, randomWordChars.length); i++) {
            if (gamerTryChars[i].equals(randomWordChars[i])) sb.append(gamerTryChars[i]);
            else sb.append('#');
        }
        System.out.println(String.format("%-15s",sb.toString()).replace(' ', '#'));
    }

    private static int getRandomNumber() {
        return (int) (Math.random() * words.length-1);
    }

}

