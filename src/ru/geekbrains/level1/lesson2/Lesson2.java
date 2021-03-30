package ru.geekbrains.level1.lesson2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class Lesson2 {

    public static void main(String[] args) {
        oneToZeroConvert(new int[]{1, 1, 0, 0, 1, 0, 1, 1, 0, 0});
        arrayInitializer(8);
        lessSixMultiply(new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1});
        diagonalElementsToOne(10);
        minMaxFinder(new int[]{15, 2, 1598, 4, 68, 6, 1597, 189, 9, -69});
        minMaxFinder(new int[0]);
        minMaxFinder2(new int[]{15, 2, 1598, 4, 68, 6, 1597, 189, 9, -69});
        minMaxFinder2(new int[0]);
        System.out.println("\n" + checkBalance(new int[]{2, 2, 2, 1, 2, 2, 10, 1}));
        System.out.println("\n" + checkBalance(new int[]{1, 1, 1, 2, 1}));
        System.out.println("\n" + checkBalance(new int[]{3, 3, 0, 3, 3}));
        System.out.println("\n" + checkBalance(new int[]{3, 3, 0, 0, 3}));
        elementPositionMover(new int[]{1, 2, 3, 4, 5, 6}, -1);
        elementPositionMover(new int[]{1, 2, 3, 4, 5, 6}, 15);
        elementPositionMover2(new int[]{1, 2, 3, 4, 5, 6}, -1);
        elementPositionMover2(new int[]{1, 2, 3, 4, 5, 6}, 15);
    }

    private static void oneToZeroConvert(int[] arrayOfInts) {
        System.out.println(Arrays.toString(arrayOfInts) + " - start version");
        for (int i = 0; i < arrayOfInts.length; i++) {
            if (arrayOfInts[i] > 0) arrayOfInts[i] = 0;
            else arrayOfInts[i] = 1;
        }
        System.out.println(Arrays.toString(arrayOfInts) + " - after method works\n");
    }

    private static void arrayInitializer(int arrayLength) {
        int[] arrayOfInts = new int[arrayLength];
        for (int i = 0; i < arrayOfInts.length; i++)
            arrayOfInts[i] = i * 3;
        System.out.println(Arrays.toString(arrayOfInts) + "\n");
    }

    private static void lessSixMultiply(int[] arrayOfInts) {
        System.out.println(Arrays.toString(arrayOfInts) + " - start version");
        for (int i = 0; i < arrayOfInts.length; i++)
            if (arrayOfInts[i] < 6) arrayOfInts[i] *= 2;
        System.out.println(Arrays.toString(arrayOfInts) + " - after method works\n");
    }

    private static void diagonalElementsToOne(int matrixSize) {
        int[][] matrix = new int[matrixSize][matrixSize];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i == j || i + j == matrix.length - 1) matrix[i][j] = 1;
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void minMaxFinder(int[] arrayOfInts) {
        int min, max;
        if (arrayOfInts != null && arrayOfInts.length > 0) {
            min = arrayOfInts[0];
            max = arrayOfInts[0];
            for (int i : arrayOfInts) {
                if (i < min) min = i;
                else if (i > max) max = i;
            }
            System.out.println("\nРешение первым способом:\nМинимальное значение: " + min + " Максимальное значение: " + max);
        } else System.out.println("\nМассив пуст!");

    }

    private static void minMaxFinder2(int[] arrayOfInts) {
        if (arrayOfInts != null && arrayOfInts.length > 0) {
            Arrays.sort(arrayOfInts);
            System.out.println("\nРешение вторым способом:\nМинимальное значение: " + arrayOfInts[0]
                    + " Максимальное значение: " + arrayOfInts[arrayOfInts.length - 1]);
        } else System.out.println("\nМассив пуст!");
    }

    private static boolean checkBalance(int[] array) {
        int leftSum = 0;
        int rightSum = 0;

        for (int j : array) rightSum += j;
        for (int i = 1; i < array.length; i++) {
            leftSum += array[i - 1];
            rightSum -= array[i - 1];
            if (leftSum == rightSum) return true;
        }
        return false;
    }

    private static void elementPositionMover(int[] array, int n) {
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                int lastElement = array[array.length - 1];
                for (int j = 0; j < array.length; j++) {
                    int current = array[j];
                    array[j] = lastElement;
                    lastElement = current;
                }
            }
        } else if (n < 0) {
            for (int i = n; i < 0; i++) {
                int firstElement = array[0];
                for (int j = array.length - 1; j >= 0; j--) {
                    int current = array[j];
                    array[j] = firstElement;
                    firstElement = current;
                }
            }
        }
        else System.out.println("N равно нулю");
        System.out.println("\nFirst position mover method " + Arrays.toString(array));
    }

    private static void elementPositionMover2(int[] array, int n) {
        HashMap<Integer, Integer> valuesAndNewPositions = new HashMap<>();
        if (n == 0) System.out.println("\nN равняется нулю!");
        else if (n > 0) {
            for (int i = 0; i < array.length; i++) {
                int newIndex = (n % array.length) + i;
                if (newIndex >= array.length) newIndex -= array.length;
                valuesAndNewPositions.put(newIndex, array[i]);
            }
            for (Map.Entry<Integer, Integer> mapEntrySet : valuesAndNewPositions.entrySet())
                array[mapEntrySet.getKey()] = mapEntrySet.getValue();
        } else {
            for (int i = 0; i < array.length; i++) {
                int newIndex = (n % array.length) + i;
                if (newIndex < 0) newIndex += array.length;
                valuesAndNewPositions.put(newIndex, array[i]);
            }
            for (Map.Entry<Integer, Integer> mapEntrySet : valuesAndNewPositions.entrySet())
                array[mapEntrySet.getKey()] = mapEntrySet.getValue();
        }
        System.out.println("\nSecond position mover method " + Arrays.toString(array));
    }
}