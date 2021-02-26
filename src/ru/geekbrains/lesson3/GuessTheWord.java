package ru.geekbrains.lesson3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GuessTheWord {


    private static final String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
            "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
            "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

    public static void main(String[] args) throws IOException {
        newGame();
    }

    private static void newGame() throws IOException {
        System.out.println("Игра началась! Компьютер загадал слово, ваша задача его отгадать.");
        boolean gamerChance = false;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String randomWord = words[getRandomNumber()];
        String gamerTry;
        while (!gamerChance) {
            gamerTry = reader.readLine();
            if (gamerTry.equals(randomWord)) {
                System.out.println("Вы угадали слово! Желаете сыграть еще раз? Введите yes или no");
                gamerChance = true;
                String nextGame = reader.readLine();
                if (nextGame.equals("yes")) newGame();
                else if ((nextGame.equals("no"))) System.exit(0);
            } else {
                showMatches(randomWord, gamerTry);
            }
        }
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
        return (int) (Math.random() * 26);
    }

}

