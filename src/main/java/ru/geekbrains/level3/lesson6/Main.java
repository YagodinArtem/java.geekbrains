package ru.geekbrains.level3.lesson6;

import java.util.Arrays;

public class Main {

    public int[] lastFourExtractor(int[] inputArray) {
        for (int i = inputArray.length - 1; i >= 0; i--) {
            if (inputArray[i] == 4) {
                int[] result = new int[inputArray.length - 1 - i];
                System.arraycopy(inputArray, i + 1, result, 0, result.length);
                return result;
            }
        }
        throw new RuntimeException();
    }

    public boolean checkArrayContainsOneAndFour(int[] array) {
        return Arrays.stream(array).anyMatch(n -> n == 1)
                && Arrays.stream(array).anyMatch(n -> n == 4);
    }
}
